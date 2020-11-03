package com.example.usercenter.main_and_cotegory.fragment.mvp.contract

import com.example.core.model.IModel
import com.example.core.view.IView
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import io.reactivex.Observer

interface UserContract {
    interface Model:IModel{
        fun refister(bean:ReqUserBean,callback: Observer<Bean>)
        fun login(bean:ReqUserBean,callback: Observer<Bean>)
        fun getgoods(bean:Bean_Goods,callback: Observer<Good_Tj>)
        fun getsoubeans(keyword :String,callback: Observer<SouBean>)
    }

    interface View:IView{
        fun onSuccess(bean: Bean)
        fun onFailed(throwable:Throwable)
        fun getDatas(goods:Good_Tj)
        fun getsou(goods:SouBean)
    }
}