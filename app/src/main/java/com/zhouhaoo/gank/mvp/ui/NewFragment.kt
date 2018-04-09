package com.zhouhaoo.gank.mvp.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zhouhaoo.common.base.BaseMvpFragment
import com.zhouhaoo.common.extensions.start
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
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        mPresenter.getRandomBanner()
        iv_setting.setOnClickListener {
            activity!!.start<SettingActivity>()
        }
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
//            (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        }
        collapsing_toolbar.title = "hahahahahah"
        collapsing_toolbar.setExpandedTitleColor(Color.WHITE)//设置还没收缩时状态下字体颜色
        collapsing_toolbar.setCollapsedTitleTextColor(Color.BLACK)//
    }

    override fun bannerUrl(url: String) {
        GlideApp.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(banner_home)
        "banner_url".putString(url)
    }

    override fun historyDate(historyData: MutableList<String>) {
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