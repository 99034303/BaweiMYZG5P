package com.example.usercenter.shopping.api

import com.example.usercenter.shopping.entity.GetCarBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingApi {

    @GET("api/ShoppingTrolley/getGoodsInfo")
    fun getCarGood(@Query("userid")userid:Int):Observable<GetCarBean>

}