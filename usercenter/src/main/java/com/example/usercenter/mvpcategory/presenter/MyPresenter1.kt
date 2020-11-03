package com.example.usercenter.mvpcategory.presenter

import android.util.Log
import com.example.core.presenter.BasePresenter
import com.example.usercenter.main_and_cotegory.fragment.entity.FenLeiBean
import com.example.usercenter.mvpcategory.contract.UserContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MyPresenter1(mModel: UserContract.Model, mView:UserContract.View1) : BasePresenter<UserContract.Model, UserContract.View1>(mModel,mView) {
    fun getfen4(prarent_id:Int){
        mModel.getfenbeans2(prarent_id,object :Observer<FenLeiBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: FenLeiBean) {
                Log.d("------f333--------",""+t)
                mView.getfen12(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed12(e)
            }
        })
    }
}