package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import android.text.TextUtils
import com.zhouhaoo.common.base.BaseActivity
import com.zhouhaoo.common.extensions.load
import com.zhouhaoo.common.extensions.runDelayed
import com.zhouhaoo.common.extensions.start
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.utils.getString
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * ## 启动页
 *
 * Created by Zhouhaoo on 2018/4/4.
 */
class WelcomeActivity : BaseActivity() {

    override fun useInject() = false
    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_welcome
    }

    override fun initData(savedInstanceState: Bundle?) {
        val url = "banner_url".getString()
        if (!TextUtils.isEmpty(url)) {
            imageView.load(url)
        }
        runDelayed(2500) {
            start<HomeActivity>()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }

    override fun hideLoading() {
    }


    override fun showLoading() {

    }

    override fun showMessage(message: String) {
    }

}
