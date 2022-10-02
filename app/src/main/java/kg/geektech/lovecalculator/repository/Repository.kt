package kg.geektech.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.geektech.lovecalculator.App
import kg.geektech.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Response

class Repository {

    fun getLoveModel(firstName : String, secondName : String): MutableLiveData<LoveModel> {
        val loveModel : MutableLiveData<LoveModel> = MutableLiveData()

        App.api.getPercentage(firstName, secondName).enqueue(object  : retrofit2.Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                loveModel.postValue(response.body())
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message} " )
            }
        })

        return loveModel
    }

}