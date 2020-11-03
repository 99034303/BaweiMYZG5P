package com.example.core.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.presenter.IPresenter
import org.jetbrains.anko.toast

abstract  class BaseActivity< P:IPresenter>:AppCompatActivity(),IView {
    protected lateinit var mPresenter:P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView()
        initData()
        initEvent()
    }

    abstract fun initEvent()


    abstract fun initData()

    abstract fun initView()

    abstract fun getLayout(): Int

    fun showMsg(msg:String){
        toast(""+msg)
    }
}