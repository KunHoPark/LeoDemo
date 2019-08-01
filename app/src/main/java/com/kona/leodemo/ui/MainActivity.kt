package com.kona.leodemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kona.cryptokonasdk.listener.ItemClickListener
import com.kona.leodemo.R
import com.kona.leodemo.adapter.BasicAdapter
import com.kona.leodemo.util.ActivityUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private val items = listOf("DataBinding", "Coroutine")

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
                0 -> ActivityUtil.startDataBindingActivity(applicationContext)
                else -> {
                    ActivityUtil.startCoroutineActivity(applicationContext)
                }
            }
        }

    }

}
