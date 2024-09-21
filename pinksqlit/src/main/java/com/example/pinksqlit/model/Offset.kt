package com.example.pinksqlit.model
private const val OFFSET = " OFFSET "
class Offset {
    var count:Int = 0
    override fun toString(): String = if(count>0) "$OFFSET$count" else ""
}