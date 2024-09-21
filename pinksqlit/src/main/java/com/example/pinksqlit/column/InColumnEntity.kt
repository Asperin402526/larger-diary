package com.example.pinksqlit.column

interface InColumnEntity<E>:InColumn {

    fun entityToValueString(entity: E): String
}