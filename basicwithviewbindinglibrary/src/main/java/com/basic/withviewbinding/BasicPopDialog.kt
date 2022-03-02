package com.basic.withviewbinding

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicPopDialogWithoutBinding

/**
 *    @author : Jeffrey
 *    @date   : 2021/5/12-19:42
 *    @泛型   : T-用于链式结构返回类型，填写当前PopDialog，VB-PopWindow布局的ViewBinding类型
 *    @version: 1.0
 */
open class BasicPopDialog<A : Activity, VB : ViewBinding>(mActivity: A) :
    BasicPopDialogWithoutBinding<A>(mActivity) {
    protected open lateinit var mViewBinding: VB
    override fun initContentView(): View {
        mViewBinding = initViewBinding(this, LayoutInflater.from(mActivity))
        addOnClickListeners(getClickableViews())
        return mViewBinding.root
    }
}