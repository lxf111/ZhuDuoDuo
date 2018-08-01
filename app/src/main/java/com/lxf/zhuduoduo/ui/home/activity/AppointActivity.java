package com.lxf.zhuduoduo.ui.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.popup.CityPop;
import com.lxf.zhuduoduo.popup.OtherPop;
import com.lxf.zhuduoduo.ui.home.adapter.AppointAdapter;
import com.lxf.zhuduoduo.ui.home.bean.BrandBean;
import com.lxf.zhuduoduo.ui.home.bean.ToastListBean;
import com.lxf.zhuduoduo.utils.MyOkhttp;

public class AppointActivity extends BaseActivity {
    private TabLayout tabToast;
    private RecyclerView rvToast;

    private AppointAdapter adapter;

    private BrandBean brandBean;//品牌

    private CityPop brandPop;//品牌pop

    private OtherPop otherPop;//其他pop

    private String salseList[] = {"正序", "倒序"};
    private String priceList[] = {"0-100", "100-200"};
    private String sceneList[] = {"宴会", "生日", "聚会"};

    private int nowPage = 1;
    private String brandId = "";//品牌
    private String price = "";//价格区间
    private String salse = "0";//0是倒序 1是正序
    private String scene = "";//场景 1宴会 2生日 3婚庆

    private int type = 0;//1价格，2排序 3场景

    private ToastListBean bean;
    private ToastListBean resultBean = new ToastListBean();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);
        initTitle("一分预约");
        initView();
        initData();
        initEvent();
        getBrand();
        getData();
    }

    private void initView() {
        tabToast = (TabLayout) findViewById(R.id.tab_toast);
        rvToast = (RecyclerView) findViewById(R.id.rv_toast);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvToast.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        tabToast.addTab(tabToast.newTab().setText("全部"));
        tabToast.addTab(tabToast.newTab().setText("品牌"));
        tabToast.addTab(tabToast.newTab().setText("价格"));
        tabToast.addTab(tabToast.newTab().setText("领取量"));
        tabToast.addTab(tabToast.newTab().setText("场景"));
        tabToast.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
    }

    private void getData() {
        String json = "{\"type\":\"24\",\"nowPage\":\"" + nowPage + "\"" +
                ",\"brandId\":\"" + brandId + "\",\"price\":\"" + price + "\"" +
                ",\"sales\":\"" + salse + "\",\"scene\":\"" + scene + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.toastList, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                Gson gson = new Gson();
                bean = gson.fromJson(response, ToastListBean.class);
                if (code.equals("0")) {
                    if (nowPage == 1) {
                        resultBean.setData(bean.getData());
                        adapter = new AppointAdapter(AppointActivity.this, resultBean.getData().getGoods());
                        rvToast.setAdapter(adapter);
                    } else {
                        resultBean.getData().getGoods().addAll(bean.getData().getGoods());
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /**
     * 获取品牌
     */
    private void getBrand() {
        String json = "";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.brand, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                Gson gson = new Gson();
                brandBean = gson.fromJson(response, BrandBean.class);
                if (code.equals("0")) {
                    brandPop = new CityPop(context, onItemClickListener, brandBean);
                }
            }
        });
    }

    /**
     * 品牌的点击事件
     */
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            tabToast.getTabAt(1).setText("" + brandBean.getData().get(i).getBrand_name());
            nowPage = 1;
            brandId = "" + brandBean.getData().get(i).getBrand_id();
            getData();
            brandPop.dismiss();
        }
    };

    private void initEvent() {
        tabToast.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    //全部
                    tabToast.getTabAt(1).setText("品牌");
                    nowPage = 1;
                    brandId = "";//品牌
                    price = "";//价格区间
                    salse = "0";//0是倒序 1是正序
                    scene = "";//场景 1宴会 2生日 3婚庆
                    getData();
                } else if (tab.getPosition() == 1) {
                    //品牌
                    if (brandPop != null) {
                        brandPop.showAsDropDown(tabToast);
                    } else {
                        Toast.makeText(context, "未获取到品牌信息", Toast.LENGTH_SHORT).show();
                        getBrand();
                    }
                } else if (tab.getPosition() == 2) {
                    //价格
                    type = 1;
                    otherPop = new OtherPop(context, otherItemOnclick, priceList);
                    otherPop.showAsDropDown(tabToast);
                } else if (tab.getPosition() == 3) {
                    //领取量
                    type = 2;
                    otherPop = new OtherPop(context, otherItemOnclick, salseList);
                    otherPop.showAsDropDown(tabToast);
                } else if (tab.getPosition() == 4) {
                    //场景
                    type = 3;
                    otherPop = new OtherPop(context, otherItemOnclick, sceneList);
                    otherPop.showAsDropDown(tabToast);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("TAG", "onTabUnselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("TAG", "onTabReselected=" + tab.getPosition());
                if (tab.getPosition() == 0) {
                    //全部
                    nowPage = 1;
                    brandId = "";//品牌
                    price = "";//价格区间
                    salse = "0";//0是倒序 1是正序
                    scene = "";//场景 1宴会 2生日 3婚庆
                    getData();
                } else if (tab.getPosition() == 1) {
                    //品牌
                    if (brandPop != null) {
                        brandPop.showAsDropDown(tabToast);
                    } else {
                        Toast.makeText(context, "未获取到品牌信息", Toast.LENGTH_SHORT).show();
                        getBrand();
                    }
                } else if (tab.getPosition() == 2) {
                    //价格
                    type = 1;
                    otherPop = new OtherPop(context, otherItemOnclick, priceList);
                    otherPop.showAsDropDown(tabToast);
                } else if (tab.getPosition() == 3) {
                    //领取量
                    type = 2;
                    otherPop = new OtherPop(context, otherItemOnclick, salseList);
                    otherPop.showAsDropDown(tabToast);
                } else if (tab.getPosition() == 4) {
                    //场景
                    type = 3;
                    otherPop = new OtherPop(context, otherItemOnclick, sceneList);
                    otherPop.showAsDropDown(tabToast);
                }
            }
        });
    }

    /**
     * 其他类型
     */
    AdapterView.OnItemClickListener otherItemOnclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            otherPop.dismiss();
            if (type == 1) {
                price = priceList[i];
            } else if (type == 2) {
                salse = "" + i;
            } else if (type == 3) {
                scene = "" + (i + 1);
            }
            nowPage = 1;
            getData();
        }
    };
}
