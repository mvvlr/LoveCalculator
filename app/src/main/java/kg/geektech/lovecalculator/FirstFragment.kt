package kg.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kg.geektech.lovecalculator.model.LoveModel
import kg.geektech.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    val viewModel : LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            btnNext.setOnClickListener {
                viewModel.getLiveLoveModel(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).observe(viewLifecycleOwner) {

                }
                val firstName = binding.firstNameEd.text.toString()
                val secondName = binding.secondNameEd.text.toString()
                App.api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            val loveModel = response.body()
                            val bundle = Bundle()
                            bundle.putSerializable("loveModel", loveModel)
                            findNavController().navigate(R.id.secondFragment, bundle)
                            firstNameEd.text.clear()
                            secondNameEd.text.clear()

                        }
                        Log.e("ololo", "onResponse: ${response.body()}")
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}")
                    }

                })
            }
        }
    }
}