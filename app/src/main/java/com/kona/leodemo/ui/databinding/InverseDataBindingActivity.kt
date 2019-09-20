package com.kona.leodemo.ui.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityInverseBindingBinding
import com.kona.leodemo.ui.databinding.model.TwowayBindingModel

/**
 * DataBinding에서 사용하는 Listener.
 */
class InverseDataBindingActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityInverseBindingBinding
    var text: ObservableField<String> = ObservableField()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityInverseBindingBinding>(this, R.layout.activity_inverse_binding)


        initDataBinding()

    }

    private fun initDataBinding() {
        binding.model = TwowayBindingModel()
        binding.activity = this
    }

    fun onClickDone() {
        binding.model?.text?.set("이렇게 초기화가 됩니다.")
    }



}
