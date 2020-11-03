package com.example.usercenter.callback

interface MyCallback <T>{
    fun onSuccess(result:T)
    fun onFailed(throwable:Throwable)
}