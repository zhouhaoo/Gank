package com.zhouhaoo.gank.mvp.ui.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zhouhaoo.common.base.BaseFragment

/**
 * <pre>
 *首页适配器
 * </pre>
 * Created by Zhouhaoo on 2018/4/4.
 */
class HomePageAdapter(private val fragmentList: List<BaseFragment>, fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = fragmentList[position]

    override fun getCount() = fragmentList.size
}