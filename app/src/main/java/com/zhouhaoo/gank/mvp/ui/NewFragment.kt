package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhouhaoo.common.base.BaseMvpFragment
import com.zhouhaoo.common.glide.GlideApp
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.mvp.contract.NewContract
import com.zhouhaoo.gank.mvp.presenter.NewPresenter
import com.zhouhaoo.gank.utils.putString
import kotlinx.android.synthetic.main.fragment_new.*

/**
 * ## 最新
 * 顶部 有日期选择 ，搜索 ，设置 三个操作
 * 背景为轮播图
 * 底部默认最新日期的数据
 *
 * Created by zhou on 2018/4/2.
 */
class NewFragment : BaseMvpFragment<NewPresenter>(), NewContract.View {

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_new
    }

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter.getRandomBanner()
    }

    override fun bannerUrl(url: String) {
        GlideApp.with(this).downloadOnly().load(url).into(banner_home)
        "banner_url".putString(url)
    }

    override fun showLoading() {
    }

    override fun showMessage(message: String) {

    }

    override fun hideLoading() {
    }

}