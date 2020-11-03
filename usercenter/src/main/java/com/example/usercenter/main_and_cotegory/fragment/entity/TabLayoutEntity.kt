package com.example.user_center.bean

import com.flyco.tablayout.listener.CustomTabEntity

class TabLayoutEntity(var title:String,var select:Int,var unSelect:Int) : CustomTabEntity {
    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return select
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelect
    }
}