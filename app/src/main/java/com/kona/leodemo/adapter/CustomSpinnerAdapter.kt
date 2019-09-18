package com.kona.leodemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * parkkh on 2019-09-17
 *
 */
class CustomSpinnerAdapter(context: Context, resource: Int, objects: List<String>) : ArrayAdapter<String>(context, resource, objects) {

    private val ctx = context
    private var items = objects

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView: View? = convertView

        if (itemView==null) {
            val inflater = LayoutInflater.from(ctx)
            itemView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent,false)
        }
        val tv = itemView!!.findViewById<TextView>(android.R.id.text1)
        tv.text = items[position]

        return itemView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView: View? = convertView

        if (itemView==null) {
            val inflater = LayoutInflater.from(ctx)
            itemView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent,false)
        }
        val tv = itemView!!.findViewById<TextView>(android.R.id.text1)
        tv.text = items[position]

        return itemView
    }

    override fun getCount(): Int {
        return items.size
    }

    fun addItems(objects: List<String>) {
        items = objects

        notifyDataSetChanged()
    }
}