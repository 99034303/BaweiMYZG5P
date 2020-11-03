package com.zy.storage

interface Callback {
     fun <T> onSuccess(t:T):Unit
     fun onFailed(throwable: Throwable):Unit
}