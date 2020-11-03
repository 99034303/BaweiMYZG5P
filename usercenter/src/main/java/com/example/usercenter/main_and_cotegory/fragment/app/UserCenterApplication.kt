package com.example.usercenter.main_and_cotegory.fragment.app

import android.content.Context
import androidx.multidex.MultiDex
import com.alipay.sdk.app.EnvUtils
import com.example.core.app.BaseApp

class UserCenterApplication:BaseApp() {
    override fun onCreate() {
        super.onCreate()
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX)
    }
     override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}