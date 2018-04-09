package com.zhouhaoo.gank.mvp.ui

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zhouhaoo.common.base.BaseMvpFragment
import com.zhouhaoo.common.extensions.fromApi
import com.zhouhaoo.common.extensions.start
import com.zhouhaoo.common.extensions.toApi
import com.zhouhaoo.common.glide.GlideApp
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.bean.NewsMultipleItem
import com.zhouhaoo.gank.mvp.contract.NewContract
import com.zhouhaoo.gank.mvp.presenter.NewPresenter
import com.zhouhaoo.gank.mvp.ui.adapter.NewsMultipleItemAdapter
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

    private var adapter = NewsMultipleItemAdapter(emptyList())

    override fun initData(savedInstanceState: Bundle?) {
        fromApi(Build.VERSION_CODES.KITKAT) {

        }
        toApi(Build.VERSION_CODES.KITKAT) {

        }
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
        }
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        mPresenter.getRandomBanner()
        iv_setting.setOnClickListener {
            activity!!.start<SettingActivity>()
        }
        //滑动监听。
//        appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
//
//        }
    }

    override fun bannerUrl(url: String) {
        GlideApp.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(banner_home)
        "banner_url".putString(url)
    }

    override fun historyDate(historyData: MutableList<String>) {
//        collapsing_toolbar.title = historyData[0]
        collapsing_toolbar.title = historyData[0]
        mPresenter.getGankData(historyData[0])
    }

    override fun gankData(list: ArrayList<NewsMultipleItem>) {
        adapter.setNewData(list)
    }

    override fun showLoading() {

    }

    override fun showMessage(message: String) {

    }

    override fun hideLoading() {

    }

}