package com.example.s205354_lykkehjulet.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.s205354_lykkehjulet.LykkehjulSpilDirections
import com.example.s205354_lykkehjulet.R
import com.example.s205354_lykkehjulet.ReglerDirections
import com.example.s205354_lykkehjulet.SpilController
import java.lang.reflect.Executable

/**
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 * @Source https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84
 *
 * @Source Soft Keyboard Håndtering: https://stackoverflow.com/questions/41790357/close-hide-the-android-soft-keyboard-with-kotlin
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

    //Supress så den gider at stoppe at brokke sig over at jeg sætter to strings sammen: lj 63 + 64
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.gaetKnap.text = "gæt"
        holder.gaetTekstFelt.hint = "Gæt"

        holder.hp.text = "HP: 5"
        holder.point.text = "Point: 0"

        holder.spinResult.text = "Spin hjulet!"

        holder.gaetKnap.background.apply { R.drawable.gradient_knap_graa }

        //TODO CATEGORY

        val ord = spilController.getRandomOrd(holder.itemView.context)
        var gemtOrd = spilController.gemOrd(ord)
        holder.ordGuess.text = gemtOrd

        holder.spinKnap.setOnClickListener{
            holder.spinResult.text = spilController.drejHjullet()
            opdaterSpillerLiv(holder)
            opdaterSpillerPoint(holder)

            if (spilController.tjekTaber()) {
                Navigation.findNavController(it).navigate(LykkehjulSpilDirections.actionLykkehjulSpilToSpilTabt())
            }
        }

        holder.gaetKnap.setOnClickListener{
            try {
                gemtOrd = spilController.tjekBogstav(
                    ord,
                    gemtOrd,
                    holder.gaetTekstFelt.text.toString().single()
                )
            }
            catch (e: NoSuchElementException) {e.printStackTrace()}

            opdaterSpillerPoint(holder)
            opdaterSpillerLiv(holder)

            holder.ordGuess.text = gemtOrd
            holder.gaetTekstFelt.setText("")

            if (spilController.tjekVinder(ord, gemtOrd)) {
                Navigation.findNavController(it).navigate(LykkehjulSpilDirections.actionLykkehjulSpilToSpilVundet())
            }
            if (spilController.tjekTaber()) {
                Navigation.findNavController(it).navigate(LykkehjulSpilDirections.actionLykkehjulSpilToSpilTabt())
            }
        }

        //Automatisk luk af Android Soft Keyboard når man vælger et bogstav for at undgå problemer med at lukke keyboard
        holder.gaetTekstFelt.addTextChangedListener {
            val keyboardBeGone = holder.itemView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboardBeGone.hideSoftInputFromWindow(holder.itemView.windowToken, 0)
        }


    }

    //Hvor mange gange den gentager hvad man ser. Da vi ikke har nogle elementer der skal være der mere end én gang, så sætter vi den bare til 1 her.
    override fun getItemCount(): Int {
        return 1
    }

    @SuppressLint("SetTextI18n")
    fun opdaterSpillerLiv(holder: ItemViewHolder) {
        holder.hp.text = "HP: " + spilController.getSpillerLiv()
    }

    @SuppressLint("SetTextI18n")
    fun opdaterSpillerPoint(holder: ItemViewHolder) {
        holder.point.text = "Point: " + spilController.getSpillerPoint()
    }

}
