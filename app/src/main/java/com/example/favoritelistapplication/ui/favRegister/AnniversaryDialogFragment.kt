package com.example.favoritelistapplication.ui.favRegister

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.favoritelistapplication.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AnniversaryDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

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
        val date = "${year}年${month + 1}月${dayOfMonth}日"
        fragmentManager?.setFragmentResult("reqAnni", bundleOf("bundleAnni" to date))
    }

}