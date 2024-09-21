package com.example.largerdiary.domain.model

data class Group(
    var id : Int? = null,  // идентификатор группы
    val name:String = "Группа не существует", // название группы
    val description:String="", // описание группы
    val workable:Boolean=false, // функционирует группа на данный момент
)