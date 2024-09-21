package com.example.largerdiary.ui

import androidx.compose.runtime.MutableState

interface UiFragment {
    fun visibility ()
    val visibility: MutableState<Boolean>
}