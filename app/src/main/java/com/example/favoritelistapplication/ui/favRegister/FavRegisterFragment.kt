package com.example.favoritelistapplication.ui.favRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.favoritelistapplication.databinding.FragmentFavRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavRegisterFragment : Fragment() {

    private lateinit var notificationsViewModel: FavRegisterViewModel
    private var _binding: FragmentFavRegisterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(FavRegisterViewModel::class.java)

        _binding = FragmentFavRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}