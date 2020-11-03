package com.zy.storage

import android.content.Context
import android.content.SharedPreferences

object SPUtils {
    val FILE_NAME = "zydata"


    fun getEditor(context: Context): SharedPreferences.Editor {
        val sp = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        return sp.edit()
    }

    /**
     * 存储数据到SP
     * @param context
     * @param key
     * @param object
     */
    fun put(
        context: Context,
        key: String?,
        value: Any
    ) {
        val editor = getEditor(context)
        if (value is String) {
            editor.putString(key, value)
        } else if (value is Int) {
            editor.putInt(key, value)
        } else if (value is Boolean) {
            editor.putBoolean(key, value)
        } else if (value is Float) {
            editor.putFloat(key, value)
        } else if (value is Long) {
            editor.putLong(key, value)
        } else {
            editor.putString(key, value.toString())
        }
        editor.commit()
    }

    /**
     * 取出数据
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    operator fun get(
        context: Context,
        key: String?,
        defaultValue: Any?
    ): Any? {
        val sp = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        if (defaultValue is String) {
            return sp.getString(key, defaultValue as String?)
        } else if (defaultValue is Int) {
            return sp.getInt(key, (defaultValue as Int?)!!)
        } else if (defaultValue is Boolean) {
            return sp.getBoolean(key, (defaultValue as Boolean?)!!)
        } else if (defaultValue is Float) {
            return sp.getFloat(key, (defaultValue as Float?)!!)
        } else if (defaultValue is Long) {
            return sp.getLong(key, (defaultValue as Long?)!!)
        }
        return null
    }

    /**
     * 删除数据
     * @param context
     * @param key
     */
    fun remove(context: Context, key: String?) {
        val editor = getEditor(context)
        editor.remove(key)
        editor.commit()
    }

    /**
     * 判断释放包含key
     * @param context
     * @param key
     * @return
     */
    fun contains(context: Context, key: String?): Boolean {
        val sp = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        return sp.contains(key)
    }

    /**
     * 清空数据
     * @param context
     */
    fun clear(context: Context) {
        val editor = getEditor(context)
        editor.clear()
        editor.commit()
    }
}