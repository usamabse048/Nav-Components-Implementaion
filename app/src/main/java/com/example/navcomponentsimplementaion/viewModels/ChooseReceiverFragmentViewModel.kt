package com.example.navcomponentsimplementaion.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class ChooseReceiverFragmentViewModel : ViewModel() {
    val name = MutableStateFlow("")
    val amount = MutableStateFlow("")
    val btnState = combine(name, amount) { name, amount ->
        (!name.isNullOrEmpty()) and (!amount.isNullOrEmpty())
    }

}