package com.sixin.indicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sixin.indicator.view.IndicatorAdapter;
import com.sixin.indicator.view.ScrollIndicatorView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // TODO: 2018/1/5 观察者模式
    private ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0 ; i < 100 ; i++){
            data.add("第" + i + "个");
        }
        ScrollIndicatorView indicatorView = findViewById(R.id.indicatorView);
        indicatorView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends IndicatorAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_layout, null);
            }
            TextView textView = convertView.findViewById(R.id.textView);
            textView.setText(data.get(position));
            return convertView;
        }
    }

}
