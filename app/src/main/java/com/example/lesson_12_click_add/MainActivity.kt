package com.example.lesson_12_click_add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ItemsListener {
    private var recyclerView: RecyclerView?=null
    val adapter = ItemsAdapter(this)
    private var btnDelete: Button? = null
    private var countView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupRecyclerView()
        setupListeners()
    }
    private fun setupViews(){
        recyclerView = findViewById(R.id.recycle)
        btnDelete = findViewById(R.id.Delete_item)
        countView = findViewById(R.id.item_count)
    }

    private fun setupRecyclerView(){
        recyclerView?.adapter = adapter
        adapter.update(getData())

    }
    private fun setupListeners(){
        btnDelete?.setOnClickListener {
            adapter.deleteItem(0)
        }
    }
    private fun getData(): ArrayList<ItemsDataClass> {
        val list = arrayListOf<ItemsDataClass>()
        for (i in 0..20){
            list.add(ItemsDataClass("Album $i"))
        }
        return list
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addElement->adapter.addItem(ItemsDataClass("New Album"))

        }
        return super.onOptionsItemSelected(item)
    }

    override fun itemClicks(item: ItemsDataClass) {
    }




}