package com.zhouhaoo.gank.mvp.presenter

import com.zhouhaoo.common.injection.ActivityScope
import com.zhouhaoo.common.mvp.BasePresenter
import com.zhouhaoo.gank.mvp.contract.HomeContract
import javax.inject.Inject

/**
 * Created by zhou on 2018/4/2.
 */
@ActivityScope
class HomePresenter @Inject constructor(model: HomeContract.Model, view: HomeContract.View)
    : BasePresenter<HomeContract.Model, HomeContract.View>(model, view) {

}