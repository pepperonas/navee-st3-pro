package com.uz.navee.utils;

import android.util.Log;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f13291a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public a f13292b;

    public interface a {
        void a();

        void b(h hVar);
    }

    public void a(h hVar) {
        a aVar;
        if (this.f13291a != null) {
            Log.e("Post", "任务加入排队中" + hVar.f13283a);
            if (!c() && (aVar = this.f13292b) != null) {
                aVar.b(hVar);
            }
            this.f13291a.addLast(hVar);
        }
    }

    public void b() {
        if (this.f13291a != null) {
            for (int i6 = 0; i6 < this.f13291a.size(); i6++) {
                h hVar = (h) this.f13291a.get(i6);
                hVar.b();
                this.f13291a.remove(hVar);
            }
        }
    }

    public boolean c() {
        LinkedList linkedList = this.f13291a;
        return linkedList != null && linkedList.size() > 0;
    }

    public final void d(h hVar) {
        if (this.f13291a != null) {
            for (int i6 = 0; i6 < this.f13291a.size(); i6++) {
                h hVar2 = (h) this.f13291a.get(i6);
                if (hVar.f13283a.equals(hVar2.f13283a)) {
                    this.f13291a.remove(hVar2);
                    return;
                }
            }
        }
    }

    public void e(h hVar) {
        d(hVar);
        if (this.f13291a != null) {
            if (c()) {
                a aVar = this.f13292b;
                if (aVar != null) {
                    aVar.b((h) this.f13291a.getFirst());
                    return;
                }
                return;
            }
            a aVar2 = this.f13292b;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    public void setOnTaskListener(a aVar) {
        this.f13292b = aVar;
    }
}
