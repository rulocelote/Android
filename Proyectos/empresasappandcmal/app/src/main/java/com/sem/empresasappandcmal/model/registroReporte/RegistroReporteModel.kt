package com.sem.empresasappandcmal.model.registroReporte

import java.time.LocalDate

interface RegistroReporteModel{

    fun validaRegistroReporte(
        idProblema:String,
        descripcionProblema:String,
        fechaReporte: String,
        idEmpleado:String
    )

    fun getListReportes(numEmpleado:String)

    fun getList()

}

