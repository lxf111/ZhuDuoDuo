package com.lxf.zhuduoduo.ui.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.utils.MyOkhttp;
import com.stx.xhb.xbanner.XBanner;

public class DetailActivity extends BaseActivity {
    private XBanner xbanner;
    private ImageView ivShare;
    private TextView tvTitle;
    private TextView tvCar;
    private TextView tvSale;
    private TextView tvPrice;
    private TextView tvType;
    private TextView tvSell;

    private String goodsId = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        goodsId = getIntent().getStringExtra("id");

        initTitle("详情页");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        xbanner = (XBanner) findViewById(R.id.xbanner);
        ivShare = (ImageView) findViewById(R.id.iv_share);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvCar = (TextView) findViewById(R.id.tv_car);
        tvSale = (TextView) findViewById(R.id.tv_sale);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvType = (TextView) findViewById(R.id.tv_type);
        tvSell = (TextView) findViewById(R.id.tv_sell);
    }

    private void initData() {
        String json = "{\"goodsId\":\"" + goodsId + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.GoodsDetails, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
//                Gson gson = new Gson();
//                bean = gson.fromJson(response, ToastListBean.class);
                if (code.equals("0")) {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//                    if (nowPage == 1) {
//                        resultBean.setData(bean.getData());
//                        adapter = new ToastAdapter(context, resultBean.getData().getGoods());
//                        rvToast.setAdapter(adapter);
//                    } else {
//                        resultBean.getData().getGoods().addAll(bean.getData().getGoods());
//                        adapter.notifyDataSetChanged();
//                    }
                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initEvent() {

    }
}
