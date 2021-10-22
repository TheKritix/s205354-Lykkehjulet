package com.example.s205354_lykkehjulet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s205354_lykkehjulet.R

/**
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 * @Source https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84
 */
class ItemAdapter :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.lykkehjul_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = "test"
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
