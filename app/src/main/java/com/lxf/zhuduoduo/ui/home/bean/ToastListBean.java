package com.lxf.zhuduoduo.ui.home.bean;

import java.io.Serializable;
import java.util.List;

public class ToastListBean implements Serializable{

    /**
     * code : 0
     * msg : 成功
     * data : {"goods":[{"goods_id":76,"goods_name":"长城桑干珍藏级梅鹿辄赤霞珠","shop_price":"480.00","goods_img":"uploads/goods/20180613/ff38ad5905ed02fbdf06307289f7979c.png","goods_ad":"","goods_xiaoliang":0}],"banner":null}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goods : [{"goods_id":76,"goods_name":"长城桑干珍藏级梅鹿辄赤霞珠","shop_price":"480.00","goods_img":"uploads/goods/20180613/ff38ad5905ed02fbdf06307289f7979c.png","goods_ad":"","goods_xiaoliang":0}]
         * banner : null
         */

        private Object banner;
        private List<GoodsBean> goods;

        public Object getBanner() {
            return banner;
        }

        public void setBanner(Object banner) {
            this.banner = banner;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * goods_id : 76
             * goods_name : 长城桑干珍藏级梅鹿辄赤霞珠
             * shop_price : 480.00
             * goods_img : uploads/goods/20180613/ff38ad5905ed02fbdf06307289f7979c.png
             * goods_ad :
             * goods_xiaoliang : 0
             */

            private int goods_id;
            private String goods_name;
            private String shop_price;
            private String goods_img;
            private String goods_ad;
            private int goods_xiaoliang;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getShop_price() {
                return shop_price;
            }

            public void setShop_price(String shop_price) {
                this.shop_price = shop_price;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

            public String getGoods_ad() {
                return goods_ad;
            }

            public void setGoods_ad(String goods_ad) {
                this.goods_ad = goods_ad;
            }

            public int getGoods_xiaoliang() {
                return goods_xiaoliang;
            }

            public void setGoods_xiaoliang(int goods_xiaoliang) {
                this.goods_xiaoliang = goods_xiaoliang;
            }
        }
    }
}
