#include <SoftwareSerial.h>

#define PIN_RX 2   // Grün (optional Debug)
#define PIN_TX 3   // Gelb → Controller

SoftwareSerial ctrlSerial(PIN_RX, PIN_TX);

uint8_t frame[14] = {
  0x51, 0x10, 0x09,
  0x35,       // Mode
  0x00,
  0x88,
  0x00,       // [6]
  0x00,       // [7]
  0x1E,       // [8]
  0x00,       // [9]
  22,         // [10] baseline speed
  0x03,       // [11]
  0x00,       // checksum
  0xAE
};

uint8_t testIndex = 6;   // wir testen nur relevante Bytes
uint8_t testValue = 22;

unsigned long lastSend = 0;
unsigned long lastChange = 0;

#define SEND_INTERVAL 200
#define CHANGE_INTERVAL 4000  // alle 4 Sekunden neues Byte

void setup() {
  Serial.begin(115200);
  ctrlSerial.begin(19200);

  Serial.println("=== BYTE SWEEP TEST ===");
}

// Checksum
uint8_t calcChecksum() {
  uint8_t sum = 0;
  for (int i = 0; i < 12; i++) sum += frame[i];
  return sum & 0xFF;
}

void loop() {

  // alle 4 Sekunden: nächstes Byte / Wert
  if (millis() - lastChange > CHANGE_INTERVAL) {
    lastChange = millis();

    testValue += 5;
    if (testValue > 50) {
      testValue = 10;
      testIndex++;

      if (testIndex > 11) testIndex = 6;
    }

    Serial.print("\n[TEST] Byte ");
    Serial.print(testIndex);
    Serial.print(" = ");
    Serial.println(testValue);

    frame[testIndex] = testValue;
  }

  // senden
  if (millis() - lastSend > SEND_INTERVAL) {
    lastSend = millis();

    frame[12] = calcChecksum();

    ctrlSerial.write(frame, 14);
  }

  // optional: Controller Output
  while (ctrlSerial.available()) {
    uint8_t b = ctrlSerial.read();
    Serial.print(b, HEX);
    Serial.print(" ");
  }
}