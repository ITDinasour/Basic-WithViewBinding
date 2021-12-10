package com.base.demo

import android.view.View
import android.widget.Toast
import com.base.demo.databinding.ActivityMainBinding
import com.basic.withviewbinding.BasicActivity

class MainActivity : BasicActivity<ActivityMainBinding>() {
    override fun initData() {
        mViewBinding.tvTitle.text = "Bind View By ViewBinding"
    }

    override fun initView() {
        mViewBinding.tvTitle.setTextColor(getBasicColor(android.R.color.holo_blue_light))
    }

    override fun getClickableViews(): Array<out View>? {
        return mViewBinding.run { arrayOf(tvTitle) }
    }

    override fun onClickView(view: View) {
        super.onClickView(view)
        if (view == mViewBinding.tvTitle) {
            Toast.makeText(this, "clicked tvTitle", Toast.LENGTH_SHORT).show()
        }
    }
}