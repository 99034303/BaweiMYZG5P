package com.example.usercenter.main_and_cotegory.fragment.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.RefreshGridBean

class RefReshRecyAdapter:BaseQuickAdapter<RefreshGridBean,BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<RefreshGridBean>?) : super(layoutResId, data)

    override fun convert(helper: BaseViewHolder?, item: RefreshGridBean?) {
        helper?.setText(R.id.item_name,item?.titletop)
        helper?.setText(R.id.item_text,item?.titlebottom)
        Glide.with(mContext).load(item?.icon).into(helper!!.getView(R.id.item_image))
    }

}