package com.example.s205354_lykkehjulet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s205354_lykkehjulet.R



class ReglerAdapter(private var list: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ReglerViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val RegelText : TextView = view.findViewById(R.id.regelRV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReglerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.regler_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReglerViewHolder).RegelText.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}