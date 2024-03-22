package com.example.movielistapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielistapp.R
import com.example.movielistapp.databinding.FragmentHomeBinding
import org.w3c.dom.Text

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.rvMovie.layoutManager = LinearLayoutManager(context)

        binding.titleLayout.ivFilter.setOnClickListener {
            showFilterDialog()
        }
        viewModel.moviesLiveData.observe(viewLifecycleOwner) { moviesList ->
            Log.e("data", moviesList.toString())
            if (moviesList.isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.rvMovie.adapter = moviesList.results?.let { MovieAdapter(it) }
            }

        }
        return root
    }

    private fun showFilterDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_filter, null)
        val applyFilter = dialogView.findViewById<TextView>(R.id.tv_apply_filter)

        AlertDialog.Builder(requireActivity())
            .setView(dialogView)
            .setTitle("Filter List by")
            .show()

        applyFilter.setOnClickListener {
            dialogView.visibility = View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}