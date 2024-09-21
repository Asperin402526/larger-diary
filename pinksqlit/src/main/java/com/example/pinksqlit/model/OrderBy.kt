package com.example.pinksqlit.model

import com.example.pinksqlit.column.InColumn

//ORDER BY company ASC, name DESC;
private const val Order = " ORDER BY "
private const val Asc = " ASC"
private const val Desc = " DESC"

class OrderBy {
    private var order:String?=null
    private fun pluss(order:String?, body:String):String =
        if(order==null) "$Order$body"
        else ", $body"
    fun asc(column:InColumn){
        order=pluss(order,column.nameTableColumn() + Asc)
    }
    fun desc(column:InColumn){
        order=pluss(order,column.nameTableColumn() + Desc)
    }

    override fun toString(): String = order?:""
}