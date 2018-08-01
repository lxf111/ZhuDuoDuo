package com.lxf.zhuduoduo.ui.alcohol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseFragment;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.alcohol.activity.WinActivity;
import com.lxf.zhuduoduo.ui.alcohol.activity.WineryActivity;
import com.lxf.zhuduoduo.ui.alcohol.adapter.AlcoholAdapter;
import com.lxf.zhuduoduo.ui.alcohol.bean.GiveMessageBean;
import com.lxf.zhuduoduo.ui.alcohol.activity.WineCallerActivity;
import com.lxf.zhuduoduo.utils.MyOkhttp;
import com.lxf.zhuduoduo.view.MyRecyclerView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

/**
 * 酒库
 */

public class AlcoholFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivShare;
    private TextView tvSell;
    private MyRecyclerView rvAlcohol;
    private RelativeLayout relWineCaller;//酒库
    private RelativeLayout relWinery;//酒庄
    private RelativeLayout relWinning;//战果

    private AlcoholAdapter adapter;

    private GiveMessageBean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alcohol, null);
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
        ivShare = (ImageView) view.findViewById(R.id.iv_share);
        tvSell = (TextView) view.findViewById(R.id.tv_sell);
        rvAlcohol = (MyRecyclerView) view.findViewById(R.id.rv_alcohol);
        relWineCaller = (RelativeLayout) view.findViewById(R.id.rel_win_caller);
        relWinery = (RelativeLayout) view.findViewById(R.id.rel_winery);
        relWinning = (RelativeLayout) view.findViewById(R.id.rel_winning);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvAlcohol.setNestedScrollingEnabled(false);
        rvAlcohol.setLayoutManager(linearLayoutManager);
    }

    private void initData() {

        String json = "{\"uid\":\"" + uid + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.xiaoxi, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                Gson gson = new Gson();
                bean = gson.fromJson(response, GiveMessageBean.class);
                if (code.equals("0")) {
                    adapter = new AlcoholAdapter(context, bean.getData());
                    rvAlcohol.setAdapter(adapter);
                }
            }
        });
    }

    private void initEvent() {
        ivShare.setOnClickListener(this);
        relWineCaller.setOnClickListener(this);
        relWinery.setOnClickListener(this);
        relWinning.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.iv_share:
                //分享
                final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                        {
                                SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE
                        };
                new ShareAction(getActivity()).setDisplayList(displaylist)
                        .setShareboardclickCallback(shareBoardlistener).open();
                break;
            //酒库
            case R.id.rel_win_caller:
                intent = new Intent(context, WineCallerActivity.class);
                break;
            //酒庄
            case R.id.rel_winery:
                intent = new Intent(context, WineryActivity.class);
                break;
            //战果
            case R.id.rel_winning:
                intent = new Intent(context, WinActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    //分享面板的点击事件
    private ShareBoardlistener shareBoardlistener = new ShareBoardlistener() {
        @Override
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {

            if (share_media == null) {

            } else {
                UMImage image = new UMImage(context, R.mipmap.logo);//网络图片
                UMWeb web = new UMWeb("http://www.baidi.com/");
                web.setDescription("注多多");
                web.setThumb(image);
                web.setTitle("注多多标题");
                new ShareAction(getActivity()).setPlatform(share_media).setCallback(umShareListener)
                        .withMedia(web)
                        .share();
            }
        }
    };

    //分享的回调
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);
            Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "取消分享", Toast.LENGTH_SHORT).show();
        }
    };
}
