package com.base.demo

import android.view.View
import android.widget.Toast
import com.base.demo.databinding.LayoutViewHolderBinding
import com.basic.withviewbinding.BasicViewHolder

/**
 *    @author : Jeffrey
 *    @date   : 2022/1/18-11:57
 *    @desc   :
 *    @version: 1.0
 */
class ViewHolder(vb: LayoutViewHolderBinding) :
    BasicViewHolder<String, LayoutViewHolderBinding>(vb) {
    override fun initView(data: String) {
        super.initView(data)
        mViewBinding.tvTitle.text = data
    }

    override fun getClickableViews(): Array<out View>? {
        return arrayOf(mViewBinding.tvTitle)
    }

    override fun onClickView(view: View) {
        super.onClickView(view)
        Toast.makeText(mContext, javaClass.simpleName + " - clicked", Toast.LENGTH_SHORT).show()
    }
}