package com.example.favoritelistapplication.ui.birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.favoritelistapplication.databinding.FragmentBirthdayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BirthdayFragment : Fragment() {

    private lateinit var birthdayViewModel: BirthdayViewModel
    private var _binding: FragmentBirthdayBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        birthdayViewModel =
            ViewModelProvider(this).get(BirthdayViewModel::class.java)

        _binding = FragmentBirthdayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        birthdayViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}