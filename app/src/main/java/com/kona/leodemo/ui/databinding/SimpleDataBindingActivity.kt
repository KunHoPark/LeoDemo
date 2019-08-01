package com.kona.leodemo.ui.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivitySimpleBindingBinding
import com.kona.leodemo.ui.databinding.model.SampleModel

class SimpleDataBindingActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivitySimpleBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_simple_binding)
        binding = DataBindingUtil.setContentView<ActivitySimpleBindingBinding>(this, R.layout.activity_simple_binding)


//        simpleDataBinding()
        setSampleModel()
    }

    private fun simpleDataBinding() {
        val model = SampleModel("Simple DataBinding", "예제는 간단하게")

        binding.apply {
            tvTitle.text = model.title
            tvSubTitle.text = model.subTitle
        }
    }

    private fun setSampleModel() {
        val model = SampleModel("Simple DataBinding", "예제는 간단하게")
        binding.model = model

    }

}
