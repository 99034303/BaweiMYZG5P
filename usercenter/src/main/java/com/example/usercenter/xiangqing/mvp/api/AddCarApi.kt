package com.example.usercenter.xiangqing.mvp.api

import com.example.usercenter.xiangqing.mvp.entity.AddCarBean
import com.example.usercenter.xiangqing.mvp.entity.GetAddBean
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface AddCarApi {

    @POST("api/ShoppingTrolley/addGoods")
    fun getsougoods(@Body addCarBean: AddCarBean):Observable<GetAddBean>

}