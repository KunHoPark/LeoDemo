package com.kona.leodemo.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by parkkh on 2017. 11. 14..
 */
open abstract class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    abstract fun addItems(any: List<Any>)
}