package com.sixin.indicator.view;

import android.view.View;

/**
 * @author zhou
 * 指示器
 */

public interface Indcator {

    void setAdapter(IndicatorAdapter adapter);

    void setOnItemCLickListener(OnIndicatorItemClickListener listener);

    View getItemView(int item);

    void relationList(View view);

    interface OnIndicatorItemClickListener{
        void onItemClick(View clickItemView , int position);
    }
}
