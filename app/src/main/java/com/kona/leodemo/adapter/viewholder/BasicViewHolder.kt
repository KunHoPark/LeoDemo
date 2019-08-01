package com.kona.cryptokonasdk.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_basic.view.*

/**
 * parkkh on 29/05/2019
 *
 */
class BasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val view = itemView
    fun onBind(title: String) {

        view.apply {
            tvName.text = title
        }

    }
}