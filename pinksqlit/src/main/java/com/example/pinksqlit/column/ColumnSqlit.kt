package com.example.pinksqlit.column

abstract class ColumnSqlit<E,V>: InColumnEntityValue<E,V> {
    override fun toString(): String = columnName
}
