package com.example.usercenter.main_and_cotegory.fragment.mvp.view

import com.example.core.view.BaseActivity
import com.example.core.view.IView
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import com.example.usercenter.main_and_cotegory.fragment.mvp.model.MyModel
import com.example.usercenter.main_and_cotegory.fragment.mvp.presenter.MyPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<MyPresenter>(),IView,UserContract.View {
    lateinit var name:String
    lateinit var pwd:String
    lateinit var pwd2:String

    override fun initEvent() {
        bt_register.setOnClickListener {
            name=et_register_name.text.toString()
            pwd=et_register_pwd.text.toString()
            pwd2=et_register_pwd2.text.toString()
            if (pwd==pwd2){
                if (name.isNotEmpty()&&pwd.isNotEmpty()){
                    mPresenter.getRegisterMsg(ReqUserBean(name,pwd))
                }else{
                    showMsg("不能为空")
                }
            }else{
                showMsg("密码不一致")
            }
        }
    }

    override fun initData() {

    }

    override fun initView() {
        mPresenter = MyPresenter(MyModel(),this)
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    override fun onSuccess(bean: Bean) {
        showMsg("${bean.msg}")
        finish()
    }

    override fun onFailed(throwable: Throwable) {
        showMsg("注册失败:=>${throwable.message}")
    }

    override fun getDatas(goods: Good_Tj) {

    }

    override fun getsou(goods: SouBean) {

    }


}