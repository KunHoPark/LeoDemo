package com.kona.leodemo.ui.animation.constraintset

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityConstraintsetSample3Binding
import kotlinx.android.synthetic.main.activity_constraintset_sample3.*


class ConstraintSetSample3Activity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityConstraintsetSample3Binding

    private val applyConstraintSet = ConstraintSet()
    private val resetConstraintSet = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityConstraintsetSample3Binding>(this, R.layout.activity_constraintset_sample3)
        binding.model = this

        applyConstraintSet.clone(container)
        resetConstraintSet.clone(container)

        clickBtn.setOnClickListener { view ->
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
    }

    private fun onApplyClick() {
        applyConstraintSet.setMargin(R.id.clickBtn, ConstraintSet.END, 8)
        applyConstraintSet.applyTo(container)
    }

    private fun onResetClick() {
        resetConstraintSet.applyTo(container)
    }






}
