package com.lxf.zhuduoduo.ui.home.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lxf.zhuduoduo.R;
import com.lxf.zhuduoduo.ui.home.activity.DetailActivity;
import com.lxf.zhuduoduo.ui.home.bean.ToastListBean;
import com.lxf.zhuduoduo.utils.PicassoUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.util.List;

public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.ViewHolder> {

    private Activity context;
    private List<ToastListBean.DataBean.GoodsBean> bean;

    public FreeAdapter(Activity context, List<ToastListBean.DataBean.GoodsBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_free, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //分享
                final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                        {
                                SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE
                        };
                new ShareAction(context).setDisplayList(displaylist)
                        .setShareboardclickCallback(shareBoardlistener).open();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id",""+bean.get(position).getGoods_id());
                context.startActivity(intent);
            }
        });
        PicassoUtils.showPhoto(context, bean.get(position).getGoods_img(), holder.ivImg);
        holder.tvName.setText("" + bean.get(position).getGoods_name());
        holder.tvPrice.setText("¥" + bean.get(position).getShop_price());
        holder.tvNum.setText("销量：" + bean.get(position).getGoods_xiaoliang());
        holder.tvScene.setText("场景：" + bean.get(position).getGoods_ad());

    }

    //分享面板的点击事件
    private ShareBoardlistener shareBoardlistener = new ShareBoardlistener() {
        @Override
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {

            if (share_media == null) {

            } else {
                UMImage image = new UMImage(context, R.mipmap.logo);//网络图片
                UMWeb web = new UMWeb("http://www.baidi.com/");
                web.setDescription("注多多");
                web.setThumb(image);
                web.setTitle("注多多标题");
                new ShareAction(context).setPlatform(share_media).setCallback(umShareListener)
                        .withMedia(web)
                        .share();
            }
        }
    };

    //分享的回调
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);
            Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "取消分享", Toast.LENGTH_SHORT).show();
        }
    };

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
        private TextView tvShare;
        private TextView tvCar;

        public ViewHolder(View view) {
            super(view);
            ivImg = (ImageView) view.findViewById(R.id.iv_img);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvPrice = (TextView) view.findViewById(R.id.tv_price);
            tvNum = (TextView) view.findViewById(R.id.tv_num);
            tvScene = (TextView) view.findViewById(R.id.tv_scene);
            tvShare = (TextView) view.findViewById(R.id.tv_share);
            tvCar = (TextView) view.findViewById(R.id.tv_car);
        }
    }
}
