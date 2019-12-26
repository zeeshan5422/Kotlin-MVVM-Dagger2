package com.zues.mvvm_dagger2_sample.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.LinearLayout
import java.util.*

/* ---  Created by akhtarz on 12/16/2019. ---*/

class MyTabHost : LinearLayout {
    var tabs: MutableList<MyTab>? = null
    var mSelectedTab: MyTab? = null
    var tabSelectionListener: MyTabSelectionListener? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        orientation = HORIZONTAL
        weightSum = 1f
        gravity = Gravity.CENTER
        tabs = ArrayList<MyTab>()
    }

    fun addTab(id: Int, text: String) {
        val tab = MyTab(context)
        tab.setText(text.toUpperCase())
        tab.tabId = id
        val params =
            LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
        addView(tab, params)
        tab.setOnClickListener(mTabClickListener)
        weightSum = tabs!!.size + 1.toFloat()
        tabs!!.add(tab)
    }

    fun selectTab(id: Int) {
        for (i in tabs!!.indices) {
            val tab: MyTab = tabs!![i]
            if (tab.tabId === id) {
                tab.showStrip(true)
                mSelectedTab = tab
            } else {
                tab.showStrip(false)
            }
        }
    }

    var mTabClickListener =
        OnClickListener { v ->
            val tab: MyTab = v as MyTab
            selectTab(tab.tabId)
            tabSelectionListener!!.onTabSelected(tab.tabId)
        }

    fun getTabWitId(id: Int): MyTab? {
        for (tab in tabs!!) {
            if (tab.tabId === id) {
                return tab
            }
        }
        return null
    }

    fun getTabAtIndex(index: Int): MyTab? {
        return if (index >= tabs!!.size || index < 0) {
            null
        } else tabs!![index]
    }

    interface MyTabSelectionListener {
        fun onTabSelected(tabId: Int)
    }

    var selectedTab: MyTab? = null
        get() = mSelectedTab

}