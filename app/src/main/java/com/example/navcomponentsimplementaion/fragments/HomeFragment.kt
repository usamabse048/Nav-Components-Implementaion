package com.example.navcomponentsimplementaion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navcomponentsimplementaion.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()


        binding.apply {
            btnSendMoney.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToChooseRecieverFragment()
                navController.navigate(action)

            }
            btnViewBalance.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
                navController.navigate(action)

            }
            btnViewTransaction.setOnClickListener {
                navController.navigate(HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment())

            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}