package com.kona.leodemo.ui.coroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kona.cryptokonasdk.listener.ItemClickListener
import com.kona.leodemo.R
import com.kona.leodemo.adapter.BasicAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

class CoroutineActivity : AppCompatActivity() {

    internal val tag = this.javaClass.simpleName
    private val items = listOf("Basic")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()

//        var counter = AtomicInteger()
//        fanOut()
//        pipeLines()
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
                0 -> {}
                else -> {}
            }
        }

    }

    fun fanOut() = runBlocking {
        val producer = produceNumbers()
        repeat(5) {
            launchProcessor(it, producer)
        }
        delay(950)
        producer.cancel()
    }

    fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
        for (msg in channel) {
            println("Processor #$id received $msg")
        }
    }

    fun pipeLines() = runBlocking {
        val numbers = produceNumbers()
        val squares = square(numbers)
        for (i in 1..5) println(squares.receive())
        println("Done!")

        coroutineContext.cancelChildren()

    }

    fun CoroutineScope.produceNumbers() = produce {
        var x = 1
        while (true) {
            send(x++)
            delay(100)
        }
    }

    fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
        for(x in numbers) send(x * x)
    }




    fun main() = runBlocking<Unit> {
        // start main coroutine
        GlobalScope.launch {
            // launch new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("Hello,") // main coroutine continues here immediately
        delay(2000L) // delaying for 2 seconds to keep JVM alive
    }

    fun test2() {
        runBlocking {
            val jobs = List(10) {
                launch {
                    delay(1000L)
                    Log.e(tag, "aaa")
                }
            }

            // join을 하고 안하고에 따라 End runBlock이 먼저 찍힐지 끝나고 찍힐지가 결정된다
//            jobs.forEach { it.join() }

            Log.e(tag, "End runBlock")
        }
        Log.e(tag, "End function")
    }

    fun main1() = runBlocking(CoroutineName("main1")) {

        val handler = CoroutineExceptionHandler { _, exception -> println("Caught $exception") }


        launch(handler){
            delay(200L)
            log("Task from runBlocking#2")
        }

        coroutineScope {
            launch {
                delay(500L)
                log("Task from nested launch#3")
            }

            delay(100L)
            log("Task from coroutine scope#1")
        }

        log("Coroutine scope is over#4")
    }

    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

}
