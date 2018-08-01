package com.lxf.zhuduoduo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseFragment;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.home.activity.AppointActivity;
import com.lxf.zhuduoduo.ui.home.activity.FreeActivity;
import com.lxf.zhuduoduo.ui.home.activity.SignupActivity;
import com.lxf.zhuduoduo.ui.home.activity.ToastActivity;
import com.lxf.zhuduoduo.ui.home.adapter.DynamicAdapter;
import com.lxf.zhuduoduo.ui.home.adapter.HomeActivityAdapter;
import com.lxf.zhuduoduo.ui.home.bean.HomeBean;
import com.lxf.zhuduoduo.utils.MyOkhttp;
import com.lxf.zhuduoduo.utils.PicassoUtils;
import com.lxf.zhuduoduo.view.MyRecyclerView;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends BaseFragment implements View.OnClickListener, XBanner.XBannerAdapter {
    private ImageView ivLogo;
    private ImageView ivMessage;
    private XBanner xbanner;
    private LinearLayout linHouse;
    private LinearLayout linToast;
    private LinearLayout linFree;
    private LinearLayout linAppointment;
    private LinearLayout linCustomized;
    private LinearLayout linSignIn;
    private LinearLayout linDiscount;
    private LinearLayout linTime;
    private TextView tvNewActivity;
    private MyRecyclerView rvActivity;
    private CircleImageView ivMoreHeader;
    private TextView tvMoreContent;
    private TextView tvNewGrade;
    private TextView tvNewDynamic;
    private MyRecyclerView rvDynamic;
    private MarqueeView marqueeView;
    private MarqueeView marqueeView_zixun;
    private TextView tvFirst;
    private TextView tvSecond;
    private TextView tvThird;

    private DynamicAdapter adapter;

    private List<String> xbannerList = new ArrayList<>();

    private HomeBean bean;

    private HomeActivityAdapter activityAdapter;//活动适配器

    private int nowPage = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initEvent();
        getDynamic();
    }

    private void initView(View view) {
        ivLogo = (ImageView) view.findViewById(R.id.iv_logo);
        ivMessage = (ImageView) view.findViewById(R.id.iv_message);
        xbanner = (XBanner) view.findViewById(R.id.xbanner);
        linHouse = (LinearLayout) view.findViewById(R.id.lin_house);
        linToast = (LinearLayout) view.findViewById(R.id.lin_toast);
        linFree = (LinearLayout) view.findViewById(R.id.lin_free);
        linAppointment = (LinearLayout) view.findViewById(R.id.lin_appointment);
        linCustomized = (LinearLayout) view.findViewById(R.id.lin_customized);
        linSignIn = (LinearLayout) view.findViewById(R.id.lin_sign_in);
        linDiscount = (LinearLayout) view.findViewById(R.id.lin_discount);
        linTime = (LinearLayout) view.findViewById(R.id.lin_time);
        tvNewActivity = (TextView) view.findViewById(R.id.tv_new_activity);
        rvActivity = (MyRecyclerView) view.findViewById(R.id.rv_activity);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvActivity.setLayoutManager(linearLayoutManager1);

        ivMoreHeader = (CircleImageView) view.findViewById(R.id.iv_more_header);
//        tvMoreContent = (TextView) view.findViewById(R.id.tv_more_content);
        tvNewGrade = (TextView) view.findViewById(R.id.tv_new_grade);
        tvNewDynamic = (TextView) view.findViewById(R.id.tv_new_dynamic);
        rvDynamic = (MyRecyclerView) view.findViewById(R.id.rv_dynamic);
        marqueeView = (MarqueeView) view.findViewById(R.id.marqueeView);
        marqueeView_zixun = (MarqueeView) view.findViewById(R.id.marqueeView_zixun);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvDynamic.setLayoutManager(linearLayoutManager);

        tvFirst = (TextView) view.findViewById(R.id.tv_first);
        tvSecond = (TextView) view.findViewById(R.id.tv_second);
        tvThird = (TextView) view.findViewById(R.id.tv_third);

    }

    private void initData() {

        xbanner.setmAdapter(this);

        List<Integer> photo = new ArrayList<>();
        photo.add(R.mipmap.log1);
        photo.add(R.mipmap.logo2);
        photo.add(R.mipmap.logo3);

        adapter = new DynamicAdapter(context);
        rvDynamic.setAdapter(adapter);
        String json = "";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.home_page, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                Gson gson = new Gson();
                bean = gson.fromJson(response, HomeBean.class);
                if (code.equals("0")) {
                    //banner
                    xbannerList.clear();
                    for (int i = 0; i < bean.getData().getBanner().size(); i++) {
                        xbannerList.add(bean.getData().getBanner().get(i).getAd_img());
                    }
                    xbanner.setData(xbannerList, null);

                    //公告
                    List<String> notice = new ArrayList<>();
                    for (int i = 0; i < bean.getData().getGonggao().size(); i++) {
                        notice.add(bean.getData().getGonggao().get(i).getName());
                    }
                    marqueeView.startWithList(notice);

                    //咨询
                    List<String> zixun = new ArrayList<>();
                    for (int i = 0; i < bean.getData().getZixun().size(); i++) {
                        zixun.add(bean.getData().getZixun().get(i).getMem_name());
                    }
                    marqueeView_zixun.startWithList(zixun);

                    //活动
                    activityAdapter = new HomeActivityAdapter(context, bean.getData().getActivity());
                    rvActivity.setAdapter(activityAdapter);

                    //排行榜
                    if (bean.getData().getPaihang().size() > 0) {
                        tvFirst.setText("" + bean.getData().getPaihang().get(0).getMem_name());
                    }

                    if (bean.getData().getPaihang().size() > 1) {
                        tvSecond.setText("" + bean.getData().getPaihang().get(1).getMem_name());
                    }

                    if (bean.getData().getPaihang().size() > 2) {
                        tvThird.setText("" + bean.getData().getPaihang().get(2).getMem_name());
                    }
                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 获取动态
     */
    private void getDynamic() {
        String json = "{\"uid\":\"" + uid + "\",\"nowPage\":\"" + nowPage + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.home_dynamic, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
//                Gson gson = new Gson();
//                bean = gson.fromJson(response, HomeBean.class);
                if (code.equals("0")) {

                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initEvent() {
        linHouse.setOnClickListener(this);
        linToast.setOnClickListener(this);
        linFree.setOnClickListener(this);
        linAppointment.setOnClickListener(this);
        linCustomized.setOnClickListener(this);
        linSignIn.setOnClickListener(this);
        linDiscount.setOnClickListener(this);
        linTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            //免费领取
            case R.id.lin_house:
                intent = new Intent(context, FreeActivity.class);
                break;
            //敬酒
            case R.id.lin_toast:
                intent = new Intent(context, ToastActivity.class);
                break;
            //限量定制
            case R.id.lin_free:
                intent = new Intent(context, FreeActivity.class);
                break;
            //一分预约
            case R.id.lin_appointment:
                intent = new Intent(context, AppointActivity.class);
                break;
            //积分商城
            case R.id.lin_customized:
                intent = new Intent(context, FreeActivity.class);
                break;
            //优惠券
            case R.id.lin_sign_in:
                intent = new Intent(context, FreeActivity.class);
                break;
            //休闲
            case R.id.lin_discount:
                intent = new Intent(context, FreeActivity.class);
                break;
            //签到
            case R.id.lin_time:
                intent = new Intent(context, SignupActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public void loadBanner(XBanner banner, Object model, View view, int position) {
//        Picasso.with(context).load("http://www.ssss")
//                .error(xbannerList[position])
////                .resize(DensityUtils.dp2px(context, 400), DensityUtils.dp2px(context, 280))
////                .centerCrop()
////                .centerInside()
//                .placeholder(xbannerList[position])
//                .into((ImageView) view);
        PicassoUtils.showPhoto(context, xbannerList.get(position), (ImageView) view);
    }
}
