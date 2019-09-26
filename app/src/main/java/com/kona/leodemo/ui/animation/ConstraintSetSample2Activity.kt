package com.kona.leodemo.ui.animation

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.animation.AccelerateInterpolator
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityConstraintsetSample2Binding
import kotlinx.android.synthetic.main.activity_constraintset_sample2.*


class ConstraintSetSample2Activity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityConstraintsetSample2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isopen = true

        binding = DataBindingUtil.setContentView<ActivityConstraintsetSample2Binding>(this, R.layout.activity_constraintset_sample2)
        binding.model = this

        btn_add.setOnClickListener {
            if (isopen) {
                updateView(R.layout.activity_constraintset_sample2_1)
                btn_add.text = "+"
                tv_contents.text = "2019-04-26 15:57 합정동에서 작성"

            } else {
                updateView(R.layout.activity_constraintset_sample2)
                btn_add.text = "+ 할일 추가"
                tv_contents.text = "할일 목록을 입력하세요"
            }
            isopen = !isopen
        }
    }

    private fun updateView(@LayoutRes id: Int) {
        var targetConstSet = ConstraintSet()
        targetConstSet.clone(this, id)
        targetConstSet.applyTo(root)

        val trans = ChangeBounds()
        trans.interpolator = AccelerateInterpolator()
        android.transition.TransitionManager.beginDelayedTransition(root, trans)
    }




}
