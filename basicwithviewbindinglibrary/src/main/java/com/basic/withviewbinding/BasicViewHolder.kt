package com.basic.withviewbinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicViewHolderWithoutBinding

/**
 *    @author : Jeffrey
 *    @date   : 2021/5/11-19:58
 *    @泛型   : T-初始化init时的数据类型，VB-布局的ViewBinding类型
 *    @version: 1.0
 */
open class BasicViewHolder<T : Any, VB : ViewBinding> : BasicViewHolderWithoutBinding<T>,
    LifecycleObserver {
    val mViewBinding: VB

    constructor(vb: VB) : super(vb.root.context) {
        mViewBinding = vb
    }

    constructor(itemView: View) : super(itemView.context) {
        mViewBinding = initViewBinding(this, itemView)
    }

    constructor(viewGroup: ViewGroup, attachToParent: Boolean) :
            this(viewGroup.context, viewGroup, attachToParent)

    constructor(
        context: Context, viewGroup: ViewGroup? = null, attachToParent: Boolean = false
    ) : super(context) {
        mViewBinding =
            initViewBinding(this, LayoutInflater.from(context), viewGroup, attachToParent)
    }

    override fun getItemView() = mViewBinding.root
}