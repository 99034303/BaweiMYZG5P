package com.example.usercenter.mvpcategory.model

import com.example.core.manager.RetrofitManager
import com.example.core.model.IModel
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.mvpcategory.Api
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyModel:IModel,com.example.usercenter.mvpcategory.contract.UserContract.Model {
    override fun getfenbeans(callback: Observer<FenLeiBean>) {
        RetrofitManager.create(Api::class.java)
            .getsougoods(0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }

    override fun getfenbeans2(parent_id :Int,callback: Observer<FenLeiBean>) {
        RetrofitManager.create(Api::class.java)
            .getsougoods(parent_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }




}