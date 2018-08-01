package com.lxf.zhuduoduo.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.hss01248.dialog.StyledDialog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;


/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class MyOkhttp {

    public interface CallBack {
        void onRequestComplete(String response, String msg, String code);
    }

    /**
     * @param context  上下文
     * @param json     post参数
     * @param callBack 回调
     */
    public static void Okhttp(final Context context, String url, String json, final CallBack callBack) {
        Log.e("TAG", "json=" + json);
        StyledDialog.init(context);
        StyledDialog.buildLoading().show();
        OkHttpUtils
                .postString()
                .content(json)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .url(url)
                .build()//
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {
                        Log.e("TAG", "e=" + e.getMessage());
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        StyledDialog.dismissLoading();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        StyledDialog.dismissLoading();
                        Log.e("TAG", "response=" + response);
                        String msg = "";
                        String code = "";
                        try {
                            JSONObject object = new JSONObject(response);
                            if (object.has("msg") && !object.isNull("msg")) {
                                msg = object.getString("msg");
                            }
                            if (object.has("code") && !object.isNull("code")) {
                                code = object.getString("code");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callBack.onRequestComplete(response, msg, code);
                    }
                });
    }
}
