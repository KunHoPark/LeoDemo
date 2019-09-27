package com.kona.leodemo.ui.animation.motionlayout

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityMotionlayoutSample1Binding
import kotlinx.android.synthetic.main.activity_motionlayout_sample1.*


class MotionLayoutSample1Activity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityMotionlayoutSample1Binding

    private var isReturn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMotionlayoutSample1Binding>(this, R.layout.activity_motionlayout_sample1)
        binding.model = this

        btnLeft.setOnClickListener {
            Log.i(tag, "setTransitionListener btnLeft=$isReturn}")
        }

        btnRight.setOnClickListener {
            Log.i(tag, "setTransitionListener btnRight=$isReturn}")
        }

        btnMotionStart.setOnClickListener {
            motionLayout.transitionToEnd()
        }


        layoutTouch.setOnTouchListener { v, event ->
            Log.i(tag, "setTransitionListener setOnClickListener=$isReturn}")
            isReturn = image.top > 0
            return@setOnTouchListener isReturn
        }


        motionLayout.setTransitionListener(object: MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                isReturn = image.top > 0
                Log.i(tag, "setTransitionListener onTransitionCompleted top=${image.top}, isReturny=$isReturn")

            }

        })

    }
}
