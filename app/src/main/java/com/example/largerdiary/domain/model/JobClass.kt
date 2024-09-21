package com.example.largerdiary.domain.model

data class JobClass(var id:Int?=null,
                    val group:Group=Group(),
                    val name:String="Задача не существует",
                    val description:String="",
                    val jobRepeating: JobRepeating=JobRepeating.NotRepeat,
                    val repeatCounter:Int=0,
                    val repeatDateEnd:MyDateTime=MyDateTime().startDay(),
                    val flightMode:Boolean=true,
                    val  sound:Boolean=true,
                    val сlock:Boolean=true,
                    val homework:Boolean=true,)
