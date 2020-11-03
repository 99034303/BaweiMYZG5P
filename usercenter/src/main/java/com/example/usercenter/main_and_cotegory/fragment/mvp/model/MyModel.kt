package com.example.usercenter.main_and_cotegory.fragment.mvp.model

import com.example.core.manager.RetrofitManager
import com.example.core.model.IModel
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.main_and_cotegory.fragment.mvp.Api
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MyModel:IModel,UserContract.Model {
    override fun refister(bean: ReqUserBean, callback: Observer<Bean>) {
        RetrofitManager.create(Api::class.java)
            .register(bean)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }

    override fun login(bean: ReqUserBean, callback: Observer<Bean>) {
        RetrofitManager.create(Api::class.java)
            .login(bean)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }

    override fun getgoods(bean: Bean_Goods, callback: Observer<Good_Tj>) {
        RetrofitManager.create(Api::class.java)
            .getGoods(bean.page,bean.pagesize)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }

    override fun getsoubeans(keyword: String, callback: Observer<SouBean>) {
        RetrofitManager.create(Api::class.java)
            .getsougoods(keyword,"女",1,40)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }


}