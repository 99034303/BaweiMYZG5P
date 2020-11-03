package com.example.usercenter.shopping.contract

import com.example.core.model.IModel
import com.example.core.view.IView
import io.reactivex.Observer
import com.example.usercenter.shopping.entity.GetCarBean

interface ShoppingContract {
    interface Model:IModel{
        fun getcarGoods(userid:Int,callback: Observer<GetCarBean>)
    }

    interface View:IView{
        fun onFailed(throwable:Throwable)
        fun getcarData(getCarBean: GetCarBean)
    }

}