package com.lxf.zhuduoduo.ui.home.bean;

import java.util.List;

public class BrandBean {

    /**
     * code : 0
     * msg : 成功
     * data : [{"brand_id":5,"brand_name":"茅台","brand_logo":"uploads/brand/20180425/0853b3d93a8135fa461191f020ffdd7f.jpg"},{"brand_id":8,"brand_name":"五粮液","brand_logo":"uploads/brand/20180507/f9358da760941b1b5e36e56cfb5bd242.jpg"},{"brand_id":22,"brand_name":"Dynasty王朝","brand_logo":"uploads/brand/20180606/88b153feef4b55bef319cc4d03a241de.jpg"},{"brand_id":24,"brand_name":"希雅斯","brand_logo":"uploads/brand/20180607/1da3656fb24e92aa28899c59fb1f0fd3.jpg"},{"brand_id":25,"brand_name":"名葡萃","brand_logo":"uploads/brand/20180609/cd821ff06e44bf189cc85764a5e792e4.jpg"},{"brand_id":27,"brand_name":"长城","brand_logo":"uploads/brand/20180611/c7aa77fd3022200d8e757a0f2a174eb8.png"}]
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
         * brand_id : 5
         * brand_name : 茅台
         * brand_logo : uploads/brand/20180425/0853b3d93a8135fa461191f020ffdd7f.jpg
         */

        private int brand_id;
        private String brand_name;
        private String brand_logo;

        public int getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(int brand_id) {
            this.brand_id = brand_id;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getBrand_logo() {
            return brand_logo;
        }

        public void setBrand_logo(String brand_logo) {
            this.brand_logo = brand_logo;
        }
    }
}
