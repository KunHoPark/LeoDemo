package com.kona.leodemo.ui.databinding.model

import androidx.databinding.ObservableField

/**
 * parkkh on 2019-07-30
 *
 */
data class TwowayBindingModel(val _text: String="")  {
    /**
     * ObservableField set() 안에서 notifyChange()를 호출 해줌으로써 xml에 매핑 되어 있는 값이 변경 된다.
     */
    val text: ObservableField<String> = ObservableField(_text)
}
