package com.example.navcomponentsimplementaion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.navcomponentsimplementaion.databinding.FragmentTransactionReciptBinding


class ReciptFragment : Fragment() {
    private var _binding: FragmentTransactionReciptBinding? = null
    private val binding get() = _binding!!
    private val args: ReciptFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionReciptBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receiverName = args.name
        val receivedAmount = args.amount

        binding.apply {
            receivedAmountTextView.text = "$receiverName have received $receivedAmount"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}