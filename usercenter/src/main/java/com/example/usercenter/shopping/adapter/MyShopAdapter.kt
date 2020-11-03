package com.example.usercenter.shopping.adapter

import android.widget.CheckBox
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.usercenter.R
import com.example.usercenter.shopping.entity.ShopBean

class MyShopAdapter:BaseQuickAdapter<ShopBean,BaseViewHolder> {
    constructor(layoutResId: Int, data: MutableList<ShopBean>?) : super(layoutResId, data)

    override fun convert(helper: BaseViewHolder?, item: ShopBean?) {
        helper?.setText(R.id.tv_shop_title,item?.title)
        helper?.setText(R.id.tv_shop_price,"￥"+item?.price)
        helper?.setText(R.id.tv_shop_num,"${item?.num}")
        val cb_shop_item = helper!!.getView<CheckBox>(R.id.cb_shop_item)
        cb_shop_item.isChecked= item!!.boolean
        Glide.with(mContext).load(item?.pic).into(helper!!.getView(R.id.iv_shop_item))

        //为子控件添加点击事件
        helper.addOnClickListener(R.id.tv_shop_del)
            .addOnClickListener(R.id.tv_shop_add)
            .addOnClickListener(R.id.cb_shop_item)

    }
}