package com.base.demo

import com.base.demo.databinding.LayoutViewHolderBinding
import com.basic.withviewbinding.BasicRvViewHolder
import com.basic.withviewbinding.SimpleRvAdapter

/**
 *    @date   : 2022/6/30-11:21
 *    @desc   :
 *    @version: 1.0
 */
class RvAdapter : SimpleRvAdapter<String, LayoutViewHolderBinding>() {
    override fun bindViewHolder(
        holder: BasicRvViewHolder<String, LayoutViewHolderBinding>, data: String
    ) {
        holder.mViewBinding.tvTitle.text = data
    }
}