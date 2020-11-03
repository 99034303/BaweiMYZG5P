package com.example.usercenter.main_and_cotegory.fragment

import com.example.core.view.BaseFragment
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.entity.Bean
import com.example.usercenter.main_and_cotegory.fragment.entity.Good_Tj
import com.example.usercenter.main_and_cotegory.fragment.entity.SouBean
import com.example.usercenter.main_and_cotegory.fragment.mvp.contract.UserContract
import com.example.usercenter.main_and_cotegory.fragment.mvp.presenter.MyPresenter


class MyFragment : BaseFragment<MyPresenter>(), UserContract.View {
    override fun initEvent() {

    }

    override fun initData() {

    }

    override fun initView() {

    }

    override fun getLayout(): Int {
        return R.layout.fragment_my
    }

    override fun onSuccess(bean: Bean) {

    }

    override fun onFailed(throwable: Throwable) {

    }

    override fun getDatas(goods: Good_Tj) {

    }

    override fun getsou(goods: SouBean) {

    }


}