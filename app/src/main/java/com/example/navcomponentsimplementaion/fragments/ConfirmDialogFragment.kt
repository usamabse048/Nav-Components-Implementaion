package com.example.navcomponentsimplementaion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navcomponentsimplementaion.R
import com.example.navcomponentsimplementaion.databinding.FragmentConfirmDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ConfirmDialogFragment : BottomSheetDialogFragment() {
    private var _binding : FragmentConfirmDialogBinding? = null
    private val binding get() = _binding!!
    private val args: ConfirmDialogFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigator = findNavController()

        binding.apply {
            btnConfirmDialogYes.setOnClickListener {
                val action = ConfirmDialogFragmentDirections.actionConfirmDialogFragment2ToReciptFragment(name = args.name,amount = args.amount

                )
                navigator.navigate(action)

            }
            btnConfirmDialogNo.setOnClickListener {
               dismiss()

            }
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}