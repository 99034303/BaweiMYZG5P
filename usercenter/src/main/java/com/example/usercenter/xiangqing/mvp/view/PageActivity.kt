package com.example.usercenter.xiangqing.mvp.view

import android.util.Log
import android.view.KeyEvent
import com.bumptech.glide.Glide
import com.example.core.view.BaseActivity
import com.example.usercenter.R
import com.example.usercenter.address.AddressActivity
import com.example.usercenter.address.AddressBean
import com.example.usercenter.main_and_cotegory.fragment.entity.Good_Tj
import com.example.usercenter.main_and_cotegory.fragment.entity.SouBean
import com.example.usercenter.shopping.entity.ShopBean
import com.example.usercenter.xiangqing.mvp.contract.AddCarContract
import com.example.usercenter.xiangqing.mvp.entity.AddCarBean
import com.example.usercenter.xiangqing.mvp.entity.GetAddBean
import com.example.usercenter.xiangqing.mvp.model.AddCarModel
import com.example.usercenter.xiangqing.mvp.presenter.AddCarPresenter
import com.example.usercenter.xiangqing.view.BigImageActivity
import kotlinx.android.synthetic.main.activity_page.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class PageActivity : BaseActivity<AddCarPresenter>(),AddCarContract.View {
    var tj: Good_Tj.DataBean?=null
    var data:SouBean.DataBean?=null
    lateinit var pic:String
    override fun initEvent() {
        //点击图片，进入图片放大页面
        iv_pageimage.setOnClickListener {
            if (tj!=null||data!=null){
                startActivity<BigImageActivity>("pic" to pic)
            }else{
                startActivity<BigImageActivity>("pic" to "https://img.alicdn.com/bao/uploaded/i2/3409374873/O1CN01dweK8p1lrsWeAapVi_!!0-item_pic.jpg")
            }
        }
        //点击返回关闭当前详情页
        iv_page_back.setOnClickListener {
            finish()
        }

        /**
         * 点击加入购物车
         * id:1010
         * username:1967789504
         * pwd:1967789504
         */
        bt_add_car.setOnClickListener {
            if (tj!=null){
                mPresenter.addcar(AddCarBean(1,""+tj?.itemId,1,""+tj?.title+"@@"+tj!!.zkFinalPrice.toFloat()+"@@"+tj!!.pictUrl))
            }else{
                mPresenter.addcar(AddCarBean(1,""+data?.itemId,1,""+data?.title+"@@"+data!!.zkFinalPrice.toFloat()+"@@"+data!!.pictUrl))
            }
        }
        //点击购买
        bt_add_mai.setOnClickListener {
            if (tj!=null){
                var sbeanlist1:ArrayList<AddressBean> = arrayListOf()
                sbeanlist1.add(AddressBean(pic,"1",tj!!.zkFinalPrice))
                startActivity<AddressActivity>("list" to sbeanlist1)
            }else{
                var sbeanlist2:ArrayList<AddressBean> = arrayListOf()
                sbeanlist2.add(AddressBean(pic,"1",data!!.zkFinalPrice))
                startActivity<AddressActivity>("list" to sbeanlist2)
            }
        }
    }

    override fun initData() {
        val extras = intent.extras
        val Tjbean = extras?.getSerializable("Tjbean")
        val souBean = extras?.getSerializable("souBean")
        if (Tjbean!=null){
            tj = Tjbean as Good_Tj.DataBean
        }else{
            data = souBean as SouBean.DataBean
        }
        Log.d("-----Tjbean------",""+Tjbean)
        Log.d("-----souBean------",""+souBean)
        if (Tjbean!=null){
            pic = tj!!.pictUrl
            Glide.with(this).load(""+pic)!!.into(iv_pageimage)
            tv_xiangqing_price.setText(""+ tj!!.zkFinalPrice)
            tv_xiangqing_title.setText(""+ tj!!.title)
        }else{
            pic = data!!.pictUrl
            Glide.with(this).load(""+pic)!!.into(iv_pageimage)
            tv_xiangqing_price.setText(""+ data!!.zkFinalPrice)
            tv_xiangqing_title.setText(""+ data!!.title)
        }
    }

    override fun initView() {
        mPresenter = AddCarPresenter(AddCarModel(),this)
    }

    override fun getLayout(): Int {
        return R.layout.activity_page
    }

    override fun onFailed(throwable: Throwable) {
        toast("添加失败")
    }

    override fun getaddbean(bean: GetAddBean) {
        toast("添加成功")
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK&& event?.repeatCount ==0){
            finish()
            Log.d("-----pageActivity---------","关闭成功")
            return true
        }
        return super.onKeyDown(keyCode, event)

    }


}