package com.davevarga.swiperefreshapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var swipeLayout: SwipeRefreshLayout
    val numbersList: MutableList<Int> = (0..3).toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        swipeLayout = findViewById(R.id.swipeRefresh)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = NumbersListAdapter(numbersList)
        }


        swipeRefresh.setOnRefreshListener {
            listShuffle(numbersList)
            recycler_view.adapter = NumbersListAdapter(numbersList)
            swipeRefresh.isRefreshing = false
        }
    }

    fun <T> listShuffle(list: MutableList<T>) {
        list.shuffle()
    }
}