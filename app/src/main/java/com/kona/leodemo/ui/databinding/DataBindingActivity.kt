package com.kona.leodemo.ui.databinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kona.cryptokonasdk.listener.ItemClickListener
import com.kona.leodemo.R
import com.kona.leodemo.adapter.BasicAdapter
import com.kona.leodemo.util.ActivityUtil
import kotlinx.android.synthetic.main.activity_main.*

class DataBindingActivity : FragmentActivity() {

    internal val tag = this.javaClass.simpleName
    private val items = listOf("Simple DataBinding", "BindingAdapter", "Observable", "Listener", "Two-way")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        tvTitle.text = tag

        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            adapter = BasicAdapter(context, items, itemClickListener)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private val itemClickListener = object : ItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            when(position) {
                0 -> ActivityUtil.startSimpleDataBindingActivity(applicationContext)
                1 ->  ActivityUtil.startAdapterDataBindingActivity(applicationContext)
                2 ->  ActivityUtil.startObservableDataBindingActivity(applicationContext)
                3 ->  ActivityUtil.startListenerDataBindingActivity(applicationContext)
                4 ->  ActivityUtil.startTwowayDataBindingActivity(applicationContext)
                else -> { }
            }
        }

    }

}
