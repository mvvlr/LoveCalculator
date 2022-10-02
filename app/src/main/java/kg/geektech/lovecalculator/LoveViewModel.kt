package kg.geektech.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.geektech.lovecalculator.model.LoveModel
import kg.geektech.lovecalculator.repository.Repository

class LoveViewModel : ViewModel() {

    private val repository = Repository()

    fun getLiveLoveModel(
        firstName : String,
        secondName : String
    ): LiveData<LoveModel>{
        return repository.getLoveModel(firstName, secondName)
    }


}