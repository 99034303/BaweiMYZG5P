package com.example.usercenter.main_and_cotegory.fragment.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.user_center.bean.TabLayoutEntity
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.*
import com.example.usercenter.shopping.view.ShoppingFragment
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_user_center.*

class UserCenterActivity : AppCompatActivity() {
    var arrayTabs = ArrayList<CustomTabEntity>()
    var arrayFragments = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_center)
        initView()
    }
    fun initView(){
        arrayTabs.add(TabLayoutEntity("主页",R.drawable.ic_home_unselect,R.drawable.ic_home_select))
        arrayTabs.add(TabLayoutEntity("分类",R.drawable.ic_category_unselect,R.drawable.ic_category_select))
        arrayTabs.add(TabLayoutEntity("发现",R.drawable.ic_discover_unselect,R.drawable.ic_discover_select))
        arrayTabs.add(TabLayoutEntity("购物车",R.drawable.ic_shop_unselect,R.drawable.ic_shop_select))
        arrayTabs.add(TabLayoutEntity("我的",R.drawable.ic_my_unselect,R.drawable.ic_my_select))
        arrayFragments.add(HomeFragment())
        arrayFragments.add(CategoryFragment())
        arrayFragments.add(DiscoverFragment())
        arrayFragments.add(ShoppingFragment())
        arrayFragments.add(MyFragment())
        tab_layout.setTabData(arrayTabs,this,R.id.frame_layout,arrayFragments)
    }
}
