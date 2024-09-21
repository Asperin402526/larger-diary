package com.example.largerdiary.domain.uc.day

import com.example.largerdiary.domain.model.Day

interface UcNextDay {
    var nextDay: Day?
    private fun setNextDay(): Day {
        val newDay: Day = Day(start=thisObject().end,end=thisObject().end.addDayNew(1),thisDate=thisObject().thisDate, lastDay = thisObject(), nextDay = null)
        nextDay=newDay
        return newDay
    }
    /**Возвращает следующий день, если он не существует создает его*/
    val getNextDay: Day get()= nextDay?:setNextDay()
    fun thisObject():Day
}