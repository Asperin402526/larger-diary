package com.example.largerdiary.ui.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.largerdiary.domain.model.JobClass
import com.example.largerdiary.domain.model.MyDateTime

interface UiJob {
    var id:Int?
    var jobClass: JobClass
    var start: MyDateTime
    var end:MyDateTime
    var alarmClock:MyDateTime
    var homework:String

    @Composable
    fun Rendering() {
        Column(modifier = Modifier.background(Color.White)) {
            HorizontalDivider()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Name()
                }
                Start()
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Homework()
                }
                End()
            }
        }
    }
    @Composable
    private fun Name()= Text(jobClass.name)
    @Composable
    private fun Start()= Text(start.hh_mm)
    @Composable
    private fun End()= Text(end.hh_mm)
    @Composable
    private fun Homework()= Text(homework)
}