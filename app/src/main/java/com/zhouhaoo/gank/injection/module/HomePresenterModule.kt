package com.zhouhaoo.gank.injection.module

import com.tbruyelle.rxpermissions2.RxPermissions
import com.zhouhaoo.common.injection.ActivityScope
import com.zhouhaoo.gank.mvp.contract.HomeContract
import com.zhouhaoo.gank.mvp.model.HomeModel
import com.zhouhaoo.gank.mvp.ui.HomeActivity
import dagger.Module
import dagger.Provides

/**
 * Created by zhou on 2018/4/2.
 */
@Module
class HomePresenterModule {
    @ActivityScope
    @Provides
    internal fun provideMainView(homeActivity: HomeActivity): HomeContract.View {
        return homeActivity
    }

    @ActivityScope
    @Provides
    internal fun provideMainModel(model: HomeModel): HomeContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideRxPermissions(homeActivity: HomeActivity): RxPermissions {
        return RxPermissions(homeActivity)
    }
}