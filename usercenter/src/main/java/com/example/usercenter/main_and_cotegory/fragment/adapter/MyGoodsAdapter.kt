package com.example.usercenter.main_and_cotegory.fragment.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.Good_Tj

class MyGoodsAdapter:BaseQuickAdapter<Good_Tj.DataBean,BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<Good_Tj.DataBean>?) : super(layoutResId, data)

    override fun convert(helper: BaseViewHolder?, item: Good_Tj.DataBean?) {
        helper?.setText(R.id.tv_showtitle,item?.shortTitle)
        helper?.setText(R.id.tv_stitle,item?.title)
        helper?.setText(R.id.tv_price,"￥${item?.zkFinalPrice}")
        val view = helper!!.getView<ImageView>(R.id.goods_image)
        Glide.with(mContext).load(item?.pictUrl).into(view)
    }
}