package com.basic.withviewbinding

import androidx.lifecycle.LifecycleObserver
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicRvViewHolderWithoutBinding

/**
 *    @author : Jeffrey
 *    @date   : 2021/5/11-20:01
 *    @泛型   : VB-条目BasicRVViewHolder布局的ViewBinding类型，T-条目数据类型
 *    @version: 1.0
 */
open class BasicRvViewHolder<T : Any?, VB : ViewBinding>(val mViewBinding: VB) :
    BasicRvViewHolderWithoutBinding<T>(mViewBinding.root), LifecycleObserver {
    init {
        addOnClickListeners(getClickableViews())
    }
}