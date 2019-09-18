package com.kona.leodemo.ui.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityTwowayBindingBinding
import com.kona.leodemo.ui.databinding.model.TwowayBindingModel

/**
 * DataBinding에서 사용하는 Listener.
 */
class TwowayDataBindingActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityTwowayBindingBinding
    var text: ObservableField<String> = ObservableField()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityTwowayBindingBinding>(this, R.layout.activity_twoway_binding)


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
