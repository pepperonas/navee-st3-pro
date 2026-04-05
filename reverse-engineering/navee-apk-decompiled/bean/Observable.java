package com.uz.navee.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/* loaded from: classes3.dex */
public class Observable {
    private final ObservableSupport support = new ObservableSupport(this);

    public static class ObservableSupport extends PropertyChangeSupport {
        public ObservableSupport(Object obj) {
            super(obj);
        }

        @Override // java.beans.PropertyChangeSupport
        public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
            super.addPropertyChangeListener(str, propertyChangeListener);
        }

        public void removeAllListeners(String str) {
        }

        @Override // java.beans.PropertyChangeSupport
        public void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
            super.removePropertyChangeListener(str, propertyChangeListener);
        }
    }

    public PropertyChangeListener addListener(String str, PropertyChangeListener propertyChangeListener) {
        this.support.addPropertyChangeListener(str, propertyChangeListener);
        return propertyChangeListener;
    }

    public void firePropertyChange(String str, int i6, int i7) {
        this.support.firePropertyChange(str, i6, i7);
    }

    public void removeListener(String str, PropertyChangeListener propertyChangeListener) {
        this.support.removePropertyChangeListener(str, propertyChangeListener);
    }

    public void firePropertyChange(String str, boolean z6, boolean z7) {
        this.support.firePropertyChange(str, z6, z7);
    }

    public void firePropertyChange(String str, Object obj, Object obj2) {
        this.support.firePropertyChange(str, obj, obj2);
    }
}
