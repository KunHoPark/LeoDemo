package com.kona.leodemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kona.cryptokonasdk.adapter.viewholder.BasicViewHolder
import com.kona.cryptokonasdk.listener.ItemClickListener
import com.kona.leodemo.R
/**
 * parkkh on 29/05/2019
 *
 */
class BasicAdapter(context: Context, data: List<String>, listener: ItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val context = context
    var listData = data
    val listener = listener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_basic, parent, false)
        return BasicViewHolder(view)
    }


    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.let {
            val viewHolder = it as BasicViewHolder
            viewHolder.apply {
                onBind(listData[position])
                viewHolder.itemView.setOnClickListener {
                    listener.onItemClick(itemView, position)
                }
            }
        }
    }
}

