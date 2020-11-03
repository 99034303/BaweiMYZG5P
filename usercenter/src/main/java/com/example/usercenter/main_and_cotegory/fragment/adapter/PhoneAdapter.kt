package com.example.usercenter.main_and_cotegory.fragment.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.SouBean

class PhoneAdapter:BaseQuickAdapter<SouBean.DataBean,BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<SouBean.DataBean>?) : super(layoutResId, data)

    override fun convert(helper: BaseViewHolder?, item: SouBean.DataBean?) {
        Glide.with(mContext).load(item?.pictUrl).into(helper!!.getView(R.id.iv_phone1))
        helper.setText(R.id.tv_phone_name,item?.shortTitle)
        helper.setText(R.id.tv_phone_price,"￥"+item?.zkFinalPrice)
        helper.setText(R.id.tv_phone_dianpu,item?.title)
    }
}