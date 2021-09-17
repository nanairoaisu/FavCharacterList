package com.example.favoritelistapplication.ui.favRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.favoritelistapplication.databinding.FragmentFavRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavRegisterFragment : Fragment() {

    private val viewModel: FavRegisterViewModel by activityViewModels()
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

        viewModel.anniversary.observe(viewLifecycleOwner){ anniversary ->
            binding.btFavAnniversary.text = anniversary
        }


        binding.btFavBirthday.setOnClickListener {
            showBirthdayDialog()
        }

        viewModel.birthday.observe(viewLifecycleOwner){ birthday ->
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