package com.lxf.zhuduoduo.ui.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.utils.MyOkhttp;

import de.hdodenhof.circleimageview.CircleImageView;

public class SendFriendActivity extends BaseActivity implements View.OnClickListener {
    private EditText etSearch;
    private CircleImageView ivHeader;
    private TextView tvName;
    private ImageView ivImg;
    private TextView tv500;
    private TextView tv700;
    private TextView tvGoPay;

    private String otherId = "";//被送人的id

    private String goodsId = "";//商品id

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_friend);

        goodsId = getIntent().getStringExtra("id");

        initTitle("送好友");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        etSearch = (EditText) findViewById(R.id.et_search);
        ivHeader = (CircleImageView) findViewById(R.id.iv_header);
        tvName = (TextView) findViewById(R.id.tv_name);
        ivImg = (ImageView) findViewById(R.id.iv_img);
        tv500 = (TextView) findViewById(R.id.tv_500);
        tv700 = (TextView) findViewById(R.id.tv_700);
        tvGoPay = (TextView) findViewById(R.id.tv_go_pay);
    }

    private void initData() {

    }

    private void initEvent() {
        tvGoPay.setOnClickListener(this);

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘
                    ((InputMethodManager) etSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);

                    String content = etSearch.getText().toString().trim();
                    if (TextUtils.isEmpty(content)) {
                        Toast.makeText(context, "请输入搜索内容", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    //实现自己的搜索逻辑
                    searchFriend(content);
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * 搜索好友
     *
     * @param content
     */
    private void searchFriend(String content) {
        String json = "{\"uid\":\"" + uid + "\",\"pageindex\":\"" + 0 + "\"" +
                ",\"keywords\":\"" + content + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.friend, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_go_pay:
                sendAlcohol();
                break;
        }
    }

    /**
     * 送酒
     */
    private void sendAlcohol() {
        String json = "{\"uid\":\"" + uid + "\",\"gid\":\"" + goodsId + "\"" +
                ",\"fuid\":\"" + goodsId + "\",\"guige\":\"" + goodsId + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.songjiu, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {

                }
            }
        });
    }
}
