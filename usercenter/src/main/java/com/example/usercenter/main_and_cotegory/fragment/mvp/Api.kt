package com.example.usercenter.main_and_cotegory.fragment.mvp

import com.example.usercenter.main_and_cotegory.fragment.entity.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @POST("api/User/register")
    fun register(@Body reBean:ReqUserBean):Observable<Bean>

    @POST("api/User/login")
    fun login(@Body reBean:ReqUserBean):Observable<Bean>

    @GET("api/Goods/getRecommendGoods")
    fun getGoods(@Query("page")page:Int,@Query("pagesize")pagesize:Int ):Observable<Good_Tj>

    @GET("api/Goods/getGoods")
    fun getsougoods(@Query("keyword")keyword:String,@Query("type")type:String ,@Query("pageno")pageno:Int,@Query("pagesize")pagesize:Int):Observable<SouBean>

}