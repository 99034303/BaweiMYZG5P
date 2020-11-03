package com.example.usercenter.main_and_cotegory.fragment.mvp.presenter

import android.util.Log
import com.example.core.presenter.BasePresenter
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MyPresenter(mModel: UserContract.Model,mView:UserContract.View) : BasePresenter<UserContract.Model, UserContract.View>(mModel,mView) {
    fun getRegisterMsg(userBean: ReqUserBean){
        mModel.refister(userBean,object :Observer<Bean>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Bean) {
                mView.onSuccess(t)
            }

            override fun onError(e: Throwable) {
                mView.onFailed(e)
            }

        })
    }
    fun getloginMsg(userBean: ReqUserBean){
        mModel.login(userBean,object :Observer<Bean>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Bean) {
                mView.onSuccess(t)
            }

            override fun onError(e: Throwable) {
                mView.onFailed(e)
            }

        })
    }
    fun getData(beanGoods: Bean_Goods){
        mModel.getgoods(beanGoods,object :Observer<Good_Tj>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: Good_Tj) {
                Log.d("--------------",""+t)
                mView.getDatas(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed(e)
            }
        })
    }
    fun getsou(keyword: String){
        mModel.getsoubeans(keyword,object :Observer<SouBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: SouBean) {
                Log.d("--------------",""+t)
                mView.getsou(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed(e)
            }
        })
    }
}