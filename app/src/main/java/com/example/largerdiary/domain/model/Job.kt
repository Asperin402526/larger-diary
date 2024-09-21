package com.example.largerdiary.domain.model

import com.example.largerdiary.ui.diary.UiJob

data class Job (
    override var id:Int?=null,
    override var jobClass: JobClass=JobClass(),
    override var start:MyDateTime=MyDateTime(),
    override var end:MyDateTime=MyDateTime().addTime(h=1),
    override var alarmClock:MyDateTime=MyDateTime().addTime(h=-1),
    override var homework:String=""):
    UiJob

