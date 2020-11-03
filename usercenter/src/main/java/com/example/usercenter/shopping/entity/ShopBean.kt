package com.example.usercenter.shopping.entity

import java.io.Serializable

data class ShopBean(var goodscode:String, var pic:String, var title:String, var price:Float, var num:Int, var boolean: Boolean =false) {
}