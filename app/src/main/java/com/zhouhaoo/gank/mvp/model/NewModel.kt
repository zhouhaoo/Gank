package com.zhouhaoo.gank.mvp.model

import com.zhouhaoo.common.injection.FragmentScope
import com.zhouhaoo.common.mvp.BaseModel
import com.zhouhaoo.gank.mvp.contract.NewContract
import javax.inject.Inject

/**
 * Created by zhou on 2018/4/2.
 */
@FragmentScope
class NewModel @Inject constructor() : BaseModel(), NewContract.Model {
    override fun getData() {

    }

}