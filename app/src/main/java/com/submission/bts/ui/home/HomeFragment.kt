package com.submission.bts.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.bts.DetailAct
import com.submission.bts.adapter.OnItemClickListener
import com.submission.bts.adapter.TempatWisataAdapter
import com.submission.bts.databinding.FragmentHomeBinding
import com.submission.bts.model.TempatWisata

class HomeFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvWisata.setHasFixedSize(true)
        binding.rvWisata.layoutManager = LinearLayoutManager(requireContext())
        homeViewModel.rvcWisata.observe(viewLifecycleOwner) {
            binding.rvWisata.adapter  = TempatWisataAdapter(it, this)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int, data: TempatWisata) {
        val intent = Intent(requireContext(), DetailAct::class.java).apply {
                putExtra("TEMPAT_WISATA", data)
            }
        startActivity(intent)
    }
}