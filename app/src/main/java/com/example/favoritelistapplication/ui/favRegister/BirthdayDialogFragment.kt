package com.example.favoritelistapplication.ui.favRegister

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.favoritelistapplication.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class BirthdayDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dialog = context?.let {
            DatePickerDialog(
                it,
                R.style.Style_customDatePicker,
                this,
                year,
                month,
                day
            )
        } ?: throw IllegalStateException()
        val goneYear = dialog.datePicker.findViewById<View>(resources.getIdentifier("year", "id", "android"))
        goneYear.visibility = View.GONE

        return dialog
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        // よくわからないが選択した月-1がのデータが得られるので+1にしてある
        val date = "${month + 1}月${dayOfMonth}日"
        fragmentManager?.setFragmentResult("reqBirth", bundleOf("bundleBirth" to date))
    }

}