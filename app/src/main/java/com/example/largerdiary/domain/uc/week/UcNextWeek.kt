package com.example.largerdiary.domain.uc.week

import com.example.largerdiary.domain.model.Week

interface UcNextWeek {
    var nextWeek:Week?

    private fun setNextWeek(): Week {
        val d1=thisObject().day7.getNextDay
        val d2=d1.getNextDay
        val d3=d2.getNextDay
        val d4=d3.getNextDay
        val d5=d4.getNextDay
        val d6=d5.getNextDay
        val d7=d6.getNextDay
        val newWeek: Week = Week(d1,d2,d3,d4,d5,d6,d7,thisObject(),null)
        nextWeek=newWeek
        return newWeek
    }
    val getNextWeek: Week get() = nextWeek?:setNextWeek()
    fun thisObject():Week
}