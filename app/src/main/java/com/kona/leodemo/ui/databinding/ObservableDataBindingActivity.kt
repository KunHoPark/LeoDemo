package com.kona.leodemo.ui.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kona.leodemo.R
import com.kona.leodemo.databinding.ActivityObservableBindingBinding
import com.kona.leodemo.ui.databinding.model.SampleObservableFieldModel
import com.kona.leodemo.ui.databinding.model.SampleObservableModel
import kotlinx.android.synthetic.main.activity_observable_binding.*

class ObservableDataBindingActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivityObservableBindingBinding
    private lateinit var model: SampleObservableModel
    private lateinit var sampleObservableFieldModel: SampleObservableFieldModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_observable_binding)

        setSampleObservableModel()

        btnSetObservable.setOnClickListener {

            model.setTitle("Setter DataBinding")
            sampleObservableFieldModel.title.set("Setter DataBinding")
        }
    }

    private fun setSampleObservableModel() {
        model = SampleObservableModel("Observable DataBinding", "예제는 간단하게")
        binding.observableModel = model

        sampleObservableFieldModel = SampleObservableFieldModel("ObservableFiled DataBinding", "예제는 간단하게")
        binding.observableFieldModel = sampleObservableFieldModel
    }

}
