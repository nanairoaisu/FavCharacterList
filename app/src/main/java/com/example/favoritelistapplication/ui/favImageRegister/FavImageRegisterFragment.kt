package com.example.favoritelistapplication.ui.favImageRegister

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.favoritelistapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavImageRegisterFragment : Fragment() {

    companion object {
        fun newInstance() = FavImageRegisterFragment()
    }

    private lateinit var viewModel: FavImageRegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav_image_register, container, false)
    }


}