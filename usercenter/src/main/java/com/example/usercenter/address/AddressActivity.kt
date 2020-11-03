package com.example.usercenter.address

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.usercenter.R
import com.example.usercenter.shopping.entity.ShopBean
import com.example.usercenter.zhifubao.PayDemoActivity
import kotlinx.android.synthetic.main.activity_address.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        val extras = intent.extras
        val beanlist:ArrayList<AddressBean> = extras?.getSerializable("list") as ArrayList<AddressBean>
        val addressBean = beanlist.get(0)
        val place_img1 = findViewById<ImageView>(R.id.place_img1)
        Glide.with(this).load(addressBean.pic).into(place_img1)
        tv_address_price.setText(""+addressBean.price)
        goods_num.setText("共"+addressBean.num+"件")
        rl_address.setOnClickListener {
            startActivity<SelectActivity>()
        }
        addressback.setOnClickListener {
            finish()
        }

        //价格控件id: tv_address_price
        bt_buy.setOnClickListener {
            startActivity<PayDemoActivity>()
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