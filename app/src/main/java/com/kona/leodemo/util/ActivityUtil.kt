package com.kona.leodemo.util

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.kona.leodemo.ui.MainActivity
import com.kona.leodemo.ui.coroutine.CoroutineActivity
import com.kona.leodemo.ui.databinding.*

object ActivityUtil {

    /**
     *  Main
     */
    fun startMainActivity(context: Context) {
        Intent(context, MainActivity::class.java).run {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(this)
        }
    }

    fun startCoroutineActivity(context: Context) {
        Intent(context, CoroutineActivity::class.java).apply {
            context.startActivity(this)
        }
    }

    fun startDataBindingActivity(context: Context) {
        Intent(context, DataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startSimpleDataBindingActivity(context: Context) {
        Intent(context, SimpleDataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startAdapterDataBindingActivity(context: Context) {
        Intent(context, AdapterDataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startObservableDataBindingActivity(context: Context) {
        Intent(context, ObservableDataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startListenerDataBindingActivity(context: Context) {
        Intent(context, ListenerDataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startTwowayDataBindingActivity(context: Context) {
        Intent(context, TwowayDataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }

    fun startSimpleDataBinding(activity: FragmentActivity, id: Int) {
        activity.supportFragmentManager.apply {
            beginTransaction().replace(id, SimpleDataBinding()).commit()
        }
    }

}