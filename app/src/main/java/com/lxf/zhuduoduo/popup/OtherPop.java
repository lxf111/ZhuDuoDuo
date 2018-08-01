package com.lxf.zhuduoduo.popup;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.popup.adapter.OtherPopAdapter;



/**
 * Created by Administrator on 2017/1/4.
 */

public class OtherPop extends PopupWindow {

    private View view;

    private ListView listView;

    private OtherPopAdapter adapter;

    public OtherPop(final Context context, ListView.OnItemClickListener onItemClickListener, String[] model) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.pop_city, null);

        listView = view.findViewById(R.id.list_city);
        adapter = new OtherPopAdapter(context, model);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);

//        //显示弹出框
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
//        this.setWidth((int) (MyApplication.Width * 0.25));
//        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置弹窗可点击
        this.setFocusable(true);
        //设置弹出窗体的动画效果
//        this.setAnimationStyle(R.style.AppTheme);
        this.setAnimationStyle(R.style.popwin_fade_style);
        ColorDrawable cd = new ColorDrawable(0x00000000);
        this.setBackgroundDrawable(cd);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dismiss();
                return true;
            }
        });
    }
}