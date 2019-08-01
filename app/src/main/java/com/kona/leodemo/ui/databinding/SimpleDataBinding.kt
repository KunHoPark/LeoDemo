package com.kona.leodemo.ui.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kona.leodemo.R

/**
 * parkkh on 2019-07-30
 *
 */
class SimpleDataBinding: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_simple_binding, container, false)

        return view
    }
}