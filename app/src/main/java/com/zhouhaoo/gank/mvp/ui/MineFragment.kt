package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhouhaoo.common.base.BaseFragment
import com.zhouhaoo.gank.R

/**
 * ## 收藏
 *
 * Created by zhou on 2018/4/2.
 */
class MineFragment : BaseFragment() {
    override fun useInject() = false
    override fun hideLoading() {
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_mine
    }

    override fun showLoading() {
    }

    override fun showMessage(message: String) {
    }
}