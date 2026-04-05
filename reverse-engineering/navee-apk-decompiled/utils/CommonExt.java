package com.uz.navee.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.clj.fastble.data.BleDevice;
import com.uz.navee.bean.DeviceCarInfo;
import com.uz.navee.bean.DeviceHomePageInfo;
import com.uz.navee.bean.Observable;
import com.uz.navee.bean.Vehicle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes3.dex */
public abstract class CommonExt {

    public static final class a implements Observer, kotlin.jvm.internal.u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.l f13259a;

        public a(q5.l function) {
            kotlin.jvm.internal.y.f(function, "function");
            this.f13259a = function;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.u)) {
                return kotlin.jvm.internal.y.a(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.u
        public final kotlin.c getFunctionDelegate() {
            return this.f13259a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13259a.invoke(obj);
        }
    }

    public static final int b(Context context, int i6) {
        kotlin.jvm.internal.y.f(context, "<this>");
        return DensityUtil.a(context, i6);
    }

    public static final int c(View view, float f7) {
        kotlin.jvm.internal.y.f(view, "<this>");
        return DensityUtil.a(view.getContext(), f7);
    }

    public static final int d(View view, int i6) {
        kotlin.jvm.internal.y.f(view, "<this>");
        return DensityUtil.a(view.getContext(), i6);
    }

    public static final BleDevice e(Activity activity) {
        kotlin.jvm.internal.y.f(activity, "<this>");
        Bundle bundleExtra = activity.getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            return (BleDevice) f(bundleExtra, "bleDevice", BleDevice.class);
        }
        return null;
    }

    public static final Object f(Bundle bundle, String key, Class clazz) {
        kotlin.jvm.internal.y.f(bundle, "<this>");
        kotlin.jvm.internal.y.f(key, "key");
        kotlin.jvm.internal.y.f(clazz, "clazz");
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelable(key, clazz) : bundle.getParcelable(key);
    }

    public static final Serializable g(Bundle bundle, String key, Class clazz) {
        kotlin.jvm.internal.y.f(bundle, "<this>");
        kotlin.jvm.internal.y.f(key, "key");
        kotlin.jvm.internal.y.f(clazz, "clazz");
        return Build.VERSION.SDK_INT >= 33 ? bundle.getSerializable(key, clazz) : (Serializable) clazz.cast(bundle.getSerializable(key));
    }

    public static final Vehicle h(Activity activity) {
        kotlin.jvm.internal.y.f(activity, "<this>");
        Bundle bundleExtra = activity.getIntent().getBundleExtra("data");
        if (bundleExtra != null) {
            return (Vehicle) g(bundleExtra, "vehicle", Vehicle.class);
        }
        return null;
    }

    public static final boolean i(Boolean bool) {
        return kotlin.jvm.internal.y.a(bool, Boolean.FALSE);
    }

    public static final boolean j(Boolean bool) {
        return kotlin.jvm.internal.y.a(bool, Boolean.TRUE);
    }

    public static final LiveData k(AppCompatActivity appCompatActivity, Object obj, String property) {
        kotlin.jvm.internal.y.f(appCompatActivity, "<this>");
        kotlin.jvm.internal.y.f(property, "property");
        return l(appCompatActivity.getLifecycle(), obj, property);
    }

    public static final LiveData l(Lifecycle lifecycle, Object obj, String property) {
        kotlin.jvm.internal.y.f(lifecycle, "<this>");
        kotlin.jvm.internal.y.f(property, "property");
        DeviceCarInfo carInfo = b4.a.W().f1933f;
        kotlin.jvm.internal.y.e(carInfo, "carInfo");
        return m(lifecycle, carInfo, obj, property);
    }

    public static final LiveData m(Lifecycle lifecycle, final Observable observable, Object obj, final String str) {
        final MutableLiveData mutableLiveData = new MutableLiveData(obj);
        final PropertyChangeListener propertyChangeListener = new PropertyChangeListener() { // from class: com.uz.navee.utils.g
            @Override // java.beans.PropertyChangeListener
            public final void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                CommonExt.n(mutableLiveData, propertyChangeEvent);
            }
        };
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: com.uz.navee.utils.CommonExt$observerDevice$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onCreate(LifecycleOwner owner) {
                kotlin.jvm.internal.y.f(owner, "owner");
                observable.addListener(str, propertyChangeListener);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                kotlin.jvm.internal.y.f(owner, "owner");
                observable.removeListener(str, propertyChangeListener);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.c(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.d(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.e(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.c.f(this, lifecycleOwner);
            }
        });
        return mutableLiveData;
    }

    public static final void n(MutableLiveData liveDate, PropertyChangeEvent propertyChangeEvent) {
        kotlin.jvm.internal.y.f(liveDate, "$liveDate");
        Object newValue = propertyChangeEvent.getNewValue();
        if (newValue == null) {
            newValue = null;
        }
        liveDate.setValue(newValue);
    }

    public static final LiveData o(Lifecycle lifecycle, Object obj, String property) {
        kotlin.jvm.internal.y.f(lifecycle, "<this>");
        kotlin.jvm.internal.y.f(property, "property");
        DeviceHomePageInfo homePageInfo = b4.a.W().f1931d;
        kotlin.jvm.internal.y.e(homePageInfo, "homePageInfo");
        return m(lifecycle, homePageInfo, obj, property);
    }

    public static final void p(Intent intent, BleDevice bleDevice, Vehicle vehicle, String str) {
        kotlin.jvm.internal.y.f(intent, "<this>");
        Bundle bundle = new Bundle();
        bundle.putParcelable("bleDevice", bleDevice);
        bundle.putSerializable("vehicle", vehicle);
        bundle.putString("meterVer", str);
        intent.putExtra("data", bundle);
    }

    public static /* synthetic */ void q(Intent intent, BleDevice bleDevice, Vehicle vehicle, String str, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            vehicle = null;
        }
        if ((i6 & 4) != 0) {
            str = null;
        }
        p(intent, bleDevice, vehicle, str);
    }

    public static final void r(Activity activity, Class cls, BleDevice bleDevice, Vehicle vehicle, String str) {
        kotlin.jvm.internal.y.f(activity, "<this>");
        kotlin.jvm.internal.y.f(cls, "cls");
        if (b4.a.f(bleDevice)) {
            Intent intent = new Intent(activity, (Class<?>) cls);
            p(intent, bleDevice, vehicle, str);
            activity.startActivity(intent);
        }
    }

    public static final kotlin.u s(Context context, String str) {
        kotlin.jvm.internal.y.f(context, "<this>");
        if (str == null) {
            return null;
        }
        Toast.makeText(context, str, 0).show();
        return kotlin.u.f15726a;
    }

    public static final void t(Context context, int i6) {
        kotlin.jvm.internal.y.f(context, "<this>");
        Toast.makeText(context, i6, 0).show();
    }

    public static final LiveData u(LiveData liveData, LiveData other) {
        kotlin.jvm.internal.y.f(liveData, "<this>");
        kotlin.jvm.internal.y.f(other, "other");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        mediatorLiveData.addSource(liveData, new a(new q5.l() { // from class: com.uz.navee.utils.CommonExt$zipNonNull$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m124invoke(obj);
                return kotlin.u.f15726a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m124invoke(Object obj) {
                if (obj != 0) {
                    ref$ObjectRef.element = obj;
                    Object obj2 = ref$ObjectRef2.element;
                    if (obj2 != null) {
                        mediatorLiveData.setValue(kotlin.k.a(obj, obj2));
                    }
                }
            }
        }));
        mediatorLiveData.addSource(other, new a(new q5.l() { // from class: com.uz.navee.utils.CommonExt$zipNonNull$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // q5.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m125invoke(obj);
                return kotlin.u.f15726a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m125invoke(Object obj) {
                if (obj != 0) {
                    ref$ObjectRef2.element = obj;
                    Object obj2 = ref$ObjectRef.element;
                    if (obj2 != null) {
                        mediatorLiveData.setValue(kotlin.k.a(obj2, obj));
                    }
                }
            }
        }));
        return mediatorLiveData;
    }
}
