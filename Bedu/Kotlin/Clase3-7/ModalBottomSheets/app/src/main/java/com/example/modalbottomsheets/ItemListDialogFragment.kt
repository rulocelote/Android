package com.example.modalbottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class BottomSheetFragment: BottomSheetDialogFragment() {
    var name: TextInputEditText? = null
    var date: TextInputEditText? = null
    var finishDate: TextInputEditText? = null
    var button: MaterialButton? = null

    companion object {
        fun getInstance(): BottomSheetFragment = BottomSheetFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list_dialog_item, container, false)

        this.name = view.findViewById(R.id.name)
        this.date = view.findViewById(R.id.date)
        this.finishDate = view.findViewById(R.id.estimatedFinishDate)
        this.button = view.findViewById(R.id.bottom_sheet_button)

        return view
    }

    fun onSaveTask(result: (name: String, date: String, finishDate: String) -> Unit) {
        this.button?.let { it.setOnClickListener { view ->
            result(name?.text.toString(), date?.text.toString(), finishDate?.text.toString())
        } }
    }
}
