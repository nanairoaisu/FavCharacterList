package com.example.favoritelistapplication.ui.anniversary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.favoritelistapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnniversaryFragment : Fragment() {

    companion object {
        fun newInstance() = AnniversaryFragment()
    }

    private lateinit var viewModel: AnniversaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anniversary, container, false)
    }

}