package com.example.usercenter.shopping.entity;

import java.util.List;

public class GetCarBean {


    /**
     * code : 200
     * data : [{"id":463,"goodscode":"106","nums":107,"goodsdetail":"108","userid":1009},{"id":464,"goodscode":"106","nums":107,"goodsdetail":"108","userid":1009}]
     * msg : 操作成功
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
         * id : 463
         * goodscode : 106
         * nums : 107
         * goodsdetail : 108
         * userid : 1009
         */

        private int id;
        private String goodscode;
        private int nums;
        private String goodsdetail;
        private int userid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGoodscode() {
            return goodscode;
        }

        public void setGoodscode(String goodscode) {
            this.goodscode = goodscode;
        }

        public int getNums() {
            return nums;
        }

        public void setNums(int nums) {
            this.nums = nums;
        }

        public String getGoodsdetail() {
            return goodsdetail;
        }

        public void setGoodsdetail(String goodsdetail) {
            this.goodsdetail = goodsdetail;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }
}
