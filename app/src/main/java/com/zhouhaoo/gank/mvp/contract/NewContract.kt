package com.zhouhaoo.gank.mvp.contract

import com.zhouhaoo.common.mvp.IModel
import com.zhouhaoo.common.mvp.IView
import com.zhouhaoo.gank.BaseData
import com.zhouhaoo.gank.Data
import io.reactivex.Observable

/**
 * Created by zhou on 2018/4/2.
 */
interface NewContract {

    interface View : IView {
        fun bannerUrl(url: String)
    }

    interface Model : IModel {
        fun getRandomData(category: String, count: Int): Observable<BaseData<MutableList<Data>>>
    }
}