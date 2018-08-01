package com.lxf.zhuduoduo.ui.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lxf.zhuduoduo.R;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.FindViewHolder> {

    private Context context;

    public FindAdapter(Context context) {
        this.context = context;
    }

    @Override
    public FindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_find,null);
        FindViewHolder holder=new FindViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FindViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected class FindViewHolder extends RecyclerView.ViewHolder {
        public FindViewHolder(View itemView) {
            super(itemView);
        }
    }
}
