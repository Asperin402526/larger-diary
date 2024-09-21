package com.example.pinksqlit.column

enum class Autoincrement(val status:String) {
    Yes("AUTOINCREMENT "),
    No("");

    override fun toString(): String = status
}