package com.example.usercenter.main_and_cotegory.fragment.sousuoview

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import com.example.usercenter.R
import com.example.usercenter.main_and_cotegory.fragment.adapter.Suosuo_Adapter
import com.example.usercenter.main_and_cotegory.fragment.sql.MySql
import com.library.flowlayout.FlowLayoutManager
import kotlinx.android.synthetic.main.activity_sousuo.*
import org.jetbrains.anko.startActivity

class SousuoActivity : AppCompatActivity() {
    var list:MutableList<String> = mutableListOf()
    var index:Int=0
    lateinit var mySql: MySql
    lateinit var suosuoAdapter: Suosuo_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sousuo)
        mySql = MySql(this,"user",null,1)
        val db = mySql.writableDatabase
//        val query = db.query("sousuo", null, null, null, null, null, null, null)
//        if (query!=null){
//            query.moveToNext()
//            val columnName = query.getColumnName(query.getColumnIndex("name"))
//            val idindex = query.getColumnIndex("id")
//            index=idindex+1
//            Log.d("--aa-------","=>"+index+"==="+columnName)
//        }
        suosuoAdapter = Suosuo_Adapter(R.layout.suosuo_item,list)
        //点击取消，关闭搜索页面
        tv_fin.setOnClickListener {
            finish()
        }
        //点击搜索按钮进行数据查询，并且显示搜索到数据的页面
        iv_suosuo.setOnClickListener {
            val toString = et_sousuo.text.toString()
            val contentValues = ContentValues()
            contentValues.put("id",index)
            if (toString.isNotEmpty()){
                contentValues.put("name",toString)
                db.insert("sousuo",null,contentValues)
                suosuoAdapter.notifyDataSetChanged()
                startActivity<GoodsActivity>("goods" to ""+toString)
            }else{
                contentValues.put("name","血滴子")
                db.insert("sousuo",null,contentValues)
                suosuoAdapter.notifyDataSetChanged()
                startActivity<GoodsActivity>("goods" to "血滴子")
            }

            //关闭搜索页面，方便查看完数据返回，符合显示逻辑
            finish()
        }
        //点击删除所有搜索记录
        iv_del.setOnClickListener {

        }
        rv_jilu.adapter = suosuoAdapter
        rv_jilu.layoutManager = FlowLayoutManager()


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