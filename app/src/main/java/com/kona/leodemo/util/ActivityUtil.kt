package com.kona.leodemo.util

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.kona.leodemo.ui.MainActivity
import com.kona.leodemo.ui.animation.AnimationMainActivity
import com.kona.leodemo.ui.animation.constraintset.ConstraintSetSample1Activity
import com.kona.leodemo.ui.animation.constraintset.ConstraintSetSample2Activity
import com.kona.leodemo.ui.animation.constraintset.ConstraintSetSample3Activity
import com.kona.leodemo.ui.animation.constraintset.ConstraintSetSample4Activity
import com.kona.leodemo.ui.animation.motionlayout.MotionLayoutSample1Activity
import com.kona.leodemo.ui.componet.SpinnerUiComponetActivity
import com.kona.leodemo.ui.componet.UiComponetActivity
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
    fun startInverseDataBindingActivity(context: Context) {
        Intent(context, InverseDataBindingActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startUiComponetActivity(context: Context) {
        Intent(context, UiComponetActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startSpinnerUiComponetActivity(context: Context) {
        Intent(context, SpinnerUiComponetActivity::class.java).apply {
            context.startActivity(this)
        }
    }


    //Animation
    fun startAnimationMainActivity(context: Context) {
        Intent(context, AnimationMainActivity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startConstraintSetSample1Activity(context: Context) {
        Intent(context, ConstraintSetSample1Activity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startConstraintSetSample2Activity(context: Context) {
        Intent(context, ConstraintSetSample2Activity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startConstraintSetSample3Activity(context: Context) {
        Intent(context, ConstraintSetSample3Activity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startConstraintSetSample4Activity(context: Context) {
        Intent(context, ConstraintSetSample4Activity::class.java).apply {
            context.startActivity(this)
        }
    }
    fun startMotionLayoutSample1Activity(context: Context) {
        Intent(context, MotionLayoutSample1Activity::class.java).apply {
            context.startActivity(this)
        }
    }

    fun startSimpleDataBinding(activity: FragmentActivity, id: Int) {
        activity.supportFragmentManager.apply {
            beginTransaction().replace(id, SimpleDataBinding()).commit()
        }
    }

}