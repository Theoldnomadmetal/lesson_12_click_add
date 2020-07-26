package com.example.lesson_12_click_add

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_linear.view.*

class ItemsVH(view: View): RecyclerView.ViewHolder(view) {
    fun bind(
        item: ItemsDataClass,
        listener: ItemsListener
    ){
        itemView.title.text = item.title
        listener.itemClicks(item)

    }
}