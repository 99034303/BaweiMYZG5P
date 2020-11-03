package com.example.usercenter.mvpcategory.contract

import com.example.core.model.IModel
import com.example.core.view.IView
import io.reactivex.Observer
import com.example.usercenter.main_and_cotegory.fragment.entity.FenLeiBean

interface UserContract {
    interface Model:IModel{
        fun getfenbeans(callback: Observer<FenLeiBean>)
        fun getfenbeans2(parent_id :Int,callback: Observer<FenLeiBean>)
    }

    interface View:IView{
        fun onFailed(throwable:Throwable)
        fun onFailed2(throwable:Throwable)
        fun onFailed3(throwable:Throwable)
        fun getfen(goods:FenLeiBean)
        fun getfen2(goods:FenLeiBean)
        fun getfen3(goods:FenLeiBean)
    }

    interface View1:IView{
        fun onFailed12(throwable:Throwable)
        fun getfen12(goods:FenLeiBean)
    }


}