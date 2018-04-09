package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import android.view.MenuItem
import com.zhouhaoo.common.base.BaseMvpActivity
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.mvp.contract.HomeContract
import com.zhouhaoo.gank.mvp.presenter.HomePresenter
import com.zhouhaoo.gank.mvp.ui.adapter.HomePageAdapter
import com.zhouhaoo.gank.utils.onPageSelected
import kotlinx.android.synthetic.main.activity_home.*

/**
 * ## 首页
 *
 * Created by zhou on 2018/4/2.
 */
class HomeActivity : BaseMvpActivity<HomePresenter>(), HomeContract.View {
    /**
     * 菜单
     */
    private lateinit var menuItem: MenuItem

    override fun initView(savedInstanceState: Bundle?) = R.layout.activity_home

    override fun initData(savedInstanceState: Bundle?) {
        val fragmentList = arrayListOf(NewFragment(), CategoryFragment(), MineFragment())
        viewPager.adapter = HomePageAdapter(fragmentList, fragmentManager = supportFragmentManager)
        viewPager.offscreenPageLimit = 2
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    viewPager.currentItem = 0
                }
                R.id.navigation_category -> {
                    viewPager.currentItem = 1
                }
                R.id.navigation_mine -> {
                    viewPager.currentItem = 2
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        viewPager.onPageSelected {
            if (::menuItem.isInitialized) {
                menuItem.isChecked = false
            } else {
                bottomNavigationView.menu.getItem(0).isChecked = false
            }
            menuItem = bottomNavigationView.menu.getItem(it)
            menuItem.isChecked = true
        }
    }

    override fun hideLoading() {
    }

    override fun showLoading() {
    }

    override fun showMessage(message: String) {
    }

}
