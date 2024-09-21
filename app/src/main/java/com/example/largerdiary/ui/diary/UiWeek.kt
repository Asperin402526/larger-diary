package com.example.largerdiary.ui.diary

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.largerdiary.domain.model.Day

interface UiWeek {
    val day1: Day
    val day2: Day
    val day3: Day
    val day4: Day
    val day5: Day
    val day6: Day
    val day7: Day

    @Composable
    fun Rendering(){
        Column {
            day1.Rendering()
            day2.Rendering()
            day3.Rendering()
            day4.Rendering()
            day5.Rendering()
            day6.Rendering()
            day7.Rendering()
        }
    }
}