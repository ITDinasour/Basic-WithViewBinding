package com.basic.withviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.BasicFragmentWithoutBinding

/**
 *    @author : Jeffrey
 *    @date   : 2021/5/13-19:15
 *    @泛型   : A-Fragment加入的Activity,VB-Fragment布局的ViewBinding类型
 *    @version: 1.0
 */
abstract class BasicFragment<A : AppCompatActivity, VB : ViewBinding> :
    BasicFragmentWithoutBinding<A>() {

    protected var mViewBinding: VB? = null

    override fun initRootView(inflater: LayoutInflater, container: ViewGroup?) =
        initViewBinding<VB>(this, inflater, container, false).run {
            mViewBinding = this
            addOnClickListeners(getClickableViews())
            root
        }
}