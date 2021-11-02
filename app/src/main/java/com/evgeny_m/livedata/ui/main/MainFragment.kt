package com.evgeny_m.livedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.evgeny_m.livedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding : MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("AAA","MainFragment Created")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.resultLiveData.observe(requireActivity(), Observer {
            val result = binding.loadTextData
            result.text = it
        })
    }

    override fun onResume() {
        super.onResume()
        binding.buttonSaveData.setOnClickListener {
            val text = binding.textSaveData.text.toString()
            viewModel.save(text)
        }
        binding.buttonLoadData.setOnClickListener {
            viewModel.load()
        }
    }


    companion object {
        fun newInstance() = MainFragment()
    }
}