package com.example.composetasks

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class ToastViewModel : ViewModel() {

    private val _toastEvent = MutableSharedFlow<String>()

    val toastEvent: SharedFlow<String> = _toastEvent.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _toastEvent.emit(message)
        }
    }
}