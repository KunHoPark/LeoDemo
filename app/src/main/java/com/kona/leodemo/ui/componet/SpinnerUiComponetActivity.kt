package com.kona.leodemo.ui.componet

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.kona.leodemo.R
import com.kona.leodemo.adapter.CustomSpinnerAdapter
import com.kona.leodemo.databinding.ActivitySpinnerUiComponetBinding
import com.kona.leodemo.util.LeoLog
import kotlinx.android.synthetic.main.activity_spinner_ui_componet.*



class SpinnerUiComponetActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private lateinit var binding: ActivitySpinnerUiComponetBinding

    private var items = mutableListOf<String>("Item1", "Item2", "Item3", "Item4", "Item5")
    var spinnerData = ObservableArrayList<String>()
    var selectedData = ObservableField<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivitySpinnerUiComponetBinding>(this, R.layout.activity_spinner_ui_componet)
        binding.model = this


        setSimpleSpiner()
        setSpinerWithDataBinding()
    }

    private fun setSpinerWithDataBinding() {
        val adapter = CustomSpinnerAdapter(this,  android.R.layout.simple_spinner_dropdown_item, items)
        spinnerDataBinding.adapter = adapter

        var localItems = mutableListOf<String>("Item1", "Item2", "Item3", "Item4", "Item5", "Item6")
        spinnerData.clear()
        spinnerData.addAll(localItems)

        items = localItems

//        spinnerDataBinding.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//            }
//
//        }
    }

    fun onItemSelected(position: Int) {
        LeoLog.i(tag, "onItemSelected position=$position")

        selectedData.set(items[position])
    }

    fun onSelectItem(parent: AdapterView<*>?, view: View?, pos: Int?, id: Long?) {
        LeoLog.i(tag, "onSelectItem pos = $pos")
    }


    private fun setSimpleSpiner() {


        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerSimple.adapter = adapter
        spinnerSimple.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedData.set(items[position])
            }

        }
    }


}
