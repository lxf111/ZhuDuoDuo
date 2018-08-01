package com.lxf.zhuduoduo.ui.alcohol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyDialogListener;
import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.http.Api;
import com.lxf.zhuduoduo.ui.alcohol.bean.GiveMessageBean;
import com.lxf.zhuduoduo.utils.MyOkhttp;
import com.lxf.zhuduoduo.utils.SPUtils;

import java.util.List;

public class AlcoholAdapter extends RecyclerView.Adapter<AlcoholAdapter.AlcoholViewHolder> {

    private Context context;
    private List<GiveMessageBean.DataBean> bean;

    private String uid;

    public AlcoholAdapter(Context context, List<GiveMessageBean.DataBean> bean) {
        this.context = context;
        this.bean = bean;
        uid = (String) SPUtils.get(context, "uid", "22");
    }

    @Override
    public AlcoholViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_alcohol, null);
        AlcoholViewHolder holder = new AlcoholViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AlcoholViewHolder holder, int position) {
        holder.tvName.setText("" + bean.get(position).getUsername());
        /**
         * 拒绝
         */
        holder.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StyledDialog.init(context);
                StyledDialog.buildIosAlert("提示", "确定拒绝吗？", new MyDialogListener() {
                    @Override
                    public void onFirst() {

                    }

                    @Override
                    public void onSecond() {
                        changeState(position, "" + bean.get(position).getGid(), "2");
                    }
                }).setBtnText("取消", "确定").show();
            }
        });
        /**
         * 接收
         */
        holder.tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StyledDialog.init(context);
                StyledDialog.buildIosAlert("提示", "确定接收吗？", new MyDialogListener() {
                    @Override
                    public void onFirst() {

                    }

                    @Override
                    public void onSecond() {
                        changeState(position, "" + bean.get(position).getGid(), "1");
                    }
                }).setBtnText("取消", "确定").show();

            }
        });
    }

    private void changeState(int position, String id, String type) {
        String json = "{\"uid\":\"" + uid + "\",\"type\":\"" + type + "\"" +
                ",\"zid\":\"" + id + "\"}";
        MyOkhttp.Okhttp(context, Api.BASE_URL + Api.querenxx, json, new MyOkhttp.CallBack() {
            @Override
            public void onRequestComplete(String response, String msg, String code) {
                if (code.equals("0")) {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                    bean.remove(position);
                    notifyDataSetChanged();
                } else {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    protected class AlcoholViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvName;
        private TextView tvCancel;
        private TextView tvConfirm;

        public AlcoholViewHolder(View view) {
            super(view);
            ivImg = (ImageView) view.findViewById(R.id.iv_img);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
            tvConfirm = (TextView) view.findViewById(R.id.tv_confirm);
        }
    }
}
