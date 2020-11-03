package com.example.usercenter.shopping.model

import com.example.core.manager.RetrofitManager
import com.example.core.model.IModel
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.mvpcategory.Api
import com.example.usercenter.shopping.api.ShoppingApi
import com.example.usercenter.shopping.contract.ShoppingContract
import com.example.usercenter.shopping.entity.GetCarBean
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ShoppingModel:IModel, ShoppingContract.Model {

    override fun getcarGoods(userid: Int, callback: Observer<GetCarBean>) {
        RetrofitManager.create(ShoppingApi::class.java)
            .getCarGood(userid)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }


}