package com.example.usercenter.mvpcategory.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.FenLeiBean

class FenLeiAdapter:BaseQuickAdapter<FenLeiBean.DataBean,BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<FenLeiBean.DataBean>?) : super(
        layoutResId,
        data
    )

    override fun convert(helper: BaseViewHolder?, item: FenLeiBean.DataBean?) {
        helper?.setText(R.id.tv_fentext1,item?.category_name)

    }

}