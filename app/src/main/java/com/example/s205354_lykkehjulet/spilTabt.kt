package com.example.s205354_lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.s205354_lykkehjulet.databinding.FragmentSpilTabtBinding

class spilTabt : Fragment() {

    private var _binding: FragmentSpilTabtBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpilTabtBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spilIgenKnap.setOnClickListener{
            Navigation.findNavController(it).navigate(spilTabtDirections.actionSpilTabtToLykkehjulSpil())
        }
    }
}