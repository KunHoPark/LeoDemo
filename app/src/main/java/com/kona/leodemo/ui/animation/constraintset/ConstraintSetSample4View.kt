package com.kona.leodemo.ui.animation.constraintset

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ViewConstraintsetSample4Binding



/**
 * parkkh on 2019-07-30
 *
 */
class ConstraintSetSample4View {

    var binding: ViewConstraintsetSample4Binding

    var working: ObservableField<String> = ObservableField()

    constructor(context: Context, container: ViewGroup) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //방법1
//        binding = ViewConstraintsetSample4Binding.inflate(inflater)
//        container.addView(binding.root)

        //방법2
        binding = DataBindingUtil.inflate(inflater, R.layout.view_constraintset_sample4, container, true)

        binding.model = this

        init()
    }

    private fun init() {
        working.set("할일 목록을 입력하세요")
    }

    fun onClickListener(view: View) {
        working.set("작성 완료 했나요?")
    }

}