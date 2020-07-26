package com.example.lesson_12_click_add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val listener: ItemsListener): RecyclerView.Adapter<ItemsVH>() {

    private var data = arrayListOf<ItemsDataClass>()
    var itemCount = data.size.toString()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_linear,parent,false)
        return ItemsVH(view)
    }
    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ItemsVH, position: Int) {
        holder.bind(data[position],listener)
    }
     fun update(data:ArrayList<ItemsDataClass>) {
        this.data = data
        notifyDataSetChanged()
    }
    fun deleteItem(pos:Int){
        data.removeAt(pos)
        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos,data.size)

    }
    fun addItem(item:ItemsDataClass){
        data.add(1,item)
        notifyItemInserted(1)



    }
}
