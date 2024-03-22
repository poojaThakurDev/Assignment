package com.example.movielistapp.ui.exit

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.movielistapp.databinding.FragmentExitBinding

class ExitFragment : Fragment() {

    private var _binding: FragmentExitBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExitBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.titleLayout.ivFilter.visibility = View.GONE
        sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val count = sharedPreferences.getInt("count", 1)
        binding.tvOpeningCount.text = count.toString()

        binding.tvBack.setOnClickListener {
            requireActivity().finish()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}