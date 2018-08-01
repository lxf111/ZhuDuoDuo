package com.lxf.zhuduoduo.ui.my.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhf on 2018/7/4.
 */

public class AddressBean implements Serializable {

    /**
     * code : 0
     * msg : 成功
     * data : [{"id":12,"username":"葛福才","telphone":"18790296652","province":"河南省","city":"郑州市","area":"金水区","address":"湖泊名称","is_moren":1}]
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

    public static class DataBean implements Serializable {
        /**
         * id : 12
         * username : 葛福才
         * telphone : 18790296652
         * province : 河南省
         * city : 郑州市
         * area : 金水区
         * address : 湖泊名称
         * is_moren : 1
         */

        private int id;
        private String username;
        private String telphone;
        private String province;
        private String city;
        private String area;
        private String address;
        private int is_moren;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIs_moren() {
            return is_moren;
        }

        public void setIs_moren(int is_moren) {
            this.is_moren = is_moren;
        }
    }
}
