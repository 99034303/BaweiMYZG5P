package com.example.usercenter.main_and_cotegory.fragment

import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.core.view.BaseFragment
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.adapter.MyGoodsAdapter
import com.example.usercenter.main_and_cotegory.fragment.adapter.RefReshRecyAdapter
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import com.example.usercenter.main_and_cotegory.fragment.mvp.model.MyModel
import com.example.usercenter.main_and_cotegory.fragment.mvp.presenter.MyPresenter
import com.example.usercenter.main_and_cotegory.fragment.sousuoview.SousuoActivity
import com.example.usercenter.xiangqing.mvp.view.PageActivity
import com.youth.banner.Banner
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<MyPresenter>(),UserContract.View {
    var goods_list:ArrayList<Good_Tj.DataBean> = arrayListOf()
    var banner_list:MutableList<Int> = mutableListOf(R.drawable.ic_banner_01,R.drawable.ic_banner_02,R.drawable.ic_banner_03)
    lateinit var goodsAdapter:MyGoodsAdapter
    override fun initEvent() {
        //点击进入搜索界面
        et_sousuo.setOnClickListener {
            val intent = Intent(activity, SousuoActivity::class.java)
            startActivity(intent)
        }
        //点击相机进入拍照界面
//        iv_paizhao.setOnClickListener {
//
//        }
    }

    override fun initData() {
        bannerstart()
        GridGiveData()
        mPresenter.getData(Bean_Goods(1,20))
        rv_tuijian.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

    }

    private fun bannerstart() {
        banner.setImages(banner_list)
        banner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                Glide.with(context!!).load(path).into(imageView!!)
            }

        })
        banner.start()
    }

    //添加网格布局数据
    private fun GridGiveData() {
        var graidList:MutableList<RefreshGridBean> = mutableListOf()
        graidList.add(RefreshGridBean(R.drawable.redyuan,"超市","京东超市"))
        graidList.add(RefreshGridBean(R.drawable.ziyuan,"数码","数码电器"))
        graidList.add(RefreshGridBean(R.drawable.yuan ,"服饰","京东服饰"))
        graidList.add(RefreshGridBean(R.drawable.greenyuan,"生鲜","京东生鲜"))
        graidList.add(RefreshGridBean(R.drawable.danlvyuan ,"到家","京东到家"))
        graidList.add(RefreshGridBean(R.drawable.blueyuan,"服务","充值缴费"))
        graidList.add(RefreshGridBean(R.drawable.dousha,"京豆","领京豆"))
        graidList.add(RefreshGridBean(R.drawable.shenhuang,"领券","领券"))
        graidList.add(RefreshGridBean(R.drawable.yingtao,"借钱","借钱"))
        graidList.add(RefreshGridBean(R.drawable.yshenlanuan,"会员","PLUS会员"))
        val refReshRecyAdapter = RefReshRecyAdapter(R.layout.refresh_adapter_item, graidList)

        rv_title.layoutManager = GridLayoutManager(activity,5)

        rv_title.adapter = refReshRecyAdapter
    }

    override fun initView() {
        val rv_title = mView.findViewById<RecyclerView>(R.id.rv_title)
        val rv_tuijian = mView.findViewById<RecyclerView>(R.id.rv_tuijian)
        val banner = mView.findViewById<Banner>(R.id.banner)
        val iv_paizhao = mView.findViewById<ImageView>(R.id.iv_paizhao)
        val et_sousuo = mView.findViewById<EditText>(R.id.et_sousuo)
        mPresenter = MyPresenter(MyModel(),this)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_home
    }

    override fun onSuccess(bean: Bean) {

    }

    override fun onFailed(throwable: Throwable) {

    }

    override fun getDatas(goods: Good_Tj) {
        val data = goods.data

        goods_list.addAll(data)
        goodsAdapter = MyGoodsAdapter(R.layout.item_goods,goods_list)
        rv_tuijian.adapter=goodsAdapter
        goodsAdapter.notifyDataSetChanged()
        goodsAdapter.setOnItemClickListener { adapter, view, position ->
            val bean:Good_Tj.DataBean = goods_list.get(position)
            val intent = Intent(activity, PageActivity::class.java)
            intent.putExtra("Tjbean",bean)
            startActivity(intent)
        }
    }

    override fun getsou(goods: SouBean) {

    }

}