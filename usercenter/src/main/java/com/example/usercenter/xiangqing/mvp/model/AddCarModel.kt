package com.example.usercenter.xiangqing.mvp.model

import com.example.core.manager.RetrofitManager
import com.example.core.model.IModel
import com.example.usercenter.xiangqing.mvp.api.AddCarApi
import com.example.usercenter.xiangqing.mvp.contract.AddCarContract
import com.example.usercenter.xiangqing.mvp.entity.AddCarBean
import com.example.usercenter.xiangqing.mvp.entity.GetAddBean
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddCarModel:IModel, AddCarContract.Model {
    override fun addcar(addCarBean: AddCarBean, callback: Observer<GetAddBean>) {
        RetrofitManager.create(AddCarApi::class.java)
            .getsougoods(addCarBean)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }


}