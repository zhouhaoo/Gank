package com.zhouhaoo.gank.mvp.contract

import com.zhouhaoo.common.mvp.IModel
import com.zhouhaoo.common.mvp.IView
import com.zhouhaoo.gank.BaseData
import com.zhouhaoo.gank.Data
import com.zhouhaoo.gank.bean.NewsMultipleItem
import io.reactivex.Observable

/**
 * Created by zhou on 2018/4/2.
 */
interface NewContract {

    interface View : IView {
        /**
         * 随机banner图
         */
        fun bannerUrl(url: String)

        /**
         * 发过干货的历史日期
         */
        fun historyDate(historyData: MutableList<String>)

        /**
         *指定日期的干货数据
         */
        fun gankData(list: ArrayList<NewsMultipleItem>)
    }

    interface Model : IModel {
        fun getRandomData(category: String, count: Int): Observable<BaseData<MutableList<Data>>>
        fun getDate(): Observable<BaseData<MutableList<String>>>
        fun getGankData(urlDate: String): Observable<BaseData<MutableMap<String, List<Data>>>>
    }
}