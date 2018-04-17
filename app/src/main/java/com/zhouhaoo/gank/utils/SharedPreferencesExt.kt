package com.zhouhaoo.gank.utils

import android.content.Context
import android.content.SharedPreferences

object SPUtils {
    lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context, preferencesName: String = context.packageName) {
        sharedPreferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    }
}

fun String.putString(value: String) {
    SPUtils.sharedPreferences.edit().putString(this, value).apply()
}

fun String.getString(defaultValue: String = ""): String {
    return SPUtils.sharedPreferences.getString(this, defaultValue)
}