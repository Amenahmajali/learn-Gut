package com.example.mywwatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mywwatherapp.databinding.FragmentHomeBinding
import com.example.mywwatherapp.ui.fragment.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observer()


    }


    private fun observer() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.errorLiveData.observe(viewLifecycleOwner,::handleError)

    }

    private fun handleError(throwable: Throwable?) {

    }

    private fun handleLoading(flag: Boolean) {
        binding.circularProgressIndicator.isVisible=flag
    }

    private fun initAdapter() {
        TODO("Not yet implemented")
    }

}