package com.example.largerdiary.domain.model

import android.icu.util.Calendar.DAY_OF_MONTH
import android.icu.util.Calendar.DAY_OF_WEEK
import android.icu.util.Calendar.HOUR_OF_DAY
import android.icu.util.Calendar.MILLISECOND
import android.icu.util.Calendar.MINUTE
import android.icu.util.Calendar.MONTH
import android.icu.util.Calendar.SECOND
import android.icu.util.Calendar.YEAR
import android.icu.util.GregorianCalendar

class MyDateTime {
    private val dateTime: GregorianCalendar

    constructor(year:Int,month:Int,day:Int){
        dateTime = GregorianCalendar(year,month-1,day,0,0,0)
    }
    constructor(){
        dateTime = GregorianCalendar()
    }
    constructor(timeInMillis:Long){
        dateTime =GregorianCalendar()
        dateTime.timeInMillis=timeInMillis
    }
    companion object{
        enum class DayWeek(val day:String){
            Monday("Понедельник"),
            Tuesday("Вторник"),
            Wednesday("Среда"),
            Thursday("Четверг"),
            Friday("Пятница"),
            Saturday("Суббота"),
            Sunday("Воскресение");
            override fun toString(): String = day
        }
        enum class Month(val month:String){
            January ("Январь"),
            February("Февраль"),
            March("Март"),
            April("Апрель"),
            May("Май"),
            June("Июнь"),
            July("Июль"),
            August("Август"),
            September("Сентябрь"),
            October("Октябрь"),
            November("Ноябрь"),
            December("Декабрь");
            override fun toString(): String = month
        }
    }
    val dayWeek:Int get() = when (dateTime.get(DAY_OF_WEEK)){
        2 -> 1
        3 -> 2
        4 -> 3
        5 -> 4
        6 -> 5
        7 -> 6
        else -> 7
    }
    val stringDayWeek
        get() = DayWeek.entries[dayWeek-1].day
    val stringMonth
        get() = Month.entries[dateTime.get(MONTH)].month

    /**время в милисекундах*/
    var timeInMillis:Long
        get() = dateTime.timeInMillis
        set(value) {dateTime.timeInMillis=value}
    /**год*/
    val year:Int get() = dateTime.get(YEAR)
    /**месяц*/
    val month:Int get() = dateTime.get(MONTH)+1
    /**день*/
    val day:Int get() = dateTime.get(DAY_OF_MONTH)
    /**часов*/
    val hours:Int get() = dateTime.get(HOUR_OF_DAY)
    /**минут*/
    val minutes:Int get() = dateTime.get(MINUTE)
    /**секунд*/
    val seconds:Int get() = dateTime.get(SECOND)
    /**милисекунд*/
    val milliseconds:Int get() = dateTime.get(MILLISECOND)

    /**день.месяц.год*/
    val d_mm_yyyy:String get() = "$day.${month.toString().padStart(2,'0')}.$year"
    /**часов:минут*/
    val hh_mm:String get() = "${hours.toString().padStart(2,'0')}:${minutes.toString().padStart(2,'0')}"
    /**часов:минут:секунд*/
    val hh_mm_ss:String get() = "$hh_mm:${seconds.toString().padStart(2,'0')}"
    /**часов:минут:секунд.милисекунд*/
    val hh_mm_ss_mill:String get() = "$hh_mm_ss.$milliseconds"
    override fun toString(): String = "$d_mm_yyyy $hh_mm_ss_mill"

    fun addDay (day:Int):MyDateTime {
        dateTime.add(DAY_OF_WEEK,day)
        return this
    }
    fun addTime (millis: Long):MyDateTime {
        dateTime.timeInMillis = timeInMillis+millis
        return this
    }
    fun addTime (h:Int=0,m:Int=0,s:Int=0,millis:Long=0):MyDateTime {
        dateTime.timeInMillis = timeInMillis+((h*60+m)*60+s)*1000+millis
        return this
    }
    fun startDay():MyDateTime {
        dateTime.timeInMillis = timeInMillis-(((hours*60+minutes)*60+seconds)*1000+milliseconds)
        return this
    }
    fun startDayNew():MyDateTime = MyDateTime(timeInMillis).startDay()
    fun addDayNew (day:Int):MyDateTime = MyDateTime(timeInMillis).addDay(day)
    fun addTimeNew (millis: Long):MyDateTime = MyDateTime(timeInMillis).addTime(millis)
    fun addTimeNew (h:Int,m:Int,s:Int,millis:Long):MyDateTime = MyDateTime(timeInMillis).addTime(h,m,s,millis)
}