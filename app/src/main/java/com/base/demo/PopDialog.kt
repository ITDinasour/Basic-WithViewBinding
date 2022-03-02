package com.base.demo

import android.view.View
import com.base.demo.databinding.PopDialogBinding
import com.basic.withoutbinding.BasicUtil
import com.basic.withoutbinding.px
import com.basic.withviewbinding.BasicPopDialog

/**
 *    @date   : 2022/6/30-11:26
 *    @desc   :
 *    @version: 1.0
 */
class PopDialog(mActivity: MainActivity) :
    BasicPopDialog<MainActivity, PopDialogBinding>(mActivity) {
    init {
        mPopWindow.animationStyle = R.style.IOSAnimStyle
        mPopWindow.isFocusable = false
    }

    override fun getLayoutWidth(): Int {
        return BasicUtil.getScreenWidth() * 2 / 3
    }

    override fun getLayoutHeight(): Int {
        return 333f.px.toInt()
    }

    override fun getClickableViews(): Array<out View>? {
        return arrayOf(mViewBinding.tvTitle)
    }

    override fun onClickView(view: View) {
        super.onClickView(view)
        dismiss()
    }
}