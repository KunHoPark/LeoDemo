package com.kona.leodemo.ui.databinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityListenerBindingBinding
import com.kona.leodemo.ui.databinding.model.SampleModel

/**
 * DataBinding에서 사용하는 Listener.
 */
class ListenerDataBindingActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityListenerBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityListenerBindingBinding>(this, R.layout.activity_listener_binding)


        initDataBinding()

    }

    private fun initDataBinding() {
        // key event를 위함.
        val presenter = ListenerPresenter()
        binding.prsenter = presenter
    }

    private fun setSampleModel() {
        val model = SampleModel("Simple DataBinding", "예제는 간단하게")
        binding.model = model
    }

    inner class ListenerPresenter {
        // 1개의 매개변수만 받을 수 있다.
        fun onClickButton(view: View) {
            Toast.makeText(view.context, "Clicked:", Toast.LENGTH_SHORT).show()
            setSampleModel()
        }

        // 2개 이상의 매개변수를 받을 수 있다.
        fun onClick(view: View, sampleModel: SampleModel) {
            Toast.makeText(view.context, "Clicked: ${sampleModel.title}", Toast.LENGTH_SHORT).show()
        }
    }

}
