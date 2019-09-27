package com.kona.leodemo.ui.animation.constraintset

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.transition.TransitionManager
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityConstraintsetSample1Binding
import kotlinx.android.synthetic.main.activity_constraintset_sample1.*


class ConstraintSetSample1Activity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityConstraintsetSample1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityConstraintsetSample1Binding>(this, R.layout.activity_constraintset_sample1)
        binding.model = this

        var changed = false

        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(constraintLayout)

        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_constraintset_sample1_1)

        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(constraintLayout)

            val constraint = when(changed) {
                true -> {
                    constraintSet1
                }
                else -> {
                    constraintSet2
                }
            }

            constraint.applyTo(constraintLayout)
            changed = !changed

            textView.text = changed.toString()
        }
    }




}
