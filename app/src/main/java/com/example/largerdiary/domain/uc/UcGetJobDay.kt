package com.example.largerdiary.domain.uc

import com.example.largerdiary.domain.model.Day
import com.example.largerdiary.domain.model.Job

interface UcGetJobDay {
    fun thisObject(): Day
    val jobDay:MutableList<Job>
    fun getJobDayFromDb():MutableList<Job> = mutableListOf(Job(),Job(),Job())

}