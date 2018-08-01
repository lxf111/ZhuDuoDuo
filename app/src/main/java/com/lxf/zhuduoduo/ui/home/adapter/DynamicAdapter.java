package com.lxf.zhuduoduo.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.zhuduoduo.R;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHoder> {

    private Context context;

    public DynamicAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_dynamic, null);
        ViewHoder holder = new ViewHoder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected class ViewHoder extends RecyclerView.ViewHolder {
        public ViewHoder(View itemView) {
            super(itemView);
        }
    }
}
