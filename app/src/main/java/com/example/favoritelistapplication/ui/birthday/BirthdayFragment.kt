package com.example.favoritelistapplication.ui.birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.favoritelistapplication.databinding.FragmentBirthdayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BirthdayFragment : Fragment() {

    private val birthdayViewModel: BirthdayViewModel by viewModels()
    private lateinit var binding: FragmentBirthdayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBirthdayBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textDashboard
        birthdayViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }

}