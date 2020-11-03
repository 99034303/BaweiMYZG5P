package com.example.usercenter.address;

import java.io.Serializable;

public class AddressBean implements Serializable {
    public AddressBean() {
    }
    private String pic;
    private String num;
    private String price;

    public AddressBean(String pic, String num, String price) {
        this.pic = pic;
        this.num = num;
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
