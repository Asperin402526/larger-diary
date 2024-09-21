package com.example.largerdiary.ui.diary


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.largerdiary.domain.model.Job
import com.example.largerdiary.domain.model.MyDateTime

interface UiDay {
    val start: MyDateTime
    val jobDay: MutableList<Job>
    companion object{
        private val dp5 = 5.dp
        private val dp3 = 3.dp

        private val cardElevated = 10.dp
        private val cardMargin = PaddingValues(dp5)
        private val cardPadding = cardMargin
        private val buttonAddJobMargin = PaddingValues(dp3)
        private val buttonAddJobPadding = PaddingValues(dp5)

    }

    @Composable
    fun Rendering(){
        Card(modifier = Modifier.padding(cardMargin),
            elevation =  CardDefaults. elevatedCardElevation(cardElevated)
        ){
            Column {
                Row(modifier = Modifier.padding(cardPadding).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Date()
                    DayWek()
                    ButtonAddJob()
                }
                jobDay.forEach {
                    it.Rendering()
                }
            }
        }
    }

    @Composable
    private fun Date() = Text(text = start.d_mm_yyyy, style = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold))
    @Composable
    private fun DayWek() = Text(text = start.stringDayWeek)
    @Composable
    private fun ButtonAddJob() = Text(
        text = "+3",
        modifier = Modifier
            .padding(buttonAddJobMargin)
            .background(Color.Green)
            .padding(buttonAddJobPadding)
    )
}