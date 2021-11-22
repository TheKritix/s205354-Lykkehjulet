package com.example.s205354_lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.s205354_lykkehjulet.databinding.FragmentLykkehjulSpilBinding
import com.example.s205354_lykkehjulet.adapter.ItemAdapter
import com.example.s205354_lykkehjulet.adapter.RVDataHandler

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * @Source https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3
 * @Source https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84
 */
class LykkehjulSpil : Fragment() {

    private var _binding: FragmentLykkehjulSpilBinding? = null;

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    //onCreate er ikke nødvendig at have med, da vi ikke overrider noget i den.
    //override fun onCreate(savedInstanceState: Bundle?) {
    //    super.onCreate(savedInstanceState)
    //}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        // Inflate the layout for this fragment
        _binding = FragmentLykkehjulSpilBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = ArrayList<RVDataHandler>()
        dataList.add(RVDataHandler(ItemAdapter.viewTypeHjul))
        dataList.add(RVDataHandler(ItemAdapter.viewTypeGaet))

        recyclerView = binding.LykkehjulRecycler
        recyclerView.apply {
           recyclerView.layoutManager = LinearLayoutManager(context)
           recyclerView.adapter = ItemAdapter(dataList, recyclerView)
        }
    }
}