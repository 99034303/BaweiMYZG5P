package com.example.usercenter.address

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.example.usercenter.R
import kotlinx.android.synthetic.main.activity_select.*
import org.jetbrains.anko.startActivity

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        bt_new_address.setOnClickListener {
            startActivity<NewAddressActivity>()
        }
        address_back.setOnClickListener {
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