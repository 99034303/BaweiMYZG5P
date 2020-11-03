package com.example.core.presenter

import com.example.core.model.IModel
import com.example.core.view.IView
import java.lang.ref.SoftReference

abstract class BasePresenter<M:IModel,V:IView>(protected var  mModel: M,protected var  mView: V):IPresenter {

    override fun Destory() {

    }
}