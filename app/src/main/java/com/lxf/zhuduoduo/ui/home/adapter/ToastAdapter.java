package com.lxf.zhuduoduo.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.ui.home.activity.DetailActivity;
import com.lxf.zhuduoduo.ui.home.activity.SendFriendActivity;
import com.lxf.zhuduoduo.ui.home.bean.ToastListBean;
import com.lxf.zhuduoduo.utils.PicassoUtils;

import java.util.List;

public class ToastAdapter extends RecyclerView.Adapter<ToastAdapter.ViewHolder> {

    private Context context;
    private List<ToastListBean.DataBean.GoodsBean> bean;

    public ToastAdapter(Context context, List<ToastListBean.DataBean.GoodsBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_toast, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SendFriendActivity.class);
                intent.putExtra("id", "" + bean.get(position).getGoods_id());
                context.startActivity(intent);
            }
        });

        PicassoUtils.showPhoto(context, bean.get(position).getGoods_img(), holder.ivImg);
        holder.tvName.setText("" + bean.get(position).getGoods_name());
        holder.tvPrice.setText("¥" + bean.get(position).getShop_price());
        holder.tvNum.setText("销量：" + bean.get(position).getGoods_xiaoliang());
        holder.tvScene.setText("场景：" + bean.get(position).getGoods_ad());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", "" + bean.get(position).getGoods_id());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvNum;
        private TextView tvScene;
        private TextView tvSend;

        public ViewHolder(View view) {
            super(view);
            ivImg = (ImageView) view.findViewById(R.id.iv_img);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvPrice = (TextView) view.findViewById(R.id.tv_price);
            tvNum = (TextView) view.findViewById(R.id.tv_num);
            tvScene = (TextView) view.findViewById(R.id.tv_scene);
            tvSend = (TextView) view.findViewById(R.id.tv_send);
        }
    }
}
