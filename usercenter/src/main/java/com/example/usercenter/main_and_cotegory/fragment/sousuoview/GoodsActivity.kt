package com.example.usercenter.main_and_cotegory.fragment.sousuoview

import android.content.Intent
import android.util.Log
import android.view.KeyEvent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.view.BaseActivity
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.adapter.PhoneAdapter
import com.example.usercenter.main_and_cotegory.fragment.entity.Bean
import com.example.usercenter.main_and_cotegory.fragment.entity.Good_Tj
import com.example.usercenter.main_and_cotegory.fragment.entity.SouBean
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import com.example.usercenter.main_and_cotegory.fragment.mvp.model.MyModel
import com.example.usercenter.main_and_cotegory.fragment.mvp.presenter.MyPresenter
import com.example.usercenter.xiangqing.mvp.view.PageActivity
import kotlinx.android.synthetic.main.activity_goods.*
import org.jetbrains.anko.startActivity

class GoodsActivity : BaseActivity<MyPresenter>(),UserContract.View {
    var index:Int =0
    lateinit var goodname:String
    lateinit var phoneAdapter: PhoneAdapter
    var list:MutableList<SouBean.DataBean> = mutableListOf()
    override fun initEvent() {
        //点击返回关闭商品界面
        iv_back.setOnClickListener {
            finish()
        }
        et_sousuo.setOnClickListener {
            startActivity<SousuoActivity>()
            finish()
        }
        iv_menu.setOnClickListener {
            index++
            if (index==10){
                index=0
            }
            if (index%2==0){
                iv_menu.setImageResource(R.drawable.headmenu2)
            }else{
                iv_menu.setImageResource(R.drawable.headmenu)
            }
        }
    }

    override fun initData() {
        rv_phone.layoutManager = LinearLayoutManager(this)
    }

    override fun initView() {
        mPresenter = MyPresenter(MyModel(),this)
        val extras = intent.extras
        val string = extras?.getString("goods", "")
        Log.d("------------",""+string)
        et_sousuo.setText(string+"")
        mPresenter.getsou(string+"")
    }

    override fun getLayout(): Int {
        return R.layout.activity_goods
    }

    override fun onSuccess(bean: Bean) {

    }

    override fun onFailed(throwable: Throwable) {

    }

    override fun getDatas(goods: Good_Tj) {

    }

    override fun getsou(goods: SouBean) {
        list = goods.data
        phoneAdapter = PhoneAdapter(R.layout.iphone_item,list)
        rv_phone.adapter = phoneAdapter
        phoneAdapter.notifyDataSetChanged()
        phoneAdapter.setOnItemClickListener { adapter, view, position ->
            val bean:SouBean.DataBean = list.get(position)
            val intent = Intent(this@GoodsActivity, PageActivity::class.java)
            intent.putExtra("souBean",bean)
            startActivity(intent)
        }
    }
    //点击返回会关闭页面
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode== KeyEvent.KEYCODE_BACK&& event?.repeatCount ==0){
            finish()
            Log.d("-----pageActivity---------","关闭成功")
            return true
        }
        return super.onKeyDown(keyCode, event)

    }

}