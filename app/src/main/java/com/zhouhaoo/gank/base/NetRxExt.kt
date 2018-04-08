package com.zhouhaoo.gank.base

import com.zhouhaoo.common.mvp.IView
import com.zhouhaoo.gank.BaseData
import com.zhouhaoo.gank.app.NetErrorListenerImpl
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * ## 扩展RxJava的subscribe，有两种模式
 *
 * * 切换请求线程，处理错误信息，进度加载
 * * 切换请求线程，处理错误信息
 *
 *  @param iView view层
 *  @param onNext 处理过后的数据
 *  @param onError 错误处理
 * @param loadingStatus 执行状态 true为带进度加载，false 只处理错误toast ，默认为true
 *
 * ## Created by zhou on 2018/3/28.
 */
fun <T : Any> Observable<BaseData<T>>.execute(
        iView: IView,
        onComplete: () -> Unit = {},
        onError: (Throwable) -> Unit = NetErrorListenerImpl(iView.proContext())::errorMessage,
        loadingStatus: Boolean = true,
        onNext: (T) -> Unit
): Disposable = subscribeOn(Schedulers.io())
        .doOnSubscribe { iView.showLoading() }//显示加载
        .flatMap {
            return@flatMap if (!it.error) {
                createData(it.data)
            } else {
                Observable.error(Exception(it.msg))
            }
        }
        .observeOn(AndroidSchedulers.mainThread())
        .doAfterTerminate(iView::showLoading)//隐藏加载
        .subscribe(onNext, onError, onComplete)

/**
 * 创建成功的数据 Observable
 */
private fun <T> createData(data: T): Observable<T> {
    return Observable.create {
        try {
            it.onNext(data)
            it.onComplete()
        } catch (e: Exception) {
            it.onError(e)
        }
    }
}
