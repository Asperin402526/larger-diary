package com.example.pinksqlit.column

import android.database.Cursor

interface InColumnValue<V>:InColumn {
    fun getValue(cursor: Cursor?):V?
    fun getValue(cursor: Cursor?,default:V):V = getValue(cursor)?:default
    fun valueToString(velue:V?):String
}