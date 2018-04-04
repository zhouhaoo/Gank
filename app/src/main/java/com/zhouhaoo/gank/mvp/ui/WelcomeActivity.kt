package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import com.zhouhaoo.common.base.BaseActivity
import com.zhouhaoo.common.extensions.runDelayed
import com.zhouhaoo.common.extensions.start
import com.zhouhaoo.gank.R

/**
 * ## 启动页,可以啊
 *
 * Created by Zhouhaoo on 2018/4/4.
 */
class WelcomeActivity : BaseActivity() {

    override fun useInject() = false
    override fun initView(savedInstanceState: Bundle?): Int {

        return R.layout.activity_welcome
    }

    override fun initData(savedInstanceState: Bundle?) {
        runDelayed(1500) {
            start<HomeActivity>(finishSelf = true)
        }
    }


    override fun hideLoading() {
    }


    override fun showLoading() {

    }

    override fun showMessage(message: String) {
    }

}
