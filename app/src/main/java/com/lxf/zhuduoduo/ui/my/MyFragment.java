package com.lxf.zhuduoduo.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseFragment;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.my.activity.AddressActivity;
import com.lxf.zhuduoduo.ui.my.activity.PersonHallActivity;
import com.lxf.zhuduoduo.ui.my.activity.SettingActivity;
import com.lxf.zhuduoduo.ui.order.CarActivity;
import com.lxf.zhuduoduo.ui.order.OrderActivity;
import com.lxf.zhuduoduo.utils.MyOkhttp;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivSetting;
    private CircleImageView ivHeader;
    private TextView tvName;
    private TextView tvVali;
    private LinearLayout linIntegral;
    private TextView tvIntegralNum;
    private LinearLayout linCollection;
    private TextView tvCollectionNum;
    private LinearLayout linPaying;
    private LinearLayout linSend;
    private LinearLayout linShou;
    private LinearLayout linSaled;
    private TextView tvDynamic;
    private TextView tvCar;
    private TextView tvHall;
    private TextView tvActivity;
    private TextView tvAddress;
    private TextView tvBank;
    private TextView tvPower;
    private TextView tvCollection;
    private TextView tvFriend;
    private TextView tvBirth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initEvent();
    }

    private void initView(View view) {
        ivSetting = (ImageView) view.findViewById(R.id.iv_setting);
        ivHeader = (CircleImageView) view.findViewById(R.id.iv_header);
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvVali = (TextView) view.findViewById(R.id.tv_vali);
        linIntegral = (LinearLayout) view.findViewById(R.id.lin_integral);
        tvIntegralNum = (TextView) view.findViewById(R.id.tv_integral_num);
        linCollection = (LinearLayout) view.findViewById(R.id.lin_collection);
        tvCollectionNum = (TextView) view.findViewById(R.id.tv_collection_num);
        linPaying = (LinearLayout) view.findViewById(R.id.lin_paying);
        linSend = (LinearLayout) view.findViewById(R.id.lin_send);
        linShou = (LinearLayout) view.findViewById(R.id.lin_shou);
        linSaled = (LinearLayout) view.findViewById(R.id.lin_saled);
        tvDynamic = (TextView) view.findViewById(R.id.tv_dynamic);
        tvCar = (TextView) view.findViewById(R.id.tv_car);
        tvHall = (TextView) view.findViewById(R.id.tv_hall);
        tvActivity = (TextView) view.findViewById(R.id.tv_activity);
        tvAddress = (TextView) view.findViewById(R.id.tv_address);
        tvBank = (TextView) view.findViewById(R.id.tv_bank);
        tvPower = (TextView) view.findViewById(R.id.tv_power);
        tvCollection = (TextView) view.findViewById(R.id.tv_collection);
        tvFriend = (TextView) view.findViewById(R.id.tv_friend);
        tvBirth = (TextView) view.findViewById(R.id.tv_birth);
    }

    private void initData() {
        String json = "{\"uid\":\"" + uid + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.person_data, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {

                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initEvent() {
        ivSetting.setOnClickListener(this);
        linPaying.setOnClickListener(this);
        linSend.setOnClickListener(this);
        linShou.setOnClickListener(this);
        linSaled.setOnClickListener(this);
        tvDynamic.setOnClickListener(this);
        tvCar.setOnClickListener(this);
        tvHall.setOnClickListener(this);
        tvActivity.setOnClickListener(this);
        tvAddress.setOnClickListener(this);
        tvBank.setOnClickListener(this);
        tvPower.setOnClickListener(this);
        tvCollection.setOnClickListener(this);
        tvFriend.setOnClickListener(this);
        tvBirth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            //设置
            case R.id.iv_setting:
                intent = new Intent(context, SettingActivity.class);
                break;
            //待付款
            case R.id.lin_paying:
                intent = new Intent(context, OrderActivity.class);
                break;
            //待发货
            case R.id.lin_send:
                intent = new Intent(context, OrderActivity.class);
                break;
            //待收货
            case R.id.lin_shou:
                intent = new Intent(context, OrderActivity.class);
                break;
            //售后
            case R.id.lin_saled:
                intent = new Intent(context, OrderActivity.class);
                break;
            //我的动态
            case R.id.tv_dynamic:
                break;
            //购物车
            case R.id.tv_car:
                intent = new Intent(context, CarActivity.class);
                break;
            //个人商城
            case R.id.tv_hall:
                intent = new Intent(context, PersonHallActivity.class);
                break;
            //参加的活动
            case R.id.tv_activity:
                break;
            //收货地址
            case R.id.tv_address:
                intent = new Intent(context, AddressActivity.class);
                break;
            //银行卡
            case R.id.tv_bank:
                break;
            //我的申请
            case R.id.tv_power:
                break;
            //我的收藏
            case R.id.tv_collection:
                break;
            //我的朋友
            case R.id.tv_friend:
                break;
            //生日
            case R.id.tv_birth:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
