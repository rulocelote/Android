package com.sem.empresasappandcmal.utils

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment:DialogFragment(){

    private var listener:DatePickerDialog.OnDateSetListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(context!!, listener, year - 18, month, day)

        c.set(Calendar.YEAR, year - 100)
        datePickerDialog.datePicker.minDate = c.timeInMillis
        c.set(Calendar.YEAR, year - 18)
        datePickerDialog.datePicker.maxDate = c.timeInMillis

        return datePickerDialog
    }

    companion object{
        fun newInstance(listener:DatePickerDialog.OnDateSetListener):DatePickerFragment{
            val fragment = DatePickerFragment()
            fragment.listener = listener
            return fragment
        }
    }
}