package com.example.androidlesson6.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidlesson6.R
import com.example.androidlesson6.databinding.FragmentEstimatedBinding
import com.example.androidlesson6.databinding.FragmentRandomBinding


class EstimatedFragment : Fragment() {
    private var _binding: FragmentEstimatedBinding? = null
    private val binding get() = _binding!!



    private val args: EstimatedFragmentArgs by navArgs()

    

    var live: Int = 5
    var info: String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEstimatedBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var randomnumber = args.randomNumber

        binding.Checkbutton.setOnClickListener {

            val editTextValue = binding.editTextText.text.toString()

            if (editTextValue.isNotBlank()) {
                binding.LifetextView.text = "Live: ${live--.toString()}"

                if (live > 0) {
                    if (editTextValue.toInt() < randomnumber!!.toInt()) {
                        binding.infoText.text ="${binding.editTextText.text.toString().toInt()} < randomnumber"
                    }
                    if (editTextValue.toInt() > randomnumber!!.toInt()) {
                        binding.infoText.text = "${binding.editTextText.text.toString().toInt()} > randomnumber"


                    }
                    if (editTextValue.toInt() == randomnumber!!.toInt()) {
                        binding.infoText.text = "${binding.editTextText.text.toString().toInt()} = ${randomnumber}"

                        info= binding.infoText.text.toString()
                        findNavController().navigate(EstimatedFragmentDirections.actionEstimatedFragmentToResultFragment(info.toString()))


                    }
                }
                if (live <= 0) {

                    binding.infoText.text = "Live: ${live.toString()}"
                    binding.infoText.text = "Random number: ${randomnumber}"
                    live = 5

                    info= binding.infoText.text.toString()
                    findNavController().navigate(EstimatedFragmentDirections.actionEstimatedFragmentToResultFragment(info.toString()))

                }




            } else {

                binding.LifetextView.text = "Generate random"
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}