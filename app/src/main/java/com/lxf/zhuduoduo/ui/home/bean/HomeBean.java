package com.lxf.zhuduoduo.ui.home.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhf on 2018/7/2.
 */

public class HomeBean implements Serializable {

    /**
     * data : {"banner":[{"ad_id":8,"ad_name":"第一个","ad_url":"https//","ad_img":"uploads/ad/20180611/b47cef3b6d3faa73faeab97aed8ab544.jpg"},{"ad_id":17,"ad_name":"第二个","ad_url":"https//","ad_img":"uploads/ad/20180612/af67c287f425b49d49c96d81b45131f5.jpg"},{"ad_id":19,"ad_name":"第三个","ad_url":"http://www.jiuxian.com/?ozs=1796708-1722","ad_img":"uploads/ad/20180612/c9ad512c8413d296e4b5e74115496b41.jpg"}],"gonggao":[{"id":10,"name":"注多多平台公告"},{"id":9,"name":"一分订购，买一瓶送半斤！"},{"id":8,"name":"注多多 让剩余时间更有价值！"},{"id":7,"name":"每日分享，即可免费领取。"},{"id":6,"name":"红酒免费领，赶紧选择自己喜欢的酒加入酒库吧！"}],"activity":[{"sales_id":31,"sales_name":"10元定制专享","sales_img":"uploads/sales/20180630/adb4a7828f6c196a3133093ef6f97c19.png"},{"sales_id":32,"sales_name":"1元半价","sales_img":"uploads/sales/20180630/bcd66cc36b53780b53db05b890ccc426.png"},{"sales_id":33,"sales_name":"1元狂欢购","sales_img":"uploads/sales/20180630/e082bc350ccbff09f5e69205df196fa4.png"},{"sales_id":34,"sales_name":"邀好友送红包","sales_img":"uploads/sales/20180630/30217de35ba7dfd1490e113915a3d978.png"}],"zixun":[{"mem_name":"步步青云。","id":28,"num":6},{"mem_name":"步步青云。","id":28,"num":6},{"mem_name":"步步青云。","id":28,"num":6},{"mem_name":"步步青云。","id":28,"num":5},{"mem_name":"步步青云。","id":28,"num":6},{"mem_name":"步步青云。","id":28,"num":5},{"mem_name":"李芳","id":33,"num":6},{"mem_name":"中年少女Aran","id":24,"num":5},{"mem_name":"穿平底鞋的小n","id":51,"num":6},{"mem_name":"步步青云。","id":28,"num":6}],"paihang":[{"mem_name":"时光","id":22,"allprice":712},{"mem_name":"中年少女Aran","id":24,"allprice":400},{"mem_name":"李燕彩","id":18,"allprice":304}]}
     * code : 0
     * msg : 成功
     */

    private DataBean data;
    private int code;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean implements Serializable{
        private List<BannerBean> banner;
        private List<GonggaoBean> gonggao;
        private List<ActivityBean> activity;
        private List<ZixunBean> zixun;
        private List<PaihangBean> paihang;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<GonggaoBean> getGonggao() {
            return gonggao;
        }

        public void setGonggao(List<GonggaoBean> gonggao) {
            this.gonggao = gonggao;
        }

        public List<ActivityBean> getActivity() {
            return activity;
        }

        public void setActivity(List<ActivityBean> activity) {
            this.activity = activity;
        }

        public List<ZixunBean> getZixun() {
            return zixun;
        }

        public void setZixun(List<ZixunBean> zixun) {
            this.zixun = zixun;
        }

        public List<PaihangBean> getPaihang() {
            return paihang;
        }

        public void setPaihang(List<PaihangBean> paihang) {
            this.paihang = paihang;
        }

        public static class BannerBean implements Serializable{
            /**
             * ad_id : 8
             * ad_name : 第一个
             * ad_url : https//
             * ad_img : uploads/ad/20180611/b47cef3b6d3faa73faeab97aed8ab544.jpg
             */

            private int ad_id;
            private String ad_name;
            private String ad_url;
            private String ad_img;

            public int getAd_id() {
                return ad_id;
            }

            public void setAd_id(int ad_id) {
                this.ad_id = ad_id;
            }

            public String getAd_name() {
                return ad_name;
            }

            public void setAd_name(String ad_name) {
                this.ad_name = ad_name;
            }

            public String getAd_url() {
                return ad_url;
            }

            public void setAd_url(String ad_url) {
                this.ad_url = ad_url;
            }

            public String getAd_img() {
                return ad_img;
            }

            public void setAd_img(String ad_img) {
                this.ad_img = ad_img;
            }
        }

        public static class GonggaoBean implements Serializable{
            /**
             * id : 10
             * name : 注多多平台公告
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ActivityBean implements Serializable{
            /**
             * sales_id : 31
             * sales_name : 10元定制专享
             * sales_img : uploads/sales/20180630/adb4a7828f6c196a3133093ef6f97c19.png
             */

            private int sales_id;
            private String sales_name;
            private String sales_img;

            public int getSales_id() {
                return sales_id;
            }

            public void setSales_id(int sales_id) {
                this.sales_id = sales_id;
            }

            public String getSales_name() {
                return sales_name;
            }

            public void setSales_name(String sales_name) {
                this.sales_name = sales_name;
            }

            public String getSales_img() {
                return sales_img;
            }

            public void setSales_img(String sales_img) {
                this.sales_img = sales_img;
            }
        }

        public static class ZixunBean implements Serializable{
            /**
             * mem_name : 步步青云。
             * id : 28
             * num : 6
             */

            private String mem_name;
            private int id;
            private int num;

            public String getMem_name() {
                return mem_name;
            }

            public void setMem_name(String mem_name) {
                this.mem_name = mem_name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class PaihangBean implements Serializable{
            /**
             * mem_name : 时光
             * id : 22
             * allprice : 712
             */

            private String mem_name;
            private int id;
            private int allprice;

            public String getMem_name() {
                return mem_name;
            }

            public void setMem_name(String mem_name) {
                this.mem_name = mem_name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAllprice() {
                return allprice;
            }

            public void setAllprice(int allprice) {
                this.allprice = allprice;
            }
        }
    }
}
