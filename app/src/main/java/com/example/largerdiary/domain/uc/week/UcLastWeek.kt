package com.example.largerdiary.domain.uc.week

import com.example.largerdiary.domain.model.Week

interface UcLastWeek {
    var lastWeek:Week?
    private val setLastWeek: Week
        get(){
        val d7=thisObject().day1.getLastDay
        val d6=d7.getLastDay
        val d5=d6.getLastDay
        val d4=d5.getLastDay
        val d3=d4.getLastDay
        val d2=d3.getLastDay
        val d1=d2.getLastDay
        val newWeek: Week = Week(d1,d2,d3,d4,d5,d6,d7,null,thisObject())
        lastWeek=newWeek
        return newWeek
    }

    val getLastWeek: Week get() = lastWeek?:setLastWeek
    fun thisObject():Week
}