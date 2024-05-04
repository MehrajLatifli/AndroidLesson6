package com.example.androidlesson6.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidlesson6.R
import com.example.androidlesson6.databinding.FragmentRandomBinding
import kotlin.random.Random


fun randomRange(from: Int? = null, until: Int? = null): Int {
    return from?.let { start ->
        until?.let { end ->
            Random.nextInt(start, end)
        }
    } ?:0
}


class RandomFragment : Fragment() {


    private var _binding: FragmentRandomBinding? = null
    private val binding get() = _binding!!


    var randomnumber: Int? = 0

    var live: Int = 5

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.RandomButton.setOnClickListener {

            val choose =binding.radioGroup.checkedRadioButtonId

            when(choose){

                R.id.radioButton ->{

                    randomnumber = randomRange(1, 99)

                    Log.e("random",randomnumber.toString())
                }

                R.id.radioButton2 ->{

                    randomnumber = randomRange(101, 199)

                    Log.e("random",randomnumber.toString())
                }

                R.id.radioButton3 ->{

                    randomnumber = randomRange(201, 299)

                    Log.e("random",randomnumber.toString())
                }
            }


            findNavController().navigate(RandomFragmentDirections.actionRandomFragmentToEstimatedFragment(randomnumber.toString()))


        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}