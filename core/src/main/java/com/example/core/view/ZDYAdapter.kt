package com.example.core.view

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.core.presenter.BasePresenter
import com.example.core.presenter.IPresenter

abstract class ZDYAdapter<T, P: BasePresenter<*, *>>:BaseQuickAdapter<T,BaseViewHolder> {
    protected var mPresenter:P?=null
    constructor(layoutResId: Int, data: MutableList<T>?) : super(layoutResId, data)

    abstract override fun convert(helper: BaseViewHolder?, item: T)
    init{
         createPresenter()
    }

    abstract fun createPresenter()
}