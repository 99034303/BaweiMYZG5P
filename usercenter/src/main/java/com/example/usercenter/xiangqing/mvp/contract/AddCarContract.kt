package com.example.usercenter.xiangqing.mvp.contract

import com.example.core.model.IModel
import com.example.core.view.IView
import io.reactivex.Observer
import com.example.usercenter.xiangqing.mvp.entity.AddCarBean
import com.example.usercenter.xiangqing.mvp.entity.GetAddBean

interface AddCarContract {
    interface Model:IModel{
        fun addcar(addCarBean: AddCarBean,callback: Observer<GetAddBean>)
    }

    interface View:IView{
        fun onFailed(throwable:Throwable)
        fun getaddbean(bean:GetAddBean)
    }


}