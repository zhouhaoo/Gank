package com.zhouhaoo.gank.mvp.presenter

import com.zhouhaoo.common.injection.FragmentScope
import com.zhouhaoo.common.mvp.BasePresenter
import com.zhouhaoo.gank.base.execute
import com.zhouhaoo.gank.mvp.contract.NewContract
import javax.inject.Inject

/**
 * Created by zhou on 2018/4/2.
 */
@FragmentScope
class NewPresenter @Inject constructor(model: NewContract.Model, view: NewContract.View)
    : BasePresenter<NewContract.Model, NewContract.View>(model, view) {
    /**
     * 获取随机的banner图
     */
    fun getRandomBanner() {
        mModel.getDate()
                .execute(mView) {
                    mView.historyData(it)
//                    mModel.getGankData(it[0])
                }
        mModel.getRandomData("福利", 1)
                .execute(mView) {
                    mView.bannerUrl(it[0].url)
                }
    }
}