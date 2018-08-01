package com.lxf.zhuduoduo.ui.alcohol.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhf on 2018/7/2.
 */

public class WineCallerBean implements Serializable {

    /**
     * code : 0
     * msg : 成功!
     * data : [{"id":95,"goods_id":75,"goods_img":"uploads/goods/20180613/e76730a3df42af6e0867bded2e2d91d5.jpg","goods_guige":"750","price":400,"status":0,"state":1,"num":380,"usetime":"2018-06-12 13:09:03","goods_name":"希雅斯有机干红葡萄酒庄园级五星","duihuan":0},{"id":96,"goods_id":79,"goods_img":"uploads/goods/20180613/dcad90b54ca6b9d118c48fb11b8b8dd0.png","goods_guige":"750","price":300,"status":0,"state":1,"num":5,"usetime":"2018-06-12 13:35:00","goods_name":"希雅斯珍藏橡木桶干红葡萄酒","duihuan":0},{"id":53,"goods_id":74,"goods_img":"uploads/goods/20180613/3c58638b7c987440d6f3f556431eb251.png","goods_guige":"750","price":200,"status":0,"state":1,"num":26,"usetime":"2018-06-22 11:56:13","goods_name":"长城干红葡萄酒（神韵）","duihuan":0},{"id":54,"goods_id":74,"goods_img":"uploads/goods/20180613/3c58638b7c987440d6f3f556431eb251.png","goods_guige":"750","price":200,"status":0,"state":0,"num":0,"usetime":"2018-06-29 11:56:13","goods_name":"长城干红葡萄酒（神韵）","duihuan":0},{"id":55,"goods_id":74,"goods_img":"uploads/goods/20180613/3c58638b7c987440d6f3f556431eb251.png","goods_guige":"750","price":200,"status":0,"state":0,"num":0,"usetime":"2018-07-07 11:56:13","goods_name":"长城干红葡萄酒（神韵）","duihuan":0},{"id":56,"goods_id":74,"goods_img":"uploads/goods/20180613/3c58638b7c987440d6f3f556431eb251.png","goods_guige":"750","price":200,"status":0,"state":0,"num":0,"usetime":"2018-07-15 11:56:13","goods_name":"长城干红葡萄酒（神韵）","duihuan":0}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 95
         * goods_id : 75
         * goods_img : uploads/goods/20180613/e76730a3df42af6e0867bded2e2d91d5.jpg
         * goods_guige : 750
         * price : 400
         * status : 0
         * state : 1
         * num : 380
         * usetime : 2018-06-12 13:09:03
         * goods_name : 希雅斯有机干红葡萄酒庄园级五星
         * duihuan : 0
         */

        private int id;
        private int goods_id;
        private String goods_img;
        private String goods_guige;
        private int price;
        private int status;
        private int state;
        private int num;
        private String usetime;
        private String goods_name;
        private int duihuan;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getGoods_guige() {
            return goods_guige;
        }

        public void setGoods_guige(String goods_guige) {
            this.goods_guige = goods_guige;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getUsetime() {
            return usetime;
        }

        public void setUsetime(String usetime) {
            this.usetime = usetime;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getDuihuan() {
            return duihuan;
        }

        public void setDuihuan(int duihuan) {
            this.duihuan = duihuan;
        }
    }
}
