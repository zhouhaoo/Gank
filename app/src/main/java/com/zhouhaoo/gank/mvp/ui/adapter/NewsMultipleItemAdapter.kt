package com.zhouhaoo.gank.mvp.ui.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhouhaoo.gank.R
import com.zhouhaoo.gank.bean.NewsMultipleItem

/**
 * ## 最新页面的适配器
 */
class NewsMultipleItemAdapter(data: List<NewsMultipleItem>)
    : BaseMultiItemQuickAdapter<NewsMultipleItem, BaseViewHolder>(data) {

    init {
        addItemType(NewsMultipleItem.TEXT_TITLE, R.layout.item_new_gank_title)
        addItemType(NewsMultipleItem.TEXT_DESC, R.layout.item_new_gank)
    }

    override fun convert(helper: BaseViewHolder, item: NewsMultipleItem) {
        when (helper.itemViewType) {
            NewsMultipleItem.TEXT_TITLE -> {
                helper.setText(R.id.tv_title, item.title)
            }
            NewsMultipleItem.TEXT_DESC -> {
                val data = item.content
                helper.setText(R.id.tv_desc, data.desc)
                        .setText(R.id.tv_who, data.who)
                        .setText(R.id.tv_time, data.time)
            }
        }
    }

}