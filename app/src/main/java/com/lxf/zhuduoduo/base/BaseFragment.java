package com.lxf.zhuduoduo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.lxf.zhuduoduo.utils.SPUtils;


/**
 * 项目名称：ProjectFramework
 * 类名称：BaseFragment
 * 类描述：Fragment基础类
 * 创建人：Tiramisu
 * 创建时间：2017/1/17 11:49
 */

public class BaseFragment extends Fragment {
    protected Context context;
    protected String uid;
    public String lat;
    public String lng;
    public String city;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
        uid = (String) SPUtils.get(getActivity(), "uid", "22");
        lat = (String) SPUtils.get(getActivity(), "lat", "34.755702");
        lng = (String) SPUtils.get(getActivity(), "lng", "113.740335");
        city = (String) SPUtils.get(getActivity(), "city", "咸阳");
    }
}
