package com.basic.withviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicRvAdapter

/**
 *    @author : Jeffrey
 *    @date   : 2021/6/15-16:52
 *    @泛型   : B-条目数据类型，VB-条目BasicRVViewHolder布局的ViewBinding类型
 *    @version: 1.0
 */
abstract class SimpleRvAdapter<B : Any?, VB : ViewBinding> :
    BasicRvAdapter<B, BasicRvViewHolder<B, VB>>() {
    override fun getNewCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BasicRvViewHolder<B, VB> {
        return BasicRvViewHolder(
            initViewBinding(this, LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BasicRvViewHolder<B, VB>, position: Int) {
        getDataItem(position)?.run {
            bindViewHolder(holder, this)
        }
    }

    abstract fun bindViewHolder(holder: BasicRvViewHolder<B, VB>, data: B)

}