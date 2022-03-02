package com.basic.withviewbinding

import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicActivityWithoutBinding

/**
 *    @author : Jeffrey
 *    @date   : 2021/5/13-19:31
 *    @desc   : 基础类
 *    @泛型   : VB-布局的ViewBinding类型
 *    @version: 1.0
 */
abstract class BasicActivity<VB : ViewBinding> : BasicActivityWithoutBinding() {

    protected open val mViewBinding by lazy(LazyThreadSafetyMode.NONE) { initViewBinding() }

    override fun initContentView() {
        setContentView(mViewBinding.root)
        addOnClickListeners(getClickableViews())
    }

    protected open fun initViewBinding() = initViewBinding<VB>(this, layoutInflater)
}