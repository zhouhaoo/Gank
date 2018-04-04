package com.zhouhaoo.gank.injection.module

import com.zhouhaoo.common.injection.FragmentScope
import com.zhouhaoo.gank.mvp.contract.NewContract
import com.zhouhaoo.gank.mvp.model.NewModel
import com.zhouhaoo.gank.mvp.ui.NewFragment
import dagger.Module
import dagger.Provides

/**
 * Created by zhou on 2018/4/2.
 */
@Module
class NewPresenterModule {
    @FragmentScope
    @Provides
    internal fun provideMainView(newFagment: NewFragment): NewContract.View {
        return newFagment
    }

    @FragmentScope
    @Provides
    internal fun provideMainModel(model: NewModel): NewContract.Model {
        return model
    }
}