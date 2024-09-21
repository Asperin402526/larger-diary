package com.example.largerdiary.domain.model

import com.example.largerdiary.ui.UiActivity

class Activity private constructor():UiActivity{
    companion object{
        private var activity: Activity?= null
        fun get (): Activity = activity ?: newActivity()
        private fun newActivity(): Activity {
            val newActivity = Activity()
            activity =newActivity
            return newActivity
        }
    }
    override val diary: Diary = Diary(true)

}