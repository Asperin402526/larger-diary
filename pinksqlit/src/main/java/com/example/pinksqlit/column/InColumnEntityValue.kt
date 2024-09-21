package com.example.pinksqlit.column

interface InColumnEntityValue<E,V>:InColumnEntity<E>,InColumnValue<V> {
    val mapValue:(entity:E)->V?
    override fun entityToValueString(entity: E): String = valueToString(mapValue(entity))
}