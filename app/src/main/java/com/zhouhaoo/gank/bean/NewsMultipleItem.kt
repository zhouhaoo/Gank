package com.zhouhaoo.gank.bean

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.zhouhaoo.gank.Data

/**
 * 多类型布局
 */
class NewsMultipleItem : MultiItemEntity {
    private var itemType: Int = 0

    lateinit var content: Data
    lateinit var title: String

    companion object {
        val TEXT_TITLE = 1
        val TEXT_DESC = 2
    }

    constructor(itemType: Int, content: Data) {
        this.itemType = itemType
        this.content = content
    }

    constructor(itemType: Int, title: String) {
        this.itemType = itemType
        this.title = title
    }

    override fun getItemType(): Int {
        return itemType
    }

}