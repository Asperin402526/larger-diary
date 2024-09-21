package com.example.largerdiary.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.largerdiary.ui.UiFragment

abstract class Fragment(visibility:Boolean):UiFragment {
    companion object{
        /**список видимости фрагментов*/
        private val visibilityList = mutableListOf<MutableState<Boolean>>()
    }
    override val visibility:MutableState<Boolean> = mutableStateOf(visibility)
    /**добавляем визабилити в список видимости фрагментов*/
    init {  visibilityList.add(this.visibility)  }

    /**функция скрывает все фрагменты и делает видимым текущий фрагмент*/
    override fun visibility (){
        visibilityList.forEach{it.value=false}
        visibility.value=true
    }
}