package com.sixin.indicator.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * @author zhou
 */

public class ScrollIndicatorView extends HorizontalScrollView implements Indcator {

    private IndicatorAdapter mAdapter;

    private DataSetObserver mDataSetObserver = new DataSetObserver() {
        @Override
        public void onChange() {
            int childCount = mAdapter.getCount();
            if(childCount == 0){
                return;
            }
            ViewGroup contentParent = (ViewGroup) getChildAt(0);
            for(int i = 0 ; i < childCount ; i++){
                View contentView = mAdapter.getView(i, null, ScrollIndicatorView.this);
                contentParent.addView(contentView,i);
            }
        }
    };

    public ScrollIndicatorView(Context context) {
        super(context);
    }

    public ScrollIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        addView(new LinearLayout(context),
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public ScrollIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(@NonNull IndicatorAdapter adapter) {
        if(mAdapter != null){
            mAdapter.unRegistDataSetObserver(mDataSetObserver);
        }
        mAdapter = adapter;
        mAdapter.registDataSetObserver(mDataSetObserver);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setOnItemCLickListener(OnIndicatorItemClickListener listener) {}

    @Override
    public View getItemView(int item) {
        return null;
    }

    @Override
    public void relationList(View view) {

    }
}
