package com.lxf.zhuduoduo.ui.alcohol.bean;

import java.io.Serializable;
import java.util.List;

public class GiveMessageBean implements Serializable {

    /**
     * code : 0
     * data : [{"id":7,"gid":60,"goods_img":"uploads/goods/20180608/010432a7794af24bf62b5e099f374877.jpg","goods_title":"老村长2号","username":"时光","guige":200,"state":0},{"id":1,"gid":46,"goods_img":"uploads/goods/20180608/20c3260a7f7d2e7b245a683d9e0101c5.jpg","goods_title":"Dynasty王朝 悦彩美乐至优干红葡萄酒红酒","username":"天天","guige":200,"state":1},{"id":3,"gid":46,"goods_img":"uploads/goods/20180608/20c3260a7f7d2e7b245a683d9e0101c5.jpg","goods_title":"Dynasty王朝 悦彩美乐至优干红葡萄酒红酒","username":"天天","guige":100,"state":2}]
     * msg : 成功!
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
         * id : 7
         * gid : 60
         * goods_img : uploads/goods/20180608/010432a7794af24bf62b5e099f374877.jpg
         * goods_title : 老村长2号
         * username : 时光
         * guige : 200
         * state : 0
         */

        private int id;
        private int gid;
        private String goods_img;
        private String goods_title;
        private String username;
        private int guige;
        private int state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGid() {
            return gid;
        }

        public void setGid(int gid) {
            this.gid = gid;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getGoods_title() {
            return goods_title;
        }

        public void setGoods_title(String goods_title) {
            this.goods_title = goods_title;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getGuige() {
            return guige;
        }

        public void setGuige(int guige) {
            this.guige = guige;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}
