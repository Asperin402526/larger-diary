package com.example.largerdiary.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.largerdiary.domain.model.Diary

interface UiActivity {
    val diary: Diary

    companion object{
        private val dp0 = 0.dp
        private val dp40 = 40.dp
        private val dp50 = 50.dp

        private val bottomPadding =  PaddingValues(dp50,dp0,dp0,dp0)
        private val bottomSize =  DpSize(dp40,dp0)

        private val leftSize =  DpSize(dp0,dp40)

        private val bodyPadding = PaddingValues(dp50,dp0,dp0, dp50)
    }
    @Composable
    fun Rendering(modifier: Modifier) {
        Box(modifier){
            LeftPanel()
            BottomPanel(Modifier.align(Alignment.BottomStart))
            Body()
        }
    }
    @Composable
    private fun LeftPanel(modifier: Modifier = Modifier) {
        Box(modifier
            .fillMaxHeight()
            .size(leftSize)
            .background(Color.Yellow)
        ){

        }
    }
    @Composable
    private fun BottomPanel(modifier: Modifier = Modifier) {
        Row(horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .size(bottomSize)
                .padding(bottomPadding)
        ) {
            diary.Activator()
        }
    }
    @Composable
    private fun Body(modifier: Modifier = Modifier) {
        Box(
            modifier
                .fillMaxSize()
                .padding(bodyPadding)
                .background(Color.Blue)
        ) {
            diary.Rendering()
        }
    }
}