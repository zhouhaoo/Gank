package com.zhouhaoo.gank.mvp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zhouhaoo.common.base.BaseMvpFragment
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.mvp.contract.NewContract
import com.zhouhaoo.gank.mvp.presenter.NewPresenter

/**
 * ## 最新
 *
 * Created by zhou on 2018/4/2.
 */
class NewFragment : BaseMvpFragment<NewPresenter>(), NewContract.View {

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_new
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun showLoading() {
    }

    override fun showMessage(message: String) {

    }

    override fun hideLoading() {
    }


}