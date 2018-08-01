package com.lxf.zhuduoduo.ui.alcohol.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseFragment;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.alcohol.adapter.WineAdapter1;
import com.lxf.zhuduoduo.ui.alcohol.adapter.WineAdapter2;
import com.lxf.zhuduoduo.ui.alcohol.adapter.WineAdapter3;
import com.lxf.zhuduoduo.ui.alcohol.bean.WineCallerBean;
import com.lxf.zhuduoduo.utils.MyOkhttp;

/**
 * 未兑换
 */
public class AllWineCallerFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private WineAdapter1 adapter1;
    private WineAdapter2 adapter2;
    private WineAdapter3 adapter3;

    private int skin = 1;

    private WineCallerBean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_wine_caller, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initEvent();
        getData();
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_wine);
    }

    private void initData() {
        skin = getArguments().getInt("skin");
    }


    private void getData() {
        String json = "{\"uid\":\"" + uid + "\",\"status\":\"" + 0 + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.jiuku, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                Gson gson = new Gson();
                bean = gson.fromJson(response, WineCallerBean.class);
                if (code.equals("0")) {
                    if (skin == 1) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter1 = new WineAdapter1(context);
                        recyclerView.setAdapter(adapter1);
                    } else if (skin == 2) {
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(context, 2);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter2 = new WineAdapter2(context);
                        recyclerView.setAdapter(adapter2);
                    } else if (skin == 3) {
                        GridLayoutManager linearLayoutManager = new GridLayoutManager(context, 2);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter3 = new WineAdapter3(context);
                        recyclerView.setAdapter(adapter3);
                    }
                }
            }
        });
    }

    private void initEvent() {

    }
}
