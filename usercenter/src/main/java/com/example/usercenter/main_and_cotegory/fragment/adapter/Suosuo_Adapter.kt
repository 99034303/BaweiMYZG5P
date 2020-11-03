package com.example.usercenter.main_and_cotegory.fragment.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.usercenter.R

class Suosuo_Adapter:BaseQuickAdapter<String,BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<String>?) : super(layoutResId, data)

    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.setText(R.id.tv_item_sousuo,item)
    }
}