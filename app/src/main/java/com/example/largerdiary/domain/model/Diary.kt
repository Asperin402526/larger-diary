package com.example.largerdiary.domain.model

import androidx.compose.runtime.mutableStateOf
import com.example.largerdiary.ui.UiDiary


class Diary(visibility:Boolean): Fragment(visibility),UiDiary {
    /** текущая неделя*/
    override val thisWeek:Week
    /**создаем текущую неделю*/
    init {
        val thisDate:MyDateTime = MyDateTime().startDay()
        val startWeek:MyDateTime = thisDate.addDayNew(-(thisDate.dayWeek-1))
        val d1:Day = Day(startWeek,startWeek.addDayNew(1),thisDate,null,null)
        val d2:Day = d1.getNextDay
        val d3:Day = d2.getNextDay
        val d4:Day = d3.getNextDay
        val d5:Day = d4.getNextDay
        val d6:Day = d5.getNextDay
        val d7:Day = d6.getNextDay
        thisWeek=Week(d1,d2,d3,d4,d5,d6,d7,null,null)
    }
    /**неделя которая отображается в дневнике*/
    override val week = mutableStateOf(thisWeek)
}