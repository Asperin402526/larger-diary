package com.example.largerdiary.domain.uc.day

import com.example.largerdiary.domain.model.Day

interface UcLastDay {
    fun thisObject():Day
    var lastDay: Day?
    private fun setLastDay(): Day {
        val newDay: Day = Day(start=thisObject().start.addDayNew(-1),end=thisObject().start,thisDate=thisObject().thisDate, nextDay = thisObject(), lastDay = null)
        lastDay=newDay
        return newDay
    }
    /** возвражает прошлыйдень если он не существует создает его*/
    val getLastDay: Day get() =  lastDay?:setLastDay()
}