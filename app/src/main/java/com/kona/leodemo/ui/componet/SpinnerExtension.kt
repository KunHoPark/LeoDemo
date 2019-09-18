package com.kona.leodemo.ui.componet

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

/**
 * parkkh on 2019-09-18
 *
 */
object SpinnerExtension {


    interface ItemSelectedListener {
        fun onItemSelected(position: Int)
    }

    /**
     * set spinner onItemSelectedListener listener
     */
    fun Spinner.setSpinnerItemSelectedListener(listener: ItemSelectedListener?) {
        if (listener == null) {
            onItemSelectedListener = null
        } else {
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (tag != position) {
                        listener.onItemSelected(position)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
        }
    }
}