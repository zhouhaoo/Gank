package com.zhouhaoo.gank.utils

import android.support.v4.view.ViewPager


fun ViewPager.onPageSelected(onPageSelected: (position: Int) -> Unit) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) = onPageSelected(position)
    })
}