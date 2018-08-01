package com.lxf.zhuduoduo.base;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import cn.beecloud.BeeCloud;
import io.rong.imkit.RongIM;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, "58c8b87565b6d623600013af"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wxe9eb468876866d43", "55cdc9a9bb487fb13d75c9b7e267feff");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setQQZone("1106866447", "Onc2rC4VU4A0GtOA");
        //开启测试模式
        BeeCloud.setSandbox(true);
        //此处第二个参数是控制台的test secret
        BeeCloud.setAppIdAndSecret("c5d1cba1-5e3f-4ba0-941d-9b0a371fe719",
                "4bfdd244-574d-4bf3-b034-0c751ed34fee");
        SDKInitializer.initialize(getApplicationContext());
        RongIM.init(this);
    }
}
