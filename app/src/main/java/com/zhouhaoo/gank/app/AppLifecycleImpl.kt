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

package com.zhouhaoo.gank.app

import android.app.Application
import android.content.Context
import com.zhouhaoo.common.base.delegate.AppLifecycle
import com.zhouhaoo.gank.BuildConfig
import timber.log.Timber

/**
 * Created by zhou on 18/2/2.
 */
class AppLifecycleImpl : AppLifecycle {
    override fun attachBaseContext(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun onCreate(application: Application) {

    }

    override fun onTerminate(application: Application) {

    }
}