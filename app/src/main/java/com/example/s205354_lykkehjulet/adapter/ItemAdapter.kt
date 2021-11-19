package com.example.s205354_lykkehjulet.adapter

import android.annotation.SuppressLint
import android.content.Context
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
import com.example.s205354_lykkehjulet.SpilController

/**
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 * @Source https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84
 *
 * @Source Soft Keyboard Håndtering: https://stackoverflow.com/questions/41790357/close-hide-the-android-soft-keyboard-with-kotlin
 * @Source Static View Handling med flere Views https://blog.mindorks.com/recyclerview-multiple-view-types-in-android
 */
class ItemAdapter(private var list: ArrayList<RVDataHandler>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Sørger for at man kan tilgå Views på tværs af hinanden.
    //TODO yikes løsning. Skal fikses
    lateinit var holderGaetView: ItemViewHolderGaet
    lateinit var holderHjulView: ItemViewHolderHjul

    companion object {
        const val viewTypeHjul = 1
        const val viewTypeGaet = 2
    }

    private val spilController = SpilController()

    class ItemViewHolderHjul(view: View) : RecyclerView.ViewHolder(view) {
        val spinResult: TextView = view.findViewById(R.id.spinResul)
        val spinKnap: Button = view.findViewById(R.id.spinKnap)
        val hp: TextView = view.findViewById(R.id.hp)
        val point: TextView = view.findViewById(R.id.point)
    }

    class ItemViewHolderGaet(view: View) : RecyclerView.ViewHolder(view) {
        val gaetKnap: Button = view.findViewById(R.id.gætKnap)
        val gaetTekstFelt: EditText = view.findViewById(R.id.gætTekstFelt)
        val ordGuess: TextView = view.findViewById(R.id.ordGuess)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == viewTypeHjul) {
            return ItemViewHolderHjul(LayoutInflater.from(parent.context)
                .inflate(R.layout.lykkehjul_item_wheel, parent, false))
        }
        return ItemViewHolderGaet(LayoutInflater.from(parent.context)
            .inflate(R.layout.lykkehjul_item_gaet, parent, false))

    }

    //Supress så den gider at stoppe at brokke sig over at jeg sætter to strings sammen
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (list[position].viewType == viewTypeHjul){
            val holderHjul = holder as ItemViewHolderHjul
            holderHjulView = holderHjul

            holderHjul.hp.text = "HP: 5"
            holderHjul.point.text = "Point: 0"

            //TODO CATEGORY

            holderHjul.spinResult.text = "Spin hjulet!"

            holderHjul.spinKnap.setOnClickListener{
                holderHjul.spinResult.text = spilController.drejHjullet()


                //Opdaterer HP og Point hvis man går bankerot eller mister et liv.
                opdaterSpillerLiv(holderHjul)
                opdaterSpillerPoint(holderHjul)

                //Stopper muligheden for at spamme på spin.
                holderHjul.spinKnap.setBackgroundResource(R.drawable.gradient_knap_graa)
                holderHjul.spinKnap.isEnabled = false

                //Gør så man kan trykke på Gaet efter man har trykket på spin


                holderGaetView.gaetKnap.setBackgroundResource(R.drawable.gradient_knap_blaa)
                holderGaetView.gaetKnap.isEnabled = true

                if (spilController.tjekTaber()) {
                    Navigation.findNavController(it).navigate(LykkehjulSpilDirections.actionLykkehjulSpilToSpilTabt())
                }

            }
        }
        else  {
            val holderGaet = holder as ItemViewHolderGaet
            holderGaetView = holderGaet

            //Sætter knappen til grå og sørger for at man ikke kan trykke på den før at man har trykket på hjulet.

            holderGaet.gaetKnap.setBackgroundResource(R.drawable.gradient_knap_graa)
            holderGaet.gaetKnap.isEnabled = false

            val ord = spilController.getRandomOrd(holderGaet.itemView.context)
            var gemtOrd = spilController.gemOrd(ord)
            holderGaet.ordGuess.text = gemtOrd

            //Ved tryk på gæt knappen skal dette ske:
            holderGaet.gaetKnap.setOnClickListener{
                try {
                    gemtOrd = spilController.tjekBogstav(
                        ord,
                        gemtOrd,
                        holderGaet.gaetTekstFelt.text.toString().single()
                    )
                }
                catch (e: NoSuchElementException) {e.printStackTrace()}

                opdaterSpillerPoint(holderHjulView)
                opdaterSpillerLiv(holderHjulView)

                //Sørger for at man ikke kan trykke gæt flere gange
                holderGaet.gaetKnap.setBackgroundResource(R.drawable.gradient_knap_graa)
                holderGaet.gaetKnap.isEnabled = false

                //Gør så man kan trykke på Spin efter man har forsøgt at gætte et bogstav
                holderHjulView.spinKnap.setBackgroundResource(R.drawable.gradient_knap_blaa)
                holderHjulView.spinKnap.isEnabled = true

                holderGaet.ordGuess.text = gemtOrd
                holderGaet.gaetTekstFelt.setText("")

                if (spilController.tjekVinder(ord, gemtOrd)) {
                    Navigation.findNavController(it).navigate(LykkehjulSpilDirections.actionLykkehjulSpilToSpilVundet())
                }
                if (spilController.tjekTaber()) {
                    Navigation.findNavController(it).navigate(LykkehjulSpilDirections.actionLykkehjulSpilToSpilTabt())
                }
            }

            //Automatisk luk af Android Soft Keyboard når man vælger et bogstav for at undgå problemer med at lukke keyboard
            holderGaet.gaetTekstFelt.addTextChangedListener {

                val keyboardBeGone = holderGaet.itemView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                keyboardBeGone.hideSoftInputFromWindow(holderGaet.itemView.windowToken, 0)
            }
        }

    }

    //Hvor mange gange den gentager hvad man ser. Da vi ikke har nogle elementer der skal være der mere end én gang, så sætter vi den bare til 1 her.
    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }

    @SuppressLint("SetTextI18n")
    fun opdaterSpillerLiv(holder: ItemViewHolderHjul) {
        holder.hp.text = "HP: " + spilController.getSpillerLiv()
    }

    @SuppressLint("SetTextI18n")
    fun opdaterSpillerPoint(holder: ItemViewHolderHjul) {
        holder.point.text = "Point: " + spilController.getSpillerPoint()
    }

}
