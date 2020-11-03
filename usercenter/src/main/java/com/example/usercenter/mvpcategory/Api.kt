package com.example.usercenter.mvpcategory

import com.example.usercenter.main_and_cotegory.fragment.entity.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("api/GoodsType/getTypes")
    fun getsougoods(@Query("parentId")parentId:Int):Observable<FenLeiBean>

}