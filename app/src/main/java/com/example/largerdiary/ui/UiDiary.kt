package com.example.largerdiary.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.largerdiary.R
import com.example.largerdiary.domain.model.Week

interface UiDiary:UiFragment {
    val thisWeek: Week
    val week: MutableState<Week>
    companion object{
        private val dp0=0.dp
        private val dp8=8.dp
        private val dp25=25.dp
        private val dp40=40.dp
        private val dp3=3.dp

        private val nextPadding = PaddingValues(dp3)
        private val lastPadding = nextPadding
        private val bodyPadding = PaddingValues(dp0, dp40,dp0,dp0)
        private val topPanelSize = DpSize(dp0, dp40)
        private val topPanelPadding = PaddingValues(dp8, dp0)
        private val buttonSmallSize = DpSize(dp40, dp40)
        private val buttonLargeSize = DpSize(dp25, dp25)

    }

    @Composable
    fun Rendering(){
        AnimatedVisibility(visibility.value){
            TopPanel()
            Body()
        }
    }
    @Composable
    fun Activator(){
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.dr_icon_diary),
            contentDescription = "Дневник",
            modifier = Modifier
                .size(if(visibility.value) buttonLargeSize else buttonSmallSize)
                .clickable { visibility() }
        )
    }


    @Composable
    private fun TopPanel()=
        Box(
            Modifier
                .clickable { week.value=thisWeek }
                .fillMaxWidth()
                .size(topPanelSize)
                .padding(topPanelPadding)
                .background(Color.Gray)
        ){
            TxDiary(Modifier.align(alignment = Alignment.TopCenter))
            TxDate(Modifier.align(alignment = Alignment.BottomCenter))
            NextWeek(Modifier.align(alignment = Alignment.CenterEnd))
            LastWeek(Modifier.align(alignment = Alignment.CenterStart))
        }

    @Composable
    private fun Body() {
        Box(
            Modifier
                .padding(bodyPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            week.value.Rendering()
        }
    }
    @Composable
    private fun TxDiary(modifier: Modifier) = Text("Дневник", modifier = modifier)
    @Composable
    private fun TxDate(modifier: Modifier) = Text("${week.value.day1.start.d_mm_yyyy} - ${week.value.day7.start.d_mm_yyyy}", modifier = modifier)
    @Composable
    private fun NextWeek(modifier: Modifier) = Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.week_next),
        contentDescription = "Следующая неделя",
        modifier = modifier
            .clickable { week.value=week.value.getNextWeek }
            .padding(nextPadding)
    )
    @Composable
    private fun LastWeek(modifier: Modifier) = Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.week_last),
        contentDescription = "Следующая неделя",
        modifier = modifier
            .clickable { week.value=week.value.getLastWeek }
            .padding(lastPadding)
    )
}