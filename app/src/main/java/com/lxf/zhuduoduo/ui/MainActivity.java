package com.lxf.zhuduoduo.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.BaseActivity;
import com.lxf.zhuduoduo.ui.alcohol.AlcoholFragment;
import com.lxf.zhuduoduo.ui.find.FindFragment;
import com.lxf.zhuduoduo.ui.home.HomeFragment;
import com.lxf.zhuduoduo.ui.my.MyFragment;
import com.lxf.zhuduoduo.utils.SPUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout framelayoutMain;
    private RadioGroup mainRadiogroup;
    private RadioButton rbMainHome;
    private RadioButton rbMainNear;
    private RadioButton rbMainOrder;
    private RadioButton rbMainMy;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private HomeFragment homeFragment;//首页
    private FindFragment nearFragment;//发现
    private AlcoholFragment orderFragment;//酒库
    private MyFragment myFragment;//我的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();

        SPUtils.put(context, "isFirst", false);
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                String[] mPermissionList = new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.READ_LOGS,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.SET_DEBUG_APP,
                        Manifest.permission.SYSTEM_ALERT_WINDOW,
                        Manifest.permission.GET_ACCOUNTS,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_APN_SETTINGS};
                ActivityCompat.requestPermissions(this, mPermissionList, 123);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

    }


    private void initView() {
        framelayoutMain = (FrameLayout) findViewById(R.id.framelayout_main);
        mainRadiogroup = (RadioGroup) findViewById(R.id.main_radiogroup);
        rbMainHome = (RadioButton) findViewById(R.id.rb_main_home);
        rbMainNear = (RadioButton) findViewById(R.id.rb_main_near);
        rbMainOrder = (RadioButton) findViewById(R.id.rb_main_order);
        rbMainMy = (RadioButton) findViewById(R.id.rb_main_my);
    }

    private void initData() {

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        homeFragment = new HomeFragment();

        ft.add(R.id.framelayout_main, homeFragment);

        goFragment();

        ft.show(homeFragment);
        ft.commit();
    }

    private void initEvent() {
        rbMainHome.setOnClickListener(this);
        rbMainNear.setOnClickListener(this);
        rbMainOrder.setOnClickListener(this);
        rbMainMy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (view.getId()) {
            //首页
            case R.id.rb_main_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.framelayout_main, homeFragment);
                }
                goFragment();
                fragmentTransaction.show(homeFragment);
                break;
            //附近
            case R.id.rb_main_near:
                if (nearFragment == null) {
                    nearFragment = new FindFragment();
                    fragmentTransaction.add(R.id.framelayout_main, nearFragment);
                }
                goFragment();
                fragmentTransaction.show(nearFragment);
                break;
            //订单
            case R.id.rb_main_order:
                if (orderFragment == null) {
                    orderFragment = new AlcoholFragment();
                    fragmentTransaction.add(R.id.framelayout_main, orderFragment);
                }
                goFragment();
                fragmentTransaction.show(orderFragment);
                break;
            //我的
            case R.id.rb_main_my:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    fragmentTransaction.add(R.id.framelayout_main, myFragment);
                }
                goFragment();
                fragmentTransaction.show(myFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    private void goFragment() {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (nearFragment != null) {
            fragmentTransaction.hide(nearFragment);
        }
        if (orderFragment != null) {
            fragmentTransaction.hide(orderFragment);
        }
        if (myFragment != null) {
            fragmentTransaction.hide(myFragment);
        }
        fragmentTransaction.commit();
    }

}
