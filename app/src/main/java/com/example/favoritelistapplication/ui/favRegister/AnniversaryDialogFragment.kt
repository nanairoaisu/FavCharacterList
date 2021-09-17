package com.example.favoritelistapplication.ui.favRegister

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.favoritelistapplication.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AnniversaryDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private val viewModel: FavRegisterViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return context?.let {
            DatePickerDialog(
                it,
                R.style.Style_customDatePicker,
                this,
                year,
                month,
                day
            )
        } ?: throw IllegalStateException()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        // よくわからないが選択した月-1がのデータが得られるので+1にしてある
        viewModel.registerAnniversary(year, month + 1, dayOfMonth)
    }

}