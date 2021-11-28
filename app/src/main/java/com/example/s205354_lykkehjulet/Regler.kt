package com.example.s205354_lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205354_lykkehjulet.adapter.ReglerAdapter
import com.example.s205354_lykkehjulet.databinding.FragmentReglerBinding

/**
 * @source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 */

class Regler : Fragment() {

    private var _binding: FragmentReglerBinding? = null;

    private val binding get() = _binding!!

    //Opretter en endnu ikke instansieret RecyclerView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentReglerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Liste over vores regler til vores RecyclerView
        val regelList = listOf(
            getString(R.string.regel1),
            getString(R.string.regel2),
            getString(R.string.regel3),
            getString(R.string.regel4),
            getString(R.string.regel5),
            getString(R.string.regel6),
            getString(R.string.regel7),
            getString(R.string.regel8),
            getString(R.string.regel9),
            getString(R.string.regel10),
            getString(R.string.regel11),
        )

        //Opsætter vores RecyclerView for vores regler
        recyclerView = binding.ReglerRecycler
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ReglerAdapter(regelList, binding.reglerBTN)
        }

        //Disabler knappen indtil at alle regler er læst.
        binding.reglerBTN.isEnabled = false
        binding.reglerBTN.setBackgroundResource(R.drawable.gradient_knap_graa)

        //Forsæt knap videre til næste fragment.
        binding.reglerBTN.setOnClickListener{
            Navigation.findNavController(it).navigate(ReglerDirections.actionReglerToLykkehjulSpil())
        }
    }
}