package com.example.pinksqlit.model
/**Ограничение UNIQUE указывает, что столбец может хранить только уникальные значения.*/
enum class Unique (val status:String) {
    Yes("UNIQUE "),
    No("");

    override fun toString(): String = status
}