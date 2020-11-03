package com.example.usercenter.shopping.view

import android.content.Intent
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.view.BaseFragment
import com.example.usercenter.R
import com.example.usercenter.address.AddressActivity
import com.example.usercenter.address.AddressBean
import com.example.usercenter.shopping.adapter.MyShopAdapter
import com.example.usercenter.shopping.contract.ShoppingContract
import com.example.usercenter.shopping.entity.GetCarBean
import com.example.usercenter.shopping.entity.ShopBean
import com.example.usercenter.shopping.model.ShoppingModel
import com.example.usercenter.shopping.presenter.ShoppingPresenter
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.fragment_shopping.*
import org.jetbrains.anko.startActivity

class ShoppingFragment : BaseFragment<ShoppingPresenter>(),ShoppingContract.View {

    lateinit var myShopAdapter: MyShopAdapter
    var list:MutableList<ShopBean> = mutableListOf()
    var rv_shop:RecyclerView?=null
    lateinit var tv_shop_jin_e:TextView
    lateinit var rbtn_shop:CheckBox
    override fun initEvent() {
//加减选中的钱数
        myShopAdapter.setOnItemChildClickListener { adapter, view, position ->
            var shopbean = list.get(position)
            var num = shopbean.num
            var price = shopbean.price
            //多选商品
            if (view.id==R.id.cb_shop_item){
                var cb:CheckBox?=null
                cb = view as CheckBox?
                var checked = cb!!.isChecked
                shopbean.boolean=checked
                //如果选中，改变价格
                var price_num=tv_shop_jin_e.text.toString().toFloat()
                if (checked){
                    price_num = price_num+(num*price)
                    tv_shop_jin_e.setText(""+price_num)
                }else{
                    price_num = price_num-(num*price)
                    tv_shop_jin_e.setText(""+price_num)
                }

            }
            //判断是否全部选中
            var index:Int =0
            for (i in list){
                val boolean = i.boolean
                if (boolean){
                }else{
                    index++
                }
            }
            if (index!=0){
                rbtn_shop.isChecked=false
            }else{
                rbtn_shop.isChecked=true
            }
            //点击加号，数据增加
            if (view.id==R.id.tv_shop_add){
                shopbean.num=num+1
                //如果选中，改变价格
                var boolean = shopbean.boolean
                if (boolean){
                    var price_num=tv_shop_jin_e.text.toString().toFloat()
                    price_num =price_num+price
                    tv_shop_jin_e.setText(""+price_num)
                }

            }
            //点击减号，数据减少，当数据等于0时，将该数据删除
            if (view.id==R.id.tv_shop_del){
                var boolean = shopbean.boolean
                //如果选中，改变价格
                if (boolean){
                    var price_num=tv_shop_jin_e.text.toString().toFloat()
                    if (num>1){
                        price_num = price_num-(price)
                    }
                    tv_shop_jin_e.setText(""+price_num)
                }
                if (num>1){//判断条件如果是 >=1 那么当数据等于0的时候就会自动删除该数据
                    //数据减少
                    num=num-1
                }
                shopbean.num=num
                if (num==0){
                    //当数据等于0时，将该数据删除
                    list.remove(shopbean)
                }


            }
            myShopAdapter.notifyDataSetChanged()
        }
        rbtn_shop.setOnClickListener {
            xuangzhong()
        }
        btn_shop_jiesuan.setOnClickListener {
            //点击购买
            var addressList:ArrayList<AddressBean> = arrayListOf()
            for (i in 0..list.size-1){
                val sbean = list.get(i)
                if (sbean.boolean){
                    addressList.add(AddressBean(sbean.pic,""+sbean.num,""+sbean.price))
                }
            }
            val intent = Intent(activity, AddressActivity::class.java)
            intent.putExtra("list",addressList)
            if (addressList.size==0){
                Toast.makeText(activity, "请选择你要付款的商品", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(intent)
                if (rbtn_shop.isChecked){
                    rbtn_shop.isChecked=false
                }
            }
            xuangzhong()

        }
        //点击删除购物车上的物品
        shop_del.setOnClickListener {
            var size:Int=list.size-1
            for (i in 0..size){
                val getbean = list.get(i)
                if (getbean.boolean){

                }
            }
        }
    }

    private fun xuangzhong() {
        if (rbtn_shop.isChecked){
            val data = myShopAdapter.data
            var money:Float=0.00f
            for (i in data){
                i.boolean=true
                val num = i.num
                val price = i.price
                money+=(num*price)
            }
            tv_shop_jin_e.setText(""+money)
            myShopAdapter.notifyDataSetChanged()
        }else{
            val data = myShopAdapter.data
            for (i in data){
                i.boolean=false
            }
            tv_shop_jin_e.setText("0.00")
            myShopAdapter.notifyDataSetChanged()
        }
    }

    override fun initData() {
        //创建适配器，并且添加
        myShopAdapter = MyShopAdapter(R.layout.shopp_item, list)
        rv_shop!!.adapter = myShopAdapter
        rv_shop!!.layoutManager = LinearLayoutManager(context)
        mPresenter.getShoppingCarDara(1010)
    }

    override fun initView() {
        mPresenter = ShoppingPresenter(ShoppingModel(),this)
        rv_shop = mView.findViewById<RecyclerView>(R.id.rv_shop)
        tv_shop_jin_e = mView.findViewById<TextView>(R.id.tv_shop_jin_e)
        rbtn_shop = mView.findViewById<CheckBox>(R.id.rbtn_shop)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_shopping
    }

    override fun onFailed(throwable: Throwable) {

    }

    override fun getcarData(getCarBean: GetCarBean) {
        val data = getCarBean.data
        list.clear()
        for (i in 0..data.size-1){
            var num:Int = 1
            var carbean = data.get(i)
            var goodsdetail = carbean.goodsdetail
            var splist = goodsdetail.split("@@")
            var goodtitle:String = splist[0]
            var goodprice:Float = splist[1].toFloat()
            var goodpic:String = splist[2]
            var goodscode:String = carbean.goodscode
            for (j in 0..list.size-1){
                val sb = list.get(j)
                if (sb.goodscode==goodscode){
                    num = sb.num
                    num=num+1
                    sb.num = num
                }
            }
            if (num==1){
                list.add(ShopBean(goodscode,goodpic,goodtitle,goodprice,num,false))
            }
        }
        //刷新适配器
        myShopAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.getShoppingCarDara(1010)
        myShopAdapter.notifyDataSetChanged()
    }

}