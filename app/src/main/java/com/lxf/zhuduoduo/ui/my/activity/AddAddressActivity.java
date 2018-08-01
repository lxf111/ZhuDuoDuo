package com.lxf.zhuduoduo.ui.my.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.utils.MyOkhttp;

/**
 * Created by zhf on 2018/6/28.
 */

public class AddAddressActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvRight;
    private EditText etName;
    private EditText etPhone;
    private EditText etAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        initTitle("添加地址");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        tvRight = (TextView) findViewById(R.id.tv_right);
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("完成");

        etPhone = (EditText) findViewById(R.id.et_phone);
        etName = (EditText) findViewById(R.id.et_name);
        etAddress = (EditText) findViewById(R.id.et_address);

    }

    private void initData() {

    }

    private void initEvent() {
        tvRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right:
                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(context, "请输入名字", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(context, "请输入电话", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    Toast.makeText(context, "请输入地址", Toast.LENGTH_SHORT).show();
                }
                submit(name, phone, address);
                break;
        }
    }

    /**
     * 提交
     *
     * @param name
     * @param phone
     * @param address
     */
    private void submit(String name, String phone, String address) {
        String json = "{\"uid\":\"" + uid + "\",\"name\":\"" + name + "\",\"telphone\":\"" + phone + "\"" +
                ",\"address\":\"" + address + "\",\"type\":\"" + 1 + "\",\"is_moren\":\"" + 1 + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.add_address, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
