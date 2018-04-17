package com.zhouhaoo.gank.app

import android.app.Application
import android.content.Context
import android.support.v4.app.FragmentManager
import com.ihsanbal.logging.Level
import com.zhouhaoo.common.base.delegate.AppLifecycle
import com.zhouhaoo.common.injection.moudle.ConfigModule
import com.zhouhaoo.common.interfaces.AppConfig
import com.zhouhaoo.gank.BuildConfig
import okhttp3.internal.platform.Platform
import java.util.concurrent.TimeUnit

/**
 * Created by zhou on 18/2/8.
 */
class AppConfigImpl : AppConfig {
    override fun applyOptions(context: Context, module: ConfigModule) {
        module.apply {
            baseUrl = "http://gank.io/api/"
            httplogBuilder = {
                loggable(BuildConfig.DEBUG).setLevel(Level.BODY).log(Platform.INFO)
                        .request("Request").response("Response")
            }
            okhttpBuilder = {
                connectTimeout(30_000, TimeUnit.SECONDS)
            }
        }
    }

    override fun injectActivityLifecycle(context: Context, actLifecycles: ArrayList<Application.ActivityLifecycleCallbacks>) {

    }

    override fun injectAppLifecycle(context: Context, appLifecycles: ArrayList<AppLifecycle>) {
        appLifecycles.add(AppLifecycleImpl())
    }

    override fun injectFragmentLifecycle(context: Context, fragLifecycles: ArrayList<FragmentManager.FragmentLifecycleCallbacks>) {

    }

}