package com.example.core.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.presenter.IPresenter
import org.jetbrains.anko.toast

abstract  class BaseFragment< P:IPresenter>:Fragment(),IView {
    protected lateinit var mPresenter:P
    protected lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView=inflater.inflate(getLayout(),container,false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initEvent()
    }

    abstract fun initEvent()


    abstract fun initData()

    abstract fun initView()

    abstract fun getLayout(): Int


}