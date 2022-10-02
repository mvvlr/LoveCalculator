package kg.geektech.lovecalculator.network

import kg.geektech.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

@GET("getPercentage")
fun getPercentage(
    @Query("fname" )firstname : String,
    @Query("sname" )secondname : String,
    @Header("X-RapidAPI-Key")key: String = "b9ef5a1a02msh42adbd4d966d549p19e9f2jsn633d95607983",
    @Header("X-RapidAPI-Host")host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}