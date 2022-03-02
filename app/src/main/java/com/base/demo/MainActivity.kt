package com.base.demo

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.demo.databinding.ActivityMainBinding
import com.basic.withviewbinding.BasicActivity

class MainActivity : BasicActivity<ActivityMainBinding>() {
    private val mAdapter by lazy(LazyThreadSafetyMode.NONE) { RvAdapter() }
    private val mPopDialog by lazy(LazyThreadSafetyMode.NONE) { PopDialog(this) }
    override fun initView() {
        mViewBinding.tvTitle.setTextColor(getBasicColor(android.R.color.holo_blue_light))
        ViewHolder(mViewBinding.layoutViewHolder).initView("挺好用的！")
        mViewBinding.rvList.adapter = mAdapter
        mViewBinding.rvList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun initData() {
        mViewBinding.tvTitle.text = "Bind View By ViewBinding"
        mAdapter.setData(arrayListOf("11111", "22222", "33333"))
    }

    override fun getClickableViews(): Array<out View> {
        return mViewBinding.run { arrayOf(tvTitle, tvShowPopDialog, tvAddItem) }
    }

    override fun onClickView(view: View) {
        super.onClickView(view)
        mViewBinding.apply {
            when (view) {
                tvTitle -> Toast.makeText(this@MainActivity, "clicked tvTitle", Toast.LENGTH_SHORT)
                    .show()
                tvShowPopDialog -> mPopDialog.show()
                tvAddItem -> {
                    val index = mAdapter.itemCount + 1
                    mAdapter.addData("$index" + index + index + index + index)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (mPopDialog.isShowing()) {
            return
        }
        super.onBackPressed()
    }
}