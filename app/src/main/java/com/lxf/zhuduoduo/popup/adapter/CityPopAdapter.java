package com.lxf.zhuduoduo.popup.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.ui.home.bean.BrandBean;


/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class CityPopAdapter extends BaseAdapter {

    private Context context;
    private BrandBean model;

    public CityPopAdapter(Context context, BrandBean model) {
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_city_pop, null);
        TextView textView = view.findViewById(R.id.tv_name);
//        if (i == 0) {
//            textView.setText("全国卡");
//        } else {
        textView.setText("" + model.getData().get(i).getBrand_name());
//        }
        return view;
    }
}
