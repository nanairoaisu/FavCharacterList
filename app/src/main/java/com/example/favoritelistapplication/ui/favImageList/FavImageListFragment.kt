package com.example.favoritelistapplication.ui.favImageList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.favoritelistapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavImageListFragment : Fragment() {

    companion object {
        fun newInstance() = FavImageListFragment()
    }

    private lateinit var viewModel: FavImageListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav_image_list, container, false)
    }

}