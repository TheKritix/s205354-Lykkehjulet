package com.example.s205354_lykkehjulet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s205354_lykkehjulet.R

/**
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 */

class ReglerAdapter(private var list: List<String>, private var regelButton: Button) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ReglerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val RegelText: TextView = view.findViewById(R.id.regelRV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReglerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.regler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReglerViewHolder).RegelText.text = list[position]

        //Hvis man har læst alle reglerne, så kan man trykke videre.
        if (position == (itemCount - 1)) {
            regelButton.isEnabled = true
            regelButton.setBackgroundResource(R.drawable.gradient_knap_blaa)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}