package com.basic.withviewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.basic.withoutbinding.*
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

/**
 *    @author : Jeffrey
 *    @date   : 2021/9/3-11:49
 *    @desc   :
 *    @version: 1.0
 */

/**
 * 展示 - VISIBLE
 */
fun ViewBinding.show() = root.show()

/**
 * 状态监测 - VISIBLE
 */
val ViewBinding.isVisible: Boolean
    get() = root.isVisible

/**
 * 不展示 - INVISIBLE
 */
fun ViewBinding.notShow() = root.notShow()

/**
 * 状态监测 - INVISIBLE
 */
val ViewBinding.isInvisible: Boolean
    get() = root.isInvisible

/**
 * 隐藏 - GONE
 */
fun ViewBinding.hide() = root.hide()

/**
 * 状态监测 - INVISIBLE
 */
val ViewBinding.isGone: Boolean get() = root.isGone

/**
 * 隐藏或展示
 */
fun ViewBinding.updateShowHide(isShow: Boolean) = if (isShow) show() else hide()

/**
 * 隐藏或展示
 */
fun ViewBinding.updateShowNotShow(isShow: Boolean) = if (isShow) show() else notShow()

fun <VB> initViewBinding(any: Any, view: View): VB {
    var tempJavaClass: Class<in Any>? = any.javaClass
    var viewBinding: VB? = null
    while (tempJavaClass != null) {
        tempJavaClass.genericSuperclass?.let { type ->
            if (type is ParameterizedType) {
                for (actualTypeArgument in type.actualTypeArguments) {
                    try {
                        val viewBindingClazz = actualTypeArgument as Class<VB>
                        val inflate: Method =
                            viewBindingClazz.getDeclaredMethod("bind", View::class.java)
                        viewBinding = inflate.invoke(null, view) as VB
                        tempJavaClass = null
                        break
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        tempJavaClass = tempJavaClass?.superclass
    }
    return viewBinding!!
}

fun <VB> initViewBinding(
    any: Any, layoutInflater: LayoutInflater, parent: ViewGroup? = null, contain: Boolean? = false
): VB {
    var tempJavaClass: Class<in Any>? = any.javaClass
    var viewBinding: VB? = null
    while (tempJavaClass != null) {
        tempJavaClass.genericSuperclass?.let { type ->
            if (type is ParameterizedType) {
                for (actualTypeArgument in type.actualTypeArguments) {
                    try {
                        val viewBindingClazz = actualTypeArgument as Class<VB>
                        val inflate: Method = viewBindingClazz.getDeclaredMethod(
                            "inflate",
                            LayoutInflater::class.java,
                            ViewGroup::class.java,
                            Boolean::class.java
                        )
                        viewBinding =
                            inflate.invoke(null, layoutInflater, parent, contain) as VB
                        tempJavaClass = null
                        break
                    } catch (e: Exception) {
                    }
                }
            }
        }
        tempJavaClass = tempJavaClass?.superclass
    }
    return viewBinding!!
}