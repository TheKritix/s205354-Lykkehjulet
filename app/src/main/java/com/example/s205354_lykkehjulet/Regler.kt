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

class Regler : Fragment() {

    private var _binding: FragmentReglerBinding? = null;

    private val binding get() = _binding!!

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

        recyclerView = binding.ReglerRecycler
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = ReglerAdapter(regelList)
        }
        binding.reglerBTN.setOnClickListener{
            Navigation.findNavController(it).navigate(ReglerDirections.actionReglerToLykkehjulSpil())
        }
    }
}