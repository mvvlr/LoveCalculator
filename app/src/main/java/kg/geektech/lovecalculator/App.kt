package kg.geektech.lovecalculator

import android.app.Application
import kg.geektech.lovecalculator.network.LoveApi


class App : Application() {
    companion object{
        lateinit var api: LoveApi

    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitService()
        api = retrofit.api
    }
}