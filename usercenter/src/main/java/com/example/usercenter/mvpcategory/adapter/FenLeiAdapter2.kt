package com.example.usercenter.mvpcategory.adapter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseViewHolder
import com.example.core.view.ZDYAdapter
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.FenLeiBean
import com.example.usercenter.mvpcategory.contract.UserContract
import com.example.usercenter.mvpcategory.model.MyModel
import com.example.usercenter.mvpcategory.presenter.MyPresenter1

class FenLeiAdapter2:ZDYAdapter<FenLeiBean.DataBean,MyPresenter1>,UserContract.View1 {
    var view:RecyclerView?=null
    var fenLeiAdapter3: FenLeiAdapter3? =null
    constructor(layoutResId: Int, data: MutableList<FenLeiBean.DataBean>?) : super(layoutResId, data)

//    override fun convert(helper: BaseViewHolder?, item: FenLeiBean.DataBean?) {
//        val view = helper!!.getView<RecyclerView>(R.id.rv_fen3)
//        view.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
//        view.adapter =CategoryFragment.fenAdapter3
////        view.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
//    }

    override fun convert(helper: BaseViewHolder?, item: FenLeiBean.DataBean) {
        helper?.setText(R.id.tv_fentext2,item?.category_name)
        view = helper!!.getView<RecyclerView>(R.id.rv_fen3)
        view!!.layoutManager=GridLayoutManager(mContext,3)
        mPresenter?.getfen4(item.category_id)
//        Log.d("zf","${item}")
    }

    override fun createPresenter() {
        mPresenter= MyPresenter1(MyModel(),this)
    }

    override fun onFailed12(throwable: Throwable) {

    }

    override fun getfen12(goods: FenLeiBean) {
        fenLeiAdapter3 = FenLeiAdapter3(R.layout.fen_item3,goods.data)
        view!!.adapter=fenLeiAdapter3
    }

}