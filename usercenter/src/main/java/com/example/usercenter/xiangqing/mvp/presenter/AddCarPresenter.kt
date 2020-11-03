package com.example.usercenter.xiangqing.mvp.presenter

import android.util.Log
import com.example.core.presenter.BasePresenter
import com.example.usercenter.xiangqing.mvp.contract.AddCarContract
import com.example.usercenter.xiangqing.mvp.entity.AddCarBean
import com.example.usercenter.xiangqing.mvp.entity.GetAddBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class AddCarPresenter(mModel: AddCarContract.Model, mView: AddCarContract.View) : BasePresenter<AddCarContract.Model, AddCarContract.View>(mModel,mView) {
    fun addcar(addCarBean: AddCarBean){
        mModel.addcar(addCarBean,object :Observer<GetAddBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: GetAddBean) {
                Log.d("------f333--------",""+t)
                mView.getaddbean(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed(e)
            }
        })
    }
}