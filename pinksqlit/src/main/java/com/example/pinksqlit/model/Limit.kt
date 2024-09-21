package com.example.pinksqlit.model

private const val LIMIT = " LIMIT "
class Limit {
    var count:Int=0
    var offset:Int=0
    override fun toString(): String =
        if (count==0) ""
        else if (offset==0)  "$LIMIT$count"
        else "$LIMIT$offset,$count"
}
