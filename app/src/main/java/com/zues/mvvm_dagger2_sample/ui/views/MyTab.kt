package com.zues.mvvm_dagger2_sample.ui.views

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.zues.mvvm_dagger2_sample.R

/**
 * Created by KhawarRaza on 11/29/17.
 */
class MyTab : RelativeLayout {
    var title: TextView? = null
    var strip: View? = null
    var tabId = 0

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

    fun init() {
        val view =
            LayoutInflater.from(context).inflate(R.layout.my_tab_item, null)
        val params = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        addView(view, params)
        title = view.findViewById<View>(R.id.tab_title) as TextView
        strip = view.findViewById(R.id.tab_strip)
    }

    fun setText(text: String?) {
        title!!.text = text
    }

    fun showStrip(show: Boolean) {
        if (show) {
            strip!!.visibility = View.VISIBLE
            title!!.setTypeface(null, Typeface.BOLD)
        } else {
            strip!!.visibility = View.INVISIBLE
            title!!.setTypeface(null, Typeface.NORMAL)
        }
    }

    companion object {
        private const val COLOR_TRANSPARENT = Color.TRANSPARENT
        private val COLOR_SEMI_TRANSPARENT = Color.argb(15, 0, 0, 0)
    }
}