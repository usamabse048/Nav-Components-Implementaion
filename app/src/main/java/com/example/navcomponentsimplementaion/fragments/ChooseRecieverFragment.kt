package com.example.navcomponentsimplementaion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.navcomponentsimplementaion.databinding.FragmentChooseReceiverBinding
import com.example.navcomponentsimplementaion.viewModels.ChooseReceiverFragmentViewModel
import kotlinx.coroutines.flow.collect


class ChooseRecieverFragment : Fragment() {

    private var _binding: FragmentChooseReceiverBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ChooseReceiverFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseReceiverBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ChooseReceiverFragmentViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            receiverNameTextView.doOnTextChanged { text, _, _, _ ->
                viewModel.name.value = text.toString()
            }
            amountTextView.doOnTextChanged { text, _, _, _ ->
                viewModel.amount.value = text.toString()
            }

            btnReceiverNameNext.setOnClickListener {
                val action =
                    ChooseRecieverFragmentDirections.actionChooseRecieverFragmentToConfirmDialogFragment2(
                        name = receiverNameTextView.text.toString(),
                        amount = amountTextView.text.toString().toInt()
                    )
                findNavController().navigate(action)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {
            viewModel.btnState.collect {
                binding.btnReceiverNameNext.isEnabled = it
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}