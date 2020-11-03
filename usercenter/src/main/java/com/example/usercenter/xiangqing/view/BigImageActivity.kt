package com.example.usercenter.xiangqing.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.bumptech.glide.Glide
import com.example.usercenter.R
import kotlinx.android.synthetic.main.activity_big_image.*

class BigImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_image)
        //获取得到图片的数据
        val extras = intent.extras
        val pic = extras!!.getString("pic")
        Glide.with(this).load(pic+"").into(iv_bigImage)
        //点击退出图片界面
        iv_bigImage.setOnClickListener {
            finish()
        }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode== KeyEvent.KEYCODE_BACK&& event?.repeatCount ==0){
            finish()
            Log.d("-----pageActivity---------","关闭成功")
            return true
        }
        return super.onKeyDown(keyCode, event)

    }

}