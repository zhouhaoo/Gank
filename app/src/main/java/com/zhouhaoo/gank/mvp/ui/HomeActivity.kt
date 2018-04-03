package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import com.zhouhaoo.common.base.BaseMvpActivity
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.mvp.contract.HomeContract
import com.zhouhaoo.gank.mvp.presenter.HomePresenter

/**
 * Created by zhou on 2018/4/2.
 */
class HomeActivity : BaseMvpActivity<HomePresenter>(), HomeContract.View {
    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initView(savedInstanceState: Bundle?) = R.layout.activity_home

    override fun hideLoading() {
    }

    override fun showLoading() {
    }

    override fun showMessage(message: String) {
    }

}