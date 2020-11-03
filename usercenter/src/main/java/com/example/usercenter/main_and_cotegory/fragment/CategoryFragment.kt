package com.example.usercenter.main_and_cotegory.fragment

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.view.BaseFragment
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.FenLeiBean
import com.example.usercenter.main_and_cotegory.fragment.sousuoview.SousuoActivity
import com.example.usercenter.mvpcategory.adapter.FenLeiAdapter
import com.example.usercenter.mvpcategory.adapter.FenLeiAdapter2
import com.example.usercenter.mvpcategory.contract.UserContract
import com.example.usercenter.mvpcategory.model.MyModel
import com.example.usercenter.mvpcategory.presenter.MyPresenter
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseFragment<MyPresenter>(), UserContract.View {
    lateinit var fenAdapter:FenLeiAdapter
    lateinit var fenAdapter2:FenLeiAdapter2

//    companion object{
//        lateinit var fenAdapter3:FenLeiAdapter3
//    }

    var list1:MutableList<FenLeiBean.DataBean> = mutableListOf()
    var list2:MutableList<FenLeiBean.DataBean> = mutableListOf()
//    var list3:MutableList<FenLeiBean.DataBean> = mutableListOf()
    override fun initEvent() {
        //点击进入搜索界面
        et_fenglei.setOnClickListener {
            val intent = Intent(activity, SousuoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initData() {
        rv_fen1.layoutManager=LinearLayoutManager(context)
        rv_fen2.layoutManager=LinearLayoutManager(context)
//        rv_fen3.layoutManager=LinearLayoutManager(context)
        /**
         * 适配器
         */
        fenAdapter = FenLeiAdapter(R.layout.fen_item,list1)
        fenAdapter2 = FenLeiAdapter2(R.layout.fen_item2,list2)
        rv_fen2.adapter = fenAdapter2
//        fenAdapter3=FenLeiAdapter3(R.layout.fen_item3,list3)
        /**
         * 获取数据网络请求
         */
        mPresenter.getsou()


    }

    override fun initView() {
        val rv_fen1 = mView.findViewById<RecyclerView>(R.id.rv_fen1)
        val rv_fen2 = mView.findViewById<RecyclerView>(R.id.rv_fen2)
//        val rv_fen3 = mView.findViewById<RecyclerView>(R.id.rv_fen3)
        mPresenter=MyPresenter(MyModel(),this)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_category
    }

    override fun getfen(goods: FenLeiBean) {
        val data = goods.data
        mPresenter.getfen2(data.get(0).category_id)
        list1.clear()
        list1.addAll(data)
        rv_fen1.adapter = fenAdapter
        fenAdapter.notifyDataSetChanged()

        fenAdapter.setOnItemClickListener { adapter, view, position ->
            val id = data.get(position).category_id
            Log.d("----------","${id}")
            mPresenter.getfen2(id)
            fenAdapter2.notifyDataSetChanged()
        }
    }

    override fun getfen2(goods: FenLeiBean) {
        val data = goods.data
        list2.clear()
        list2.addAll(data)
        fenAdapter2.notifyDataSetChanged()
//        for (i in 0..data.size-1){
//            val dataBean = data[i]
//            mPresenter.getfen3(dataBean.category_id)
//            Log.d("--------id=>--","${dataBean.category_id}")
//        }

    }

    override fun getfen3(goods: FenLeiBean) {
        val data = goods.data
//        list3.clear()
//        fenAdapter3.notifyDataSetChanged()
//        Log.d("--------list3=>--","${list3}")
//        fenAdapter3.notifyDataSetChanged()
//        fenAdapter3 = FenLeiAdapter3(R.layout.fen_item2,list3)
//        rv_fen3.adapter = fenAdapter3

    }

    override fun onFailed(throwable: Throwable) {

    }

    override fun onFailed2(throwable: Throwable) {

    }

    override fun onFailed3(throwable: Throwable) {

    }

}