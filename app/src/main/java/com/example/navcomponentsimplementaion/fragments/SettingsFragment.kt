package com.example.navcomponentsimplementaion.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navcomponentsimplementaion.NavGraphDirections
import com.example.navcomponentsimplementaion.R
import com.example.navcomponentsimplementaion.databinding.FragmentSettingsBinding
import com.example.navcomponentsimplementaion.viewModels.SettingsFragmentViewModel

class SettingsFragment : Fragment() {
    private var _binding : FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: SettingsFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      _binding = FragmentSettingsBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[SettingsFragmentViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
//            settingsTextInput.doOnTextChanged { text, _, _, _ ->
//                viewModel.defaultAmount.value = text.toString().toInt()
//
//            }
            btnSaveDefaultAmmount.setOnClickListener {
                val action = NavGraphDirections.actionGlobalAboutFragment()
                findNavController().navigate(action)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}