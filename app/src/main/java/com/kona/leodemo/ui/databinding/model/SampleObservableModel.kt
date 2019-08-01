package com.kona.leodemo.ui.databinding.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.kona.leodemo.BR

/**
 * parkkh on 2019-07-30
 *
 */
data class SampleObservableModel(
        private var title: String,
        private var subTitle: String
) : BaseObservable() {

    fun setTitle(title: String) {
        this.title = title
        notifyPropertyChanged(BR.title)
    }

    /**
     * @Bindable은 BR에 id 값을 지정 하기 위함이다.
     */
    @Bindable
    fun getTitle() = this.title

    fun setSubTitle(subTitle: String) {
        this.subTitle = subTitle
        notifyPropertyChanged(BR.subTitle)
    }

    @Bindable
    fun getSubTitle() = this.subTitle

}
