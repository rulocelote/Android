package com.sem.empresasappandcmal.api

import com.sem.empresasappandcmal.data.asistencia.AsistenciaRequest
import com.sem.empresasappandcmal.data.asistencia.AsistenciaResponse
import com.sem.empresasappandcmal.data.avisoGeneral.AvisoGeneralRequest
import com.sem.empresasappandcmal.data.avisoGeneral.AvisoGeneralResponse
import com.sem.empresasappandcmal.data.catalagoReporte.CatalagoReporteResponse
import com.sem.empresasappandcmal.data.login.LoginResponse
import com.sem.empresasappandcmal.data.login.LoginRequest
import com.sem.empresasappandcmal.data.notificaciones.Avisos
import com.sem.empresasappandcmal.data.pass_olvidado.OlvidoPassRequest
import com.sem.empresasappandcmal.data.pass_olvidado.OlvidoPassResponse
import com.sem.empresasappandcmal.data.perfil.PerfilAsistenciaResponse
import com.sem.empresasappandcmal.data.perfil.PerfilResponse
import com.sem.empresasappandcmal.data.registro.RegistroResponse
import com.sem.empresasappandcmal.data.registro.RegistroRequest
import com.sem.empresasappandcmal.data.registroReporte.RegistroReporteRequest
import com.sem.empresasappandcmal.data.registroReporte.RegistroReporteResponse
import com.sem.empresasappandcmal.data.reporte.Reporte
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("empleado/login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    @POST("empleado/registro")
    fun registroUser(@Body request: RegistroRequest):Call<RegistroResponse>

    @POST("empleado/olvidecontrasena")
    fun olvidoPass(@Body request: OlvidoPassRequest):Call<OlvidoPassResponse>

    @GET("empleado/perfil/{idEmpleado}")
    fun perfilAsistencia(@Path("idEmpleado") idEmpleado: String):Call<PerfilAsistenciaResponse>

    @GET("empleado/perfil/{idEmpleado}")
    fun perfilUser(@Path("idEmpleado") idEmpleado:String):Call<PerfilResponse>

    @GET ("problemas/lista")
    fun catalagoReporteUser(): Call<CatalagoReporteResponse>

    @POST("reportes/registrar")
    fun registroReporteUser(@Body request: RegistroReporteRequest):Call<RegistroReporteResponse>

    @GET("reportes/listareportes/{idEmpleado}")
    fun listaReporteUser(@Path("idEmpleado") idEmpleado:String):Call<Reporte>

    @POST("asistencia")
    fun registroAsistencia(@Body request: AsistenciaRequest):Call<AsistenciaResponse>

    @GET("avisos/catalogo/{idEmpleado}")
    fun listaAvisosUser(@Path("idEmpleado") idEmpleado:String):Call<Avisos>

    @POST("avisos/actualizar")
    fun avisoGeneralUser(@Body request: AvisoGeneralRequest):Call<AvisoGeneralResponse>

}