package com.lxf.zhuduoduo.ui.im;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyDialogListener;
import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.base.MyApplication;
import com.lxf.zhuduoduo.utils.MyOkhttp;
import com.lxf.zhuduoduo.utils.SPUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.LocationMessage;

/**
 * Created by Administrator on 2018/4/2 0002.
 * 会话界面
 */

public class ConversationActivity extends FragmentActivity {
//implements View.OnClickListener,
//    RongIM.UserInfoProvider, RongIM.GroupInfoProvider
    private ImageView ivRight;
    private ImageView ivBack;
    private TextView tvTitle;
    private TextView tvMember;
    private TextView tvHome;

    private String id = "";
    private String name = "";

    private String headIm = "";

    private int type = 0;//0默认单聊  1群聊

    private String readId = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);

//        id = getIntent().getStringExtra("id");
//        name = getIntent().getStringExtra("name");
//        headIm = getIntent().getStringExtra("headIm");
//        type = getIntent().getIntExtra("type", 0);
//
//        Log.e("TAG", "id=" + id);
//        Log.e("TAG", "name=" + name);
//        Log.e("TAG", "headIm=" + headIm);
//
//        initView();
//        initData();
//        initEvent();

    }

//    private void initView() {
//
//        ivRight = (ImageView) findViewById(R.id.iv_setting);
//        ivRight.setImageResource(R.mipmap.im_more);
//
//        ivBack = (ImageView) findViewById(R.id.iv_back);
//        tvTitle = (TextView) findViewById(R.id.tv_title);
//        tvHome = (TextView) findViewById(R.id.tv_lift);
//        tvMember = (TextView) findViewById(R.id.tv_right);
//
//        ConversationFragment fragment =
//                (ConversationFragment) getSupportFragmentManager().findFragmentById(R.id.conversation);
//        if (type == 1) {
//            if (id.substring(0, 1).equals("h")) {
//                //家乡
//                ivRight.setVisibility(View.GONE);
//                tvMember.setVisibility(View.VISIBLE);
//                tvHome.setVisibility(View.VISIBLE);
//                tvMember.setTextColor(getResources().getColor(R.color.tv_51));
//                tvHome.setTextColor(getResources().getColor(R.color.tv_51));
//                tvMember.setText("成员");
//                tvHome.setText("主页");
//                setMyExtensionModule("0");
//            } else if (id.substring(0, 1).equals("g")) {
//                //团
//                ivRight.setVisibility(View.VISIBLE);
//                setMyExtensionModule("1");
//            } else {
//                //活动
//                setMyExtensionModule("0");
//                ivRight.setVisibility(View.GONE);
//            }
//            //群聊
//            Uri uri = Uri.parse("rong://" + ConversationActivity.this.getApplicationInfo().packageName).buildUpon()
//                    .appendPath("conversation")
//                    .appendPath(Conversation.ConversationType.GROUP.getName().toLowerCase())
//                    .appendQueryParameter("targetId", id)
//                    .appendQueryParameter("title", name).build();
//            fragment.setUri(uri);
//            tvTitle.setText("" + name);
//
//
//            RongIM.setGroupInfoProvider(this, true);
//            RongIM.getInstance().refreshGroupInfoCache(new Group(id, name, Uri.parse(headIm)));
//
//
//        } else {
//            /**
//             * 单聊隐掉自定义面板
//             */
//            setMyExtensionModule("0");
//            //单聊
//            ivRight.setVisibility(View.GONE);
//            Uri uri = Uri.parse("rong://" + ConversationActivity.this.getApplicationInfo().packageName).buildUpon()
//                    .appendPath("conversation")
//                    .appendPath(Conversation.ConversationType.PRIVATE.getName().toLowerCase())
//                    .appendQueryParameter("targetId", id)
//                    .appendQueryParameter("title", name).build();
//            fragment.setUri(uri);
//            tvTitle.setText("" + name);
//
//            RongIM.setUserInfoProvider(this, true);
//            RongIM.getInstance().refreshUserInfoCache(new UserInfo(id, name, Uri.parse(headIm)));
//        }
//
//        RongIM.getInstance().enableNewComingMessageIcon(true);//显示新消息提醒
//        RongIM.getInstance().enableUnreadMessageIcon(true);//显示未读消息数目
//
//        String icon = (String) SPUtils.get(ConversationActivity.this, "icon", "http://imgsrc.baidu.com/imgad/pic/item/279759ee3d6d55fb83ddb9bb67224f4a20a4dd10.jpg");
//        String userName = (String) SPUtils.get(ConversationActivity.this, "name", "");
//        String uid = (String) SPUtils.get(ConversationActivity.this, "uid", "");
//
//        RongIM.getInstance().setCurrentUserInfo(new UserInfo(uid, userName,
//                Uri.parse(icon)));
//        RongIM.getInstance().setMessageAttachedUserInfo(true);
//
//    }
//
//    /**
//     * 群聊显示自定义面板
//     */
//    public void setMyExtensionModule(String type) {
//        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
//        IExtensionModule defaultModule = null;
//        if (moduleList != null) {
//            for (IExtensionModule module : moduleList) {
//                if (module instanceof DefaultExtensionModule) {
//                    defaultModule = module;
//                    break;
//                }
//            }
//            if (defaultModule != null) {
//                if (type.equals("0")) {
//                    //单聊
//                    RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
//                    RongExtensionManager.getInstance().registerExtensionModule(new PrivateExtensionModule());
//                } else {
//                    //群聊
//                    RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
//                    RongExtensionManager.getInstance().registerExtensionModule(new MyExtensionModule());
//                }
//
//            }
//        }
//    }
//
//    private void initData() {
//
//    }
//
//    private void initEvent() {
//        ivBack.setOnClickListener(this);
//        ivRight.setOnClickListener(this);
//        RongIM.setConversationBehaviorListener(new MyConversationBehaviorListener());
//
//        tvMember.setOnClickListener(this);
//        tvHome.setOnClickListener(this);
//
//    }
//
//    @Override
//    public Group getGroupInfo(String s) {
//        return new Group(id, name, Uri.parse(headIm));
//    }
//
//    /**
//     * 聊天界面的点击事件
//     */
//    private class MyConversationBehaviorListener implements RongIM.ConversationBehaviorListener {
//
//        /**
//         * 当点击用户头像后执行。
//         *
//         * @param context          上下文。
//         * @param conversationType 会话类型。
//         * @param userInfo         被点击的用户的信息。
//         * @return 如果用户自己处理了点击后的逻辑，则返回 true，否则返回 false，false 走融云默认处理方式。
//         */
//        @Override
//        public boolean onUserPortraitClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo) {
//            Intent intent = new Intent(context, PersonActivity.class);
//            intent.putExtra("otherId", "" + userInfo.getUserId());
//            startActivity(intent);
//            return true;
//        }
//
//        /**
//         * 当长按用户头像后执行。
//         *
//         * @param context          上下文。
//         * @param conversationType 会话类型。
//         * @param userInfo         被点击的用户的信息。
//         * @return 如果用户自己处理了点击后的逻辑，则返回 true，否则返回 false，false 走融云默认处理方式。
//         */
//        @Override
//        public boolean onUserPortraitLongClick(Context context, Conversation.ConversationType conversationType, UserInfo userInfo) {
//            return true;
//        }
//
//        /**
//         * 当点击消息时执行。
//         *
//         * @param context 上下文。
//         * @param view    触发点击的 View。
//         * @param message 被点击的消息的实体信息。
//         * @return 如果用户自己处理了点击后的逻辑，则返回 true， 否则返回 false, false 走融云默认处理方式。
//         */
//        @Override
//        public boolean onMessageClick(Context context, View view, Message message) {
//            if (message.getObjectName().equals("app:custom")) {
//                //红包
//                CustomizeMessage m = (CustomizeMessage) message.getContent();
//                Log.e("TAG", "custom=" + m.getContent());
//                String type = "0";
//                String problem = "0";
//                String pwd = "0";
//                try {
//                    JSONObject object = new JSONObject(m.getContent());
//
//                    if (object.has("type") && !object.isNull("type")) {
//                        type = object.getString("type");
//                    }
//                    if (object.has("readId") && !object.isNull("readId")) {
//                        readId = object.getString("readId");
//                    }
//                    if (object.has("problem") && !object.isNull("problem")) {
//                        problem = object.getString("problem");
//                    }
//                    if (object.has("pwd") && !object.isNull("pwd")) {
//                        pwd = object.getString("pwd");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                if (type.equals("0")) {
//                    //密码红包
//                    StyledDialog.init(ConversationActivity.this);
//                    String finalPwd = pwd;
//                    StyledDialog.buildNormalInput("提示：" + problem, "请输入密码", null, "确定", null, new MyDialogListener() {
//                        @Override
//                        public void onFirst() {
//
//                        }
//
//                        @Override
//                        public void onSecond() {
//
//                        }
//
//                        @Override
//                        public void onGetInput(CharSequence input1, CharSequence input2) {
//                            super.onGetInput(input1, input2);
//                            if (input1 != null && !input1.equals("")) {
//                                if (input1.toString().equals("" + finalPwd)) {
//                                    getRed("" + readId);
//                                } else {
//                                    Toast.makeText(context, "密码不正确", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }
//                    }).setLvItemSize(100).show();
//                } else if (type.equals("1")) {
//                    //问答红包
//                    StyledDialog.init(ConversationActivity.this);
//                    StyledDialog.buildNormalInput("问答：" + problem, "请输入答案", null, "确定", null, new MyDialogListener() {
//                        @Override
//                        public void onFirst() {
//
//                        }
//
//                        @Override
//                        public void onSecond() {
//
//                        }
//
//                        @Override
//                        public void onGetInput(CharSequence input1, CharSequence input2) {
//                            super.onGetInput(input1, input2);
//                            if (input1 != null && !input1.equals("")) {
//                                getRed("" + readId);
//                            }
//                        }
//                    }).setLvItemSize(100).show();
//                } else if (type.equals("2")) {
//                    //口令红包
//                    getRed("" + readId);
//                } else if (type.equals("3")) {
//                    //普通红包
//                    getRed("" + readId);
//                }
//            } else if (message.getObjectName().equals("app:draw")) {
//                //抽奖
//                LuckDrawMessage s = (LuckDrawMessage) message.getContent();
//                Log.e("TAG", "8=" + s.getContent());
//                if (id.substring(0, 1).equals("a")) {
//                    //活动
//                    Intent intent = new Intent(ConversationActivity.this, LuckDrawActivity.class);
//                    intent.putExtra("type", "0");
//                    intent.putExtra("prizeId", "" + s.getContent());
//                    startActivity(intent);
//                } else if (id.substring(0, 1).equals("g")) {
//                    //团
//                    Intent intent = new Intent(ConversationActivity.this, LuckDrawActivity.class);
//                    intent.putExtra("type", "1");
//                    intent.putExtra("prizeId", "" + s.getContent());
//                    startActivity(intent);
//                }
//            } else if (message.getObjectName().equals("RC:LBSMsg")) {
//                LocationMessage locationMessage = (LocationMessage) message.getContent();
//                double lat = locationMessage.getLat();
//                double lng = locationMessage.getLng();
//                String address = locationMessage.getPoi();
//
//                Bundle bundle = new Bundle();
//                bundle.putDouble("lat", lat);
//                bundle.putDouble("lng", lng);
//                bundle.putString("address", "" + address);
//                MyApplication.openActivity(context, LocationActivity.class, bundle);
//
//            }
//            return false;
//        }
//
//        /**
//         * 当长按消息时执行。
//         *
//         * @param context 上下文。
//         * @param view    触发点击的 View。
//         * @param message 被长按的消息的实体信息。
//         * @return 如果用户自己处理了长按后的逻辑，则返回 true，否则返回 false，false 走融云默认处理方式。
//         */
//        @Override
//        public boolean onMessageLongClick(Context context, View view, Message message) {
//            return false;
//        }
//
//        /**
//         * 当点击链接消息时执行。
//         *
//         * @param context 上下文。
//         * @param link    被点击的链接。
//         * @return 如果用户自己处理了点击后的逻辑处理，则返回 true， 否则返回 false, false 走融云默认处理方式。
//         */
//        @Override
//        public boolean onMessageLinkClick(Context context, String link) {
//
//            return false;
//        }
//    }
//
//    @Override
//    public UserInfo getUserInfo(String s) {
//        String icon = (String) SPUtils.get(ConversationActivity.this, "icon", "http://imgsrc.baidu.com/imgad/pic/item/279759ee3d6d55fb83ddb9bb67224f4a20a4dd10.jpg");
//        String userName = (String) SPUtils.get(ConversationActivity.this, "name", "");
//        String uid = (String) SPUtils.get(ConversationActivity.this, "uid", "");
//        return new UserInfo(uid,
//                userName, Uri.parse(icon));
//    }
//
//    @Override
//    public void onClick(View v) {
//        Bundle bundle = new Bundle();
//        switch (v.getId()) {
//            //返回
//            case R.id.iv_back:
//                finish();
//                break;
//            //右边的按钮
//            case R.id.iv_setting:
//                bundle.putString("groupId", "" + id);
//                MyApplication.openActivity(this, GroupActivity.class, bundle);
//                break;
//            //成员
//            case R.id.tv_right:
//                bundle.putString("groupId", "" + id);
//                MyApplication.openActivity(this, HomeMemberActivity.class, bundle);
//                break;
//            //主页
//            case R.id.tv_lift:
//                bundle.putString("hometownId", "" + id.replace("h", ""));
//                MyApplication.openActivity(this, HometownCharmDetailsActivity.class, bundle);
//                break;
//        }
//    }
//
//    /**
//     * 获取红包
//     *
//     * @param redId 红包id
//     */
//    private void getRed(String redId) {
//        String uid = (String) SPUtils.get(ConversationActivity.this, "uid", "");
//        Map<String, String> params = new HashMap<>();
//        String json = "{\"cmd\":\"robGroupRedPacket\",\"uid\":\"" + uid + "\"" +
//                ",\"redPacketId\":\"" + redId + "\"}";
//        params.put("json", json);
//        MyOkhttp.Okhttp(ConversationActivity.this, params, new MyOkhttp.CallBack() {
//            @Override
//            public void onRequestComplete(String response, String result, String resultNote) {
//                String redMoney = "1";
//                try {
//                    JSONObject object = new JSONObject(response);
//                    if (object.has("redMoney") && !object.isNull("redMoney")) {
//                        redMoney = object.getString("redMoney");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                if (result.equals("0")) {
//                    Toast.makeText(ConversationActivity.this, "恭喜您抢到了" + redMoney + "元", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(ConversationActivity.this, resultNote, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    /**
//     * 抽奖
//     *
//     * @param groupId 团id
//     * @param drawId  抽奖id
//     */
//    private void getDraw(String groupId, String drawId) {
//        String type;
//        if (groupId.substring(0, 1).equals("a")) {
//            type = "0";
//        } else if (groupId.substring(0, 1).equals("g")) {
//            type = "1";
//        } else {
//            type = "2";
//        }
//        String uid = (String) SPUtils.get(ConversationActivity.this, "uid", "");
//        Map<String, String> params = new HashMap<>();
//        String json = "{\"cmd\":\"getPrize\",\"uid\":\"" + uid + "\"" +
//                ",\"type\":\"" + type + "\",\"prizeId\":\"" + drawId + "\"}";
//        params.put("json", json);
//        MyOkhttp.Okhttp(ConversationActivity.this, params, new MyOkhttp.CallBack() {
//            @Override
//            public void onRequestComplete(String response, String result, String resultNote) {
//                if (result.equals("0")) {
//                    Toast.makeText(ConversationActivity.this, resultNote, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(ConversationActivity.this, resultNote, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

}
