package com.lxf.zhuduoduo.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.ui.home.bean.HomeBean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by zhf on 2018/7/2.
 */

public class HomeActivityAdapter extends RecyclerView.Adapter<HomeActivityAdapter.ViewHolder> {

    private Context context;
    private List<HomeBean.DataBean.ActivityBean> bean;

    public HomeActivityAdapter(Context context, List<HomeBean.DataBean.ActivityBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_home_activity, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText("" + bean.get(position).getSales_name());
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
