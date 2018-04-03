/*
 * Copyright (c) 2018  zhouhaoo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.zhouhaoo.gank.injection.module

import com.zhouhaoo.common.injection.ActivityScope
import com.zhouhaoo.gank.mvp.ui.HomeActivity
import com.zhouhaoo.gank.mvp.ui.NewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by zhou on 18/2/26.
 */
@Module
abstract class CoreMoudle {
    @ActivityScope
    @ContributesAndroidInjector(modules = [HomePresenterModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [HomePresenterModule::class])
    abstract fun contributeTestFragment(): NewFragment
}