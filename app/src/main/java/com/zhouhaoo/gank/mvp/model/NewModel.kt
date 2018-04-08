package com.zhouhaoo.gank.mvp.model

import com.zhouhaoo.common.extensions.create
import com.zhouhaoo.common.injection.FragmentScope
import com.zhouhaoo.common.mvp.BaseModel
import com.zhouhaoo.gank.BaseData
import com.zhouhaoo.gank.Data
import com.zhouhaoo.gank.GankApi
import com.zhouhaoo.gank.mvp.contract.NewContract
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by zhou on 2018/4/2.
 */
@FragmentScope
class NewModel @Inject constructor() : BaseModel(), NewContract.Model {

    override fun getRandomData(category: String, count: Int): Observable<BaseData<MutableList<Data>>> {
        return repositoryManager
                .create<GankApi>()
                .randomData(category, count)
    }
}