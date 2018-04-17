package com.zhouhaoo.gank.mvp.model

import com.zhouhaoo.common.injection.ActivityScope
import com.zhouhaoo.common.mvp.BaseModel
import com.zhouhaoo.gank.mvp.contract.HomeContract
import javax.inject.Inject

/**
 * Created by zhou on 2018/4/2.
 */
@ActivityScope
class HomeModel @Inject constructor() : BaseModel(), HomeContract.Model {

}