package cn.sharesdk.google;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface GoogleOutIinterface extends IInterface {

    public static abstract class a extends Binder implements GoogleOutIinterface {
        public a() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
            if (i6 != 1) {
                if (i6 != 1598968902) {
                    return super.onTransact(i6, parcel, parcel2, i7);
                }
                parcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            Callback(parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void Callback(int i6, IBinder iBinder, Bundle bundle) throws RemoteException;
}
