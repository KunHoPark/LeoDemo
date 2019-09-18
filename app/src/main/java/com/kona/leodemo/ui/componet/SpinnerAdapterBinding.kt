package com.kona.leodemo.ui.componet

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import com.kona.leodemo.adapter.CustomSpinnerAdapter
import com.kona.leodemo.ui.componet.SpinnerExtension.setSpinnerItemSelectedListener

/**
 * parkkh on 2019-09-18
 *
 */
object SpinnerAdapterBinding {

    @BindingAdapter("spinnerItems")
    @JvmStatic
    fun setSpinnerItmes(spinner: Spinner?, items: ObservableArrayList<String>?) {
        items?.let {
            val adapter = spinner!!.adapter as CustomSpinnerAdapter
            adapter.addItems(items)
        }
    }

    @BindingAdapter("onItemSelected")
    @JvmStatic
    fun Spinner.setOnItemSelectedListener(itemSelectedListener: SpinnerExtension.ItemSelectedListener?) {
        setSpinnerItemSelectedListener(itemSelectedListener)
    }
}