package com.example.largerdiary.domain.model

import com.example.largerdiary.domain.uc.week.UcLastWeek
import com.example.largerdiary.domain.uc.week.UcNextWeek
import com.example.largerdiary.ui.diary.UiWeek

class Week(
    override val day1:Day,
    override val day2:Day,
    override val day3:Day,
    override val day4:Day,
    override val day5:Day,
    override val day6:Day,
    override val day7:Day,
    override var lastWeek:Week?,
    override var nextWeek:Week?
): UiWeek, UcNextWeek, UcLastWeek {

    override fun thisObject(): Week = this
}
