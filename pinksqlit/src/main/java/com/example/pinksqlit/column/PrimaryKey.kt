package com.example.pinksqlit.column

enum class PrimaryKey(val status:String) {
    Yes("PRIMARY KEY "),
    No("");

    override fun toString(): String = status
}