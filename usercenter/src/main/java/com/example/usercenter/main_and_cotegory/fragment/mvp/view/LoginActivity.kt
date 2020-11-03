package com.example.usercenter.main_and_cotegory.fragment.mvp.view

import com.example.core.view.BaseActivity
import com.example.core.view.IView
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.*
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import com.example.usercenter.main_and_cotegory.fragment.mvp.model.MyModel
import com.example.usercenter.main_and_cotegory.fragment.mvp.presenter.MyPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity<MyPresenter>(), IView, UserContract.View {
    lateinit var name:String
    lateinit var pwd:String
    override fun initEvent() {
        bt_login.setOnClickListener {
            name=et_login_name.text.toString()
            pwd=et_login_pwd.text.toString()
            if (name.isNotEmpty()&&pwd.isNotEmpty()){
                mPresenter.getloginMsg(ReqUserBean(name,pwd))
            }else{
                showMsg("不能为空")
            }
        }
        bt_logintoReister.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }

    override fun initData() {

    }

    override fun initView() {
        mPresenter = MyPresenter(MyModel(),this)
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun onSuccess(bean: Bean) {
        showMsg("${bean.msg}")
        startActivity<UserCenterActivity>()
    }

    override fun onFailed(throwable: Throwable) {
        showMsg("登录失败:=>${throwable.message}")
    }

    override fun getDatas(goods: Good_Tj) {

    }

    override fun getsou(goods: SouBean) {

    }
}