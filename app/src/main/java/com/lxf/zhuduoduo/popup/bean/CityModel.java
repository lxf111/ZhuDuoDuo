package com.lxf.zhuduoduo.popup.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class CityModel {

    /**
     * result : 0
     * resultNote : 获取成功
     * content : [{"id":"438808391673427799bdabeea1e2ccc3","price":100,"name":"郑州","code":"410100","type":"0"},{"id":"c15f3955dd564d13a8d4fa339e45be84","price":200.1,"name":"洛阳","code":"410300","type":"0"}]
     * countryPrice : 300.05
     */

    private String result;
    private String resultNote;
    private String countryPrice;
    private List<ContentBean> content;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultNote() {
        return resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    public String getCountryPrice() {
        return countryPrice;
    }

    public void setCountryPrice(String countryPrice) {
        this.countryPrice = countryPrice;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * id : 438808391673427799bdabeea1e2ccc3
         * price : 100.0
         * name : 郑州
         * code : 410100
         * type : 0
         */

        private String id;
        private double price;
        private String name;
        private String code;
        private String type;
        private String sortLetters;

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
