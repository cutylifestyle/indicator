package com.sixin.indicator.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author zhou
 */

public abstract class IndicatorAdapter {

    private Set<DataSetObserver> observers = new LinkedHashSet<>(2);

    public abstract int getCount();

    public abstract View getView(int position , View convertView , ViewGroup parent);

    public final void registDataSetObserver(@NonNull  DataSetObserver observer){
        observers.add(observer);
    }

    public final void unRegistDataSetObserver(@NonNull  DataSetObserver observer){
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    public final void notifyDataSetChanged(){
        if(observers.size() > 0){
            for(DataSetObserver observer : observers){
                observer.onChange();
            }
        }
    }

}
