package com.example.vocabularylist.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.vocabularylist.R
import com.example.vocabularylist.data.models.TextData
import com.example.vocabularylist.data.models.VocabularyData
import com.example.vocabularylist.databinding.FragmentMainBinding
import com.example.vocabularylist.presentation.MainViewModel
import com.example.vocabularylist.ui.adapters.VocabularyAdapter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val adapter = VocabularyAdapter()
    private val mainViewModel: MainViewModel by viewModel()
    private var et1 = ""
    private var et2 = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding.rcView.adapter = adapter

        setupListeners()
        iniObservers()

//        val list = mutableListOf<VocabularyData>()
////            it.forEach() { _ ->
////                list.add(VocabularyData(VocabularyAdapter.TEXT, it))
//        repeat(10) { time ->
//            list.add(VocabularyData(0, TextData(time, "$time", "$time")))
//        }
////            }
//        list.add(
//            VocabularyData(1, TextData(10, "", ""))
//        )
//        Log.d("TTTT", "iniObservers: ${list.joinToString()}")
//        adapter.submitList(list)
    }

    private fun setupListeners() {
        binding.btnSave.setOnClickListener {
            if (et1.isNotEmpty() && et2.isNotEmpty()) {
                MainScope().launch {
                    mainViewModel.addText(TextData(0, et1, et2))
                    mainViewModel.getAllTerms()
                }

                adapter.clearEditTexts {
                    true
                }

                adapter.notifyDataSetChanged()
            }
        }

        adapter.setOnEdit1Listener {
            et1 = it
        }

        adapter.setOnEdit2Listener {
            et2 = it
        }
    }

    private fun iniObservers() {
        mainViewModel.allTextLiveData.observe(requireActivity()) {
            val list = mutableListOf<VocabularyData>()
            it.forEach { textData ->
                list.add(VocabularyData(VocabularyAdapter.TEXT, textData))
            }
            list.add(
                VocabularyData(1, TextData(10, "", ""))
            )
            Log.d("TTTT", "iniObservers: ${list.joinToString()}")
            adapter.submitList(list)
        }

        MainScope().launch {
            mainViewModel.getAllTerms()
        }
    }
}