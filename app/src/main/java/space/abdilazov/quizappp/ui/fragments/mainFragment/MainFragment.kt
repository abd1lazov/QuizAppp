package space.abdilazov.quizappp.ui.fragments.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.slider.Slider
import space.abdilazov.quizappp.R
import space.abdilazov.quizappp.core.ui.BaseFragment
import space.abdilazov.quizappp.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate), AdapterView.OnItemSelectedListener{

    private var category: Int = 0
    private var amount: Int = 0
    private var difficulty: String = ""
    private val bundle = Bundle()

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent?.id == R.id.spinner) {
            when (position) {
                0 -> category = 0
                1 -> category = 17
                2 -> category = 18
                3 -> category = 19
                4 -> category = 20
                5 -> category = 21
                6 -> category = 22
                7 -> category = 23
                8 -> category = 24
                9 -> category = 25
                10 -> category = 26
                11 -> category = 27
            }

            bundle.putInt("int",category)

            Log.e("TAG", "onItemSelected: $category" )

        } else if (parent?.id == R.id.spinner_2) {
            difficulty = binding.spinner2.selectedItem.toString()
            bundle.putString("str",difficulty)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun setupLiveData() {
    }

    override fun setupUI() {
        ArrayAdapter.createFromResource(
            requireContext(), R.array.category, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter
            binding.spinner.onItemSelectedListener = this
        }

        ArrayAdapter.createFromResource(
            requireContext(), R.array.difficulty, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner2.adapter = adapter
            binding.spinner2.onItemSelectedListener = this
        }
        binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: Slider) { }
            override fun onStopTrackingTouch(slider: Slider) {
                amount = slider.value.toInt()
                bundle.putInt("amo",amount)
            }
        })

        binding.btnStart.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_gameFragment,bundle)

        }
    }
}