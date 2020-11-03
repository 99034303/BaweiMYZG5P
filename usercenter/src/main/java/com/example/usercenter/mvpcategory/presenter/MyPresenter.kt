package com.example.usercenter.mvpcategory.presenter

import android.util.Log
import com.example.core.presenter.BasePresenter
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.mvpcategory.contract.UserContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MyPresenter(mModel: UserContract.Model, mView:UserContract.View) : BasePresenter<UserContract.Model, UserContract.View>(mModel,mView) {
    fun getsou(){
        mModel.getfenbeans(object :Observer<FenLeiBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: FenLeiBean) {
                Log.d("------f1111--------",""+t)
                mView.getfen(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed(e)
            }
        })
    }
    fun getfen2(prarent_id:Int){
        mModel.getfenbeans2(prarent_id,object :Observer<FenLeiBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: FenLeiBean) {
                Log.d("--------f222------",""+t)
                mView.getfen2(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed2(e)
            }
        })
    }
    fun getfen3(prarent_id:Int){
        mModel.getfenbeans2(prarent_id,object :Observer<FenLeiBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: FenLeiBean) {
                Log.d("------f333--------",""+t)
                mView.getfen3(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed3(e)
            }
        })
    }
}