package com.example.usercenter.main_and_cotegory.fragment.entity

data class Bean(
    val code: Int,
    val `data`: Data,
    val msg: String
)

data class Data(
    val birthday: String,
    val id: Int,
    val pwd: Any,
    val sex: String,
    val username: String
)