package com.zhouhaoo.gank

/**
 * Created by zhou on 2018/4/2.
 */
interface GankApi {
    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * •数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * •请求个数： 数字，大于0
     * •第几页：数字，大于0
     * <p>
     * 例：•http://gank.io/api/data/Android/10/1
     * •http://gank.io/api/data/福利/10/1
     * •http://gank.io/api/data/iOS/20/2
     * •http://gank.io/api/data/all/20/2
     * <p>
     *获取发过干货日期接口:http://gank.io/api/day/history
     * <p>
     * 每日数据： http://gank.io/api/day/年/月/日
     * <p>
     * 例：
     * •http://gank.io/api/day/2015/08/06
     * <p>
     * 随机数据：http://gank.io/api/random/data/分类/个数
     * •数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * •个数： 数字，大于0
     * <p>
     * 例：•http://gank.io/api/random/data/Android/20
     * 搜索 API
     * http://gank.io/api/search/query/listview/category/Android/count/10/page/1
     * 注：
     * category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * count 最大 50
     */

}