package com.zhouhaoo.gank

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * ## [接口说明](http://gank.io/api)
 *
 * Created by zhou on 2018/4/2.
 */
interface GankApi {
    /**
     * 分类数据
     *
     * http://gank.io/api/data/数据类型/请求个数/第几页
     * * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * * 请求个数： 数字，大于0
     * * 第几页：数字，大于0
     */
    @GET("data/{category}/20/{page}")
    fun gankData(@Path("category") category: String,
                 @Path("page") page: Int): Observable<BaseData<MutableList<Data>>>

    /**
     *## 搜索的数据
     * * category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * * count 最大 50
     */
    @GET("search/query/listview/{category}/Android/count/10/page/{page}")
    fun searchData(@Path(value = "category") category: String,
                   @Path(value = "page") page: Int): Observable<BaseData<MutableList<String>>>

    /**
     *## 获取发过干货日期
     * 接口:http://gank.io/api/day/history
     */
    @GET("data/history")
    fun historyData(): Observable<BaseData<MutableList<String>>>

    /**
     *## 指定日期的数据
     * * calendar ： 格式：2018/01/01
     */
    @GET("data/history/content/day/{calendar}")
    fun calendarData(@Path("calendar") calendar: String): Observable<BaseData<MutableList<String>>>

    /**
     * ## 随机数据
     *
     * http://gank.io/api/random/data/分类/个数
     *
     * * 数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * * 个数： 数字，大于0
     */
    @GET("random/data/{category}/{count}")
    fun randomData(@Path(value = "category") category: String,
                   @Path(value = "count") count: Int): Observable<BaseData<MutableList<Data>>>
}

open class BaseData<T>(var error: Boolean, @SerializedName("results") var data: T)

data class Data(var desc: String, var type: String, var url: String)