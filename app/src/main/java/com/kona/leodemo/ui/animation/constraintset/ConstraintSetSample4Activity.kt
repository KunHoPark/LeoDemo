package com.kona.leodemo.ui.animation.constraintset

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityConstraintsetSample4Binding
import kotlinx.android.synthetic.main.activity_constraintset_sample4.*


class ConstraintSetSample4Activity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityConstraintsetSample4Binding

    private val applyConstraintSet = ConstraintSet()
    private val resetConstraintSet = ConstraintSet()
    private var constraintSetSample4View: ConstraintSetSample4View?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityConstraintsetSample4Binding>(this, R.layout.activity_constraintset_sample4)
        binding.model = this

        applyConstraintSet.clone(container)
        resetConstraintSet.clone(container)

        btnOpen.setOnClickListener { view ->
            view.tag = when(view.tag.toString().toLowerCase()) {
                "reset" -> {
                    onApplyClick()
                    "apply"
                }
                else -> {
                    onResetClick()
                    "reset"
                }
            }
            val trans = ChangeBounds()
            trans.interpolator = AccelerateInterpolator()
            android.transition.TransitionManager.beginDelayedTransition(container, trans)
        }

        init()
    }

    private fun init() {
        if (constraintSetSample4View == null) {
            constraintSetSample4View = ConstraintSetSample4View(this, customFragment)
        }
    }

    private fun onApplyClick() {
        applyConstraintSet.clear(customFragment.id)
        applyConstraintSet.connect(customFragment.id, ConstraintSet.TOP, guideFragment.id, ConstraintSet.TOP,0)
        applyConstraintSet.connect(customFragment.id, ConstraintSet.BOTTOM, layoutCustomBottom.id, ConstraintSet.TOP,0)
        applyConstraintSet.connect(customFragment.id, ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START,0)
        applyConstraintSet.connect(customFragment.id, ConstraintSet.END, ConstraintSet.PARENT_ID,ConstraintSet.END,0)

        applyConstraintSet.setGuidelineBegin(R.id.guideFragment, 10)
        applyConstraintSet.applyTo(container)
    }

    private fun onResetClick() {
        resetConstraintSet.applyTo(container)
    }






}
