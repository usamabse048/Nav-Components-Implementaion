package com.example.navcomponentsimplementaion.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsFragmentViewModel :ViewModel() {
    var defaultAmount = MutableStateFlow(0)


}