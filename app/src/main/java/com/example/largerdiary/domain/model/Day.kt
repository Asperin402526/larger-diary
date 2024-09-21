package com.example.largerdiary.domain.model

import com.example.largerdiary.domain.uc.UcGetJobDay
import com.example.largerdiary.domain.uc.day.UcLastDay
import com.example.largerdiary.domain.uc.day.UcNextDay
import com.example.largerdiary.ui.diary.UiDay

class Day(override val start:MyDateTime,
          val end:MyDateTime,
          val thisDate:MyDateTime,
          override var lastDay: Day?,
          override var nextDay:Day?
   ): UcNextDay, UcLastDay,UcGetJobDay, UiDay {
    override fun thisObject(): Day =this
    override val jobDay: MutableList<Job> = getJobDayFromDb()
}