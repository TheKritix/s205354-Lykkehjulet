package com.example.s205354_lykkehjulet.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s205354_lykkehjulet.R
import com.example.s205354_lykkehjulet.SpilController

/**
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 * @Source https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84
 */
class ItemAdapter() :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val spilController = SpilController()


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gaetKnap: Button = view.findViewById(R.id.gætKnap)
        val gaetTekstFelt: EditText = view.findViewById(R.id.gætTekstFelt)
        val ordGuess: TextView = view.findViewById(R.id.ordGuess)
        val spinResult: TextView = view.findViewById(R.id.spinResul)
        val spinKnap: Button = view.findViewById(R.id.spinKnap)
        val hp: TextView = view.findViewById(R.id.hp)
        val point: TextView = view.findViewById(R.id.point)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.lykkehjul_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.gaetKnap.text = "gæt"
        holder.gaetTekstFelt.hint = "Gæt"

        holder.hp.text = "HP: 5"
        holder.point.text = "Point: 0"



        holder.spinKnap.setOnClickListener{
            holder.spinResult.text = spilController.drejHjullet()
            holder.point.text = "Point: " + spilController.getSpillerPoint()
            holder.hp.text = "HP: " + spilController.getSpillerLiv()

            val ord = spilController.getRandomOrd(holder.itemView.context)
            val gemtOrd = spilController.gemOrd(ord)
            holder.ordGuess.text = gemtOrd

        }
    }

    //Hvor mange gange den gentager hvad man ser. Da vi ikke har nogle elementer der skal være der mere end én gang, så sætter vi den bare til 1 her.
    override fun getItemCount(): Int {
        return 1
    }
}
