package com.dkmkknub.villtech.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dkmkknub.villtech.navigation.AppNavRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor():ViewModel() {
    val currentRoute = mutableStateOf(AppNavRoute.SplashScreen.name)
}