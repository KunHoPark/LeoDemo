package com.kona.leodemo.ui.animation

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

class AnimationMainActivity : FragmentActivity() {

    internal val tag = this.javaClass.simpleName
    private val items = listOf("ConstraintSet Sample1", "ConstraintSet Sample2","ConstraintSet Sample3", "ConstraintSet Sample4")

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
                0 -> ActivityUtil.startConstraintSetSample1Activity(applicationContext)
                1 -> ActivityUtil.startConstraintSetSample2Activity(applicationContext)
                2 -> ActivityUtil.startConstraintSetSample3Activity(applicationContext)
                3 -> ActivityUtil.startConstraintSetSample4Activity(applicationContext)
                else -> { }
            }
        }

    }

}
