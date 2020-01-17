package com.example.modalbottomsheets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class PendingNotesFragment : Fragment() {
    var tasks: ArrayList<Task>? = null
    var adapter: TaskAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pending_notes, container, false)

        initComponents(view)

        return view
    }

    private fun initComponents(view: View) {
        //FAB
        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            //makeDialog().show()

            //BottomSheet
            val bottomShet = BottomSheetFragment.getInstance()
            fragmentManager?.let {
                bottomShet.show(it, "add_task_bottom_sheet")
                bottomShet.onSaveTask { name, date, finishDate ->
                    var task = Task(name, date, finishDate)
                    tasks?.add(task)
                    adapter?.notifyDataSetChanged()
                }
            }

        }

        tasks = ArrayList<Task>()

        //RecyclerView
        val taskList = view.findViewById<RecyclerView>(R.id.tasksList)
        taskList.setHasFixedSize(true)
        adapter = this.context?.let { tasks?.let { it1 -> TaskAdapter(it, it1) } }
        taskList.adapter = adapter
    }

    private fun makeDialog(): android.app.AlertDialog {
        val builder = android.app.AlertDialog.Builder(this.context)
        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.add_edit_task, null)

        builder.setView(view)
            .setPositiveButton("SAVE") { dialog, id ->
                val name = view.findViewById<TextInputEditText>(R.id.name)
                val date = view.findViewById<TextInputEditText>(R.id.date)
                val finishDate = view.findViewById<TextInputEditText>(R.id.estimatedFinishDate)

                var task = Task(name.text.toString(), date.text.toString(), finishDate.text.toString())
                tasks?.add(task)
                adapter?.notifyDataSetChanged()
            }
            .setNegativeButton("CANCEL") { dialog, _ ->
                dialog.cancel()
            }
        return builder.create()
    }

    companion object {
        fun newInstance(): PendingNotesFragment = PendingNotesFragment()
    }

}
