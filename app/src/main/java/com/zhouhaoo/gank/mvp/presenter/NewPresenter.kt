package com.zhouhaoo.gank.mvp.presenter

import android.text.TextUtils
import com.zhouhaoo.common.injection.FragmentScope
import com.zhouhaoo.common.mvp.BasePresenter
import com.zhouhaoo.gank.base.execute
import com.zhouhaoo.gank.bean.NewsMultipleItem
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
                    mView.historyDate(it)
                }
        mModel.getRandomData("福利", 1)
                .execute(mView) {
                    mView.bannerUrl(it[0].url)
                }
    }

    fun getGankData(date: String) {
        var urlDate = date.replace("-", "/")
        mModel.getGankData(urlDate)
                .execute(mView) {
                    //处理成rlv的数据
                    var list = arrayListOf<NewsMultipleItem>()
                    it.forEach { type, data ->
                        if (!TextUtils.equals(type, "福利")) {
                            list.add(NewsMultipleItem(NewsMultipleItem.TEXT_TITLE, type))
                            data.forEach {
                                list.add(NewsMultipleItem(NewsMultipleItem.TEXT_DESC, it))
                            }
                        }
                    }
                    mView.gankData(list)
                }
    }
}
