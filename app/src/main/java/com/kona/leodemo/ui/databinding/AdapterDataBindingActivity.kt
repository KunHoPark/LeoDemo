package com.kona.leodemo.ui.databinding

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityAdapterBindingBinding

class AdapterDataBindingActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityAdapterBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter_binding)

    }

    companion object {
        @BindingAdapter("naver")
        @JvmStatic
        fun naverBindingAdapter(textView: TextView, isNaver: Boolean) {
            when (isNaver) {
                true -> textView.text = "네이버"
                else -> textView.text = "네이버 아님"
            }
        }
    }
}
