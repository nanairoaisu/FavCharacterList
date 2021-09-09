package com.example.favoritelistapplication.ui.favRegister

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.favoritelistapplication.databinding.FragmentFavRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavRegisterFragment : Fragment() {

    private val FavRegisterViewModel: FavRegisterViewModel by viewModels()
    private lateinit var binding: FragmentFavRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btFavAnniversary.setOnClickListener {
            showAnniversaryDialog()
        }
        binding.btFavBirthday.setOnClickListener {
            showBirthdayDialog()
        }

        childFragmentManager?.setFragmentResultListener("reqAnni", viewLifecycleOwner) { key, bundle ->
            val anniversary = bundle.getString("bundleAnni")
            binding.btFavAnniversary.text = anniversary
        }

        childFragmentManager?.setFragmentResultListener("reqBirth", viewLifecycleOwner) { key, bundle ->
            val birthday = bundle.getString("bundleBirth")
            binding.btFavBirthday.text = birthday
        }
    }

    private fun showAnniversaryDialog() {
        val anniversaryDialog = AnniversaryDialogFragment()
        activity?.supportFragmentManager?.let {
            anniversaryDialog.show(
                childFragmentManager,
                "datePicker"
            )
        }
            ?: throw IllegalStateException()
    }

    private fun showBirthdayDialog() {
        val birthdayDialog = BirthdayDialogFragment()
        activity?.supportFragmentManager?.let {
            birthdayDialog.show(
                childFragmentManager,
                "datePicker"
            )
        }
            ?: throw IllegalStateException()
    }


}