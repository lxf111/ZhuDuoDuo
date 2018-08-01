package com.lxf.zhuduoduo.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.MainActivity;
import com.lxf.zhuduoduo.utils.MyOkhttp;
import com.lxf.zhuduoduo.utils.TimerUtil;

/**
 * Created by zhf on 2018/6/29.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText etPhone;
    private EditText etYzm;
    private TextView tvYzm;
    private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        tvYzm = (TextView) findViewById(R.id.tv_yzm);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etYzm = (EditText) findViewById(R.id.et_pwd);
    }

    private void initData() {

    }

    private void initEvent() {
        tvYzm.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_yzm:
                String phone = etPhone.getText().toString().trim();

                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }

                getYzm(phone);

                break;
            case R.id.btn_submit:

                String phone2 = etPhone.getText().toString().trim();
                String code = etYzm.getText().toString().trim();

                if (TextUtils.isEmpty(phone2)) {
                    Toast.makeText(context, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(context, "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }

                login(phone2, code);

                break;
        }
    }

    /**
     * 获取验证码
     *
     * @param phone
     */
    private void getYzm(String phone) {
        String json = "{\"phone\":\"" + phone + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.get_yzm, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {
                    TimerUtil timerUtil = new TimerUtil(tvYzm);
                    timerUtil.timers();
                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 登录
     */
    private void login(String phone, String code) {
        String json = "{\"phone\":\"" + phone + "\",\"yanzheng\":\"" + code + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.register, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
