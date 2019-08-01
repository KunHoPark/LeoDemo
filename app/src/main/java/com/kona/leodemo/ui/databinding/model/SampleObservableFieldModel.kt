package com.kona.leodemo.ui.databinding.model

import androidx.databinding.ObservableField

/**
 * parkkh on 2019-07-30
 *
 */
data class SampleObservableFieldModel(val _title: String, val _subTitle: String)  {
    /**
     * ObservableField set() 안에서 notifyChange()를 호출 해줌으로써 xml에 매핑 되어 있는 값이 변경 된다.
     */
    val title: ObservableField<String> = ObservableField<String>(_title)
    val subTitle: ObservableField<String> = ObservableField<String>(_subTitle)
}
