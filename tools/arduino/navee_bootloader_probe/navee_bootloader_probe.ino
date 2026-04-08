/*
 * NAVEE BLDC Bootloader Probe
 *
 * Sendet verschiedene Bootloader-Entry-Befehle auf Gelb
 * und lauscht auf Grün nach 'C' (0x43) oder anderen Antworten.
 *
 * GELB NICHT TRENNEN! Arduino parallel dazuklemmen.
 * Dashboard bleibt verbunden → kein Piepen.
 * Arduino 5V überschreibt 3.8V Dashboard-Signal kurzzeitig.
 *
 * Verkabelung:
 *   Gelb  ──→ Arduino D3 (TX, parallel zum Dashboard)
 *   Grün  ──→ Arduino D2 (RX, parallel zum Dashboard)
 *   Schwarz ──→ GND
 *   USB ──→ Mac (115200 Baud)
 *
 * Ablauf:
 *   1. Sketch starten
 *   2. 's' drücken → startet Probe-Sequenz
 *   3. Beobachten ob auf Grün ein 'C' oder ACK kommt
 *   4. Falls ja → Bootloader gefunden!
 */

#include <SoftwareSerial.h>

#define PIN_RX_GREEN   2  // Controller TX (Grün) mitlesen
#define PIN_TX_YELLOW  3  // Controller RX (Gelb) senden

SoftwareSerial ctrlSerial(PIN_RX_GREEN, PIN_TX_YELLOW);

unsigned long startTime = 0;

void setup() {
  Serial.begin(115200);
  ctrlSerial.begin(19200);
  pinMode(PIN_TX_YELLOW, INPUT);  // D3 hochohmig — stört Gelb NICHT!

  Serial.println(F("=== NAVEE BOOTLOADER PROBE ==="));
  Serial.println(F("D3 hochohmig (kein Piepen!)"));
  Serial.println(F("Wird nur beim Senden aktiviert."));
  Serial.println(F(""));
  Serial.println(F("Befehle:"));
  Serial.println(F("  s = Alle Probe-Sequenzen starten"));
  Serial.println(F("  1 = STM32-style sync (0x7F)"));
  Serial.println(F("  2 = 'down dfu_start 2' text"));
  Serial.println(F("  3 = LKS32 boot pattern"));
  Serial.println(F("  4 = XMODEM 'C' senden"));
  Serial.println(F("  5 = Navee Yellow DFU frame"));
  Serial.println(F("  l = 10s lauschen (nur Grün)"));
  Serial.println(F("=============================="));
  startTime = millis();
}

void loop() {
  // Grün mitlesen und alles anzeigen
  while (ctrlSerial.available()) {
    uint8_t b = ctrlSerial.read();
    float t = (millis() - startTime) / 1000.0;
    Serial.print(F("["));
    Serial.print(t, 1);
    Serial.print(F("s] RX: 0x"));
    if (b < 0x10) Serial.print('0');
    Serial.print(b, HEX);

    if (b == 0x43) Serial.print(F("  *** 'C' XMODEM READY! ***"));
    else if (b == 0x06) Serial.print(F("  *** ACK ***"));
    else if (b == 0x15) Serial.print(F("  *** NAK ***"));
    else if (b >= 0x20 && b <= 0x7E) { Serial.print(F("  '")); Serial.print((char)b); Serial.print(F("'")); }

    Serial.println();
  }

  if (Serial.available()) {
    char c = Serial.read();
    switch (c) {
      case 's': probeAll(); break;
      case '1': probeSyncByte(); break;
      case '2': probeDfuText(); break;
      case '3': probeLKS32(); break;
      case '4': probeXmodemC(); break;
      case '5': probeYellowDfu(); break;
      case 'l': listen(10000); break;
    }
  }
}

void enableTX() {
  ctrlSerial.begin(19200);  // Aktiviert TX-Pin
}

void disableTX() {
  pinMode(PIN_TX_YELLOW, INPUT);  // Zurück auf hochohmig
}

void sendAndListen(const char* name, const uint8_t* data, uint8_t len, unsigned long waitMs) {
  Serial.print(F("\n--- "));
  Serial.print(name);
  Serial.println(F(" ---"));
  Serial.print(F("TX: "));
  for (uint8_t i = 0; i < len; i++) {
    if (data[i] < 0x10) Serial.print('0');
    Serial.print(data[i], HEX);
    Serial.print(' ');
  }
  Serial.println();

  enableTX();
  ctrlSerial.write(data, len);
  delay(5);
  disableTX();
  listen(waitMs);
}

void sendTextAndListen(const char* name, const char* text, unsigned long waitMs) {
  Serial.print(F("\n--- "));
  Serial.print(name);
  Serial.println(F(" ---"));
  Serial.print(F("TX: '"));
  Serial.print(text);
  Serial.println(F("'"));

  enableTX();
  ctrlSerial.print(text);
  delay(5);
  disableTX();
  listen(waitMs);
}

void listen(unsigned long ms) {
  unsigned long start = millis();
  bool gotData = false;
  while (millis() - start < ms) {
    while (ctrlSerial.available()) {
      uint8_t b = ctrlSerial.read();
      if (!gotData) {
        Serial.print(F("  Response: "));
        gotData = true;
      }
      if (b < 0x10) Serial.print('0');
      Serial.print(b, HEX);
      Serial.print(' ');

      if (b == 0x43) Serial.print(F(" ***'C'*** "));
      if (b == 0x06) Serial.print(F(" ***ACK*** "));
      if (b == 0x15) Serial.print(F(" ***NAK*** "));
    }
  }
  if (gotData) Serial.println();
  else Serial.println(F("  No response."));
}

// === PROBE 1: STM32/GD32 sync byte ===
void probeSyncByte() {
  uint8_t sync[] = {0x7F};
  sendAndListen("STM32 Sync (0x7F)", sync, 1, 3000);

  // Try multiple times
  for (int i = 0; i < 5; i++) {
    ctrlSerial.write(0x7F);
    delay(100);
  }
  listen(2000);
}

// === PROBE 2: Text DFU commands ===
void probeDfuText() {
  sendTextAndListen("dfu_start 2", "down dfu_start 2\r", 3000);
  sendTextAndListen("dfu_start", "down dfu_start\r", 3000);
  sendTextAndListen("dfu_start 0", "down dfu_start 0\r", 3000);
  sendTextAndListen("boot", "boot\r", 3000);
  sendTextAndListen("update", "update\r", 3000);
  sendTextAndListen("download", "download\r", 3000);
}

// === PROBE 3: LKS32MC081 patterns ===
void probeLKS32() {
  // Try various known Linkosemi patterns
  uint8_t pat1[] = {0x5A, 0xA5};  // Common Chinese MCU sync
  sendAndListen("LKS32 sync 5A A5", pat1, 2, 3000);

  uint8_t pat2[] = {0xAA, 0x55};  // Alternative sync
  sendAndListen("LKS32 sync AA 55", pat2, 2, 3000);

  uint8_t pat3[] = {0x55, 0xAA};  // Navee BLE header
  sendAndListen("Navee header 55 AA", pat3, 2, 3000);

  uint8_t pat4[] = {0x7E, 0x00, 0x00};  // HDLC-style
  sendAndListen("HDLC 7E 00 00", pat4, 3, 3000);

  // Break sequence
  uint8_t brk[] = {0x00, 0x00, 0x00, 0x00};
  sendAndListen("Break (4x 0x00)", brk, 4, 3000);
}

// === PROBE 4: Send 'C' (XMODEM initiator) ===
void probeXmodemC() {
  uint8_t c = 0x43;
  sendAndListen("XMODEM 'C'", &c, 1, 3000);
}

// === PROBE 5: Yellow-wire DFU frame ===
void probeYellowDfu() {
  // Normal frame with different CMD byte (maybe 0x20 = DFU?)
  // Try various CMD values that might trigger bootloader
  uint8_t cmds[] = {0x20, 0x30, 0x40, 0x50, 0x02, 0x0F, 0xFF};

  for (uint8_t ci = 0; ci < sizeof(cmds); ci++) {
    uint8_t frame[14];
    frame[0] = 0x51;       // Yellow header
    frame[1] = cmds[ci];   // Try different CMDs
    frame[2] = 0x09;       // Length
    frame[3] = 0x00;
    frame[4] = 0x00;
    frame[5] = 0x00;
    frame[6] = 0x00;
    frame[7] = 0x00;
    frame[8] = 0x00;
    frame[9] = 0x00;
    frame[10] = 0x00;
    frame[11] = 0x00;
    // Checksum
    uint8_t chk = 0;
    for (uint8_t j = 0; j < 12; j++) chk += frame[j];
    frame[12] = chk;
    frame[13] = 0xAE;     // Yellow footer

    char name[32];
    snprintf(name, sizeof(name), "Yellow CMD 0x%02X", cmds[ci]);
    sendAndListen(name, frame, 14, 2000);
  }
}

// === ALL PROBES ===
void probeAll() {
  Serial.println(F("\n============================="));
  Serial.println(F(" STARTING ALL PROBES"));
  Serial.println(F("============================="));

  probeSyncByte();
  probeDfuText();
  probeLKS32();
  probeXmodemC();
  probeYellowDfu();

  Serial.println(F("\n============================="));
  Serial.println(F(" ALL PROBES DONE"));
  Serial.println(F("============================="));
}
