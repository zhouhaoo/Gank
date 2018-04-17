package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import com.zhouhaoo.common.base.BaseActivity
import com.zhouhaoo.gank.R

/**
 * ## 设置
 */
class SettingActivity : BaseActivity() {

    override fun useInject() = false

    override fun hideLoading() {
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initView(savedInstanceState: Bundle?) = R.layout.activity_setting

    override fun showLoading() {

    }

    override fun showMessage(message: String) {

    }
}