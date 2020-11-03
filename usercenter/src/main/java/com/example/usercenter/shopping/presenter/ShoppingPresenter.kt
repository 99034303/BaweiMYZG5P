package com.example.usercenter.shopping.presenter

import android.util.Log
import com.example.core.presenter.BasePresenter
import com.example.usercenter.main_and_cotegory.fragment.entity.FenLeiBean
import com.example.usercenter.mvpcategory.contract.UserContract
import com.example.usercenter.shopping.contract.ShoppingContract
import com.example.usercenter.shopping.entity.GetCarBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ShoppingPresenter(mModel: ShoppingContract.Model, mView: ShoppingContract.View) : BasePresenter<ShoppingContract.Model, ShoppingContract.View>(mModel,mView) {
    fun getShoppingCarDara(userid:Int){
        mModel.getcarGoods(userid,object :Observer<GetCarBean>{
            override fun onComplete() {

            }
            override fun onSubscribe(d: Disposable) {

            }
            override fun onNext(t: GetCarBean) {
                Log.d("------f333--------",""+t)
                mView.getcarData(t)
            }
            override fun onError(e: Throwable) {
                Log.d("--------------","失败"+e.message)
                mView.onFailed(e)
            }
        })
    }
}