package kg.geektech.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kg.geektech.lovecalculator.databinding.FragmentSecondBinding
import kg.geektech.lovecalculator.model.LoveModel

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        listener()
    }

    private fun onClick() {
        val loveModel: LoveModel = arguments?.getSerializable("loveModel") as LoveModel
        with(binding){
            tvFirstName.text = loveModel.firstName
            tvSecondName.text = loveModel.secondName
            tvResult.text = loveModel.result
            tvPercent.text = loveModel.percentage

        }
    }

    private fun listener() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}