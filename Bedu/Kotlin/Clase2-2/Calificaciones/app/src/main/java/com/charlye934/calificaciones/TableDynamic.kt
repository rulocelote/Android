/*
package com.charlye934.calificaciones

import android.content.Context
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class TableDynamic(tableLayout: TableLayout, applicationContext: Context){
    lateinit var context:Context
    lateinit var tableLayout:TableLayout
    var tableRow: TableLayout = table
    lateinit var txtCell:TextView
    lateinit var header:Array<String>
    lateinit var data: ArrayList<Array<String>>
    var indexC:Int = 0
    var indexR:Int = 1


    fun addHeader(header:Array<String>){
        this.header = header
        createHeader()
    }

    fun addData(data: ArrayList<Array<String>>) {
        this.data = data
        createDataTable()
    }

    fun newRow(){
        tableRow = TableRow(context)
    }

    fun newCell(){
        txtCell = TextView(context)
        txtCell.setGravity(Gravity.CENTER)
        txtCell.setTextSize(25F)
    }

    fun createHeader(){
        newRow()
        while (indexC < header.size){
            newCell()
            txtCell.setText(header[indexC++])
            tableRow.addView(txtCell)
        }
        tableLayout.addView(tableRow)
    }

    fun createDataTable(){
        var info:String
        for(indexR in  0..header.size){
            newRow()
            for(indexC in 0..header.size-1) {
                newCell()
                var columns = data.get(indexR-1)
                info= if (indexC<columns.size) columns[indexC] else ""
                txtCell.setText(info)
                tableRow.addView(txtCell,newTableRowParams())
            }
            tableLayout.addView(tableRow)
        }
    }

    fun newTableRowParams():TableRow.LayoutParams {
        var params:TableRow.LayoutParams = TableRow.LayoutParams()
        params.setMargins(1,1,1,1)
        params.weight= 1F
        return params
    }
}
*/
