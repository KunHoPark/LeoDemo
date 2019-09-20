package com.kona.leodemo.ui.databinding

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

/**
 * parkkh on 2019-07-31
 *
 */
object AdapterBinding {
//    @BindingAdapter("naver")
//    @JvmStatic
//    fun naverBindingAdapter(textView: TextView, isNaver: Boolean) {
//        when (isNaver) {
//            true -> textView.text = "네이버"
//            else -> textView.text = "네이버 아님"
//        }
//    }

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: TextView, text: String?) {
//        view.text = text
    }


    @InverseBindingAdapter(attribute="android:text", event="textEvent")
    @JvmStatic
    fun getText(textView: TextView): String {
        return textView.text.toString()
    }

    @BindingAdapter("textEvent")
    @JvmStatic
    fun setTextEvent(textView: TextView, listener: InverseBindingListener) {
        textView.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                listener.onChange()
            }

        })
    }


}