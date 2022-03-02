package com.basic.withviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicFragmentWithoutBinding

/**
 *    @author : Jeffrey
 *    @date   : 2021/12/31-10:27
 *    @desc   :
 *    @version: 1.0
 */
abstract class BasicFragment<A : AppCompatActivity, VB : ViewBinding> :
    BasicFragmentWithoutBinding<A>(){

    protected open var mViewBinding: VB? = null

    override fun initRootView(inflater: LayoutInflater, container: ViewGroup?) =
        initViewBinding<VB>(this, inflater, container, false).run {
            mViewBinding = this
            addOnClickListeners(getClickableViews())
            root
        }

}