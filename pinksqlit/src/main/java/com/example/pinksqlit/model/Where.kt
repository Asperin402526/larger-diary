package com.example.pinksqlit.model

private const val startWhere = " WHERE "
private const val dividerAnd = " AND "
private const val dividerOr = " OR "

class Where {
    private var where: String? = null
    private var divider = dividerAnd


    val and: Where
        get() {
            divider = dividerAnd
            return this
        }
    val or: Where
        get() {
            divider = dividerOr
            return this
        }

    private fun plass(where: String?, concept: String): String =
        if (where == null) "$startWhere$concept"
        else "$where$divider$concept"

    fun addWhere(concept: String) {
        where = plass(where, concept)
    }

    override fun toString(): String = where ?: ""
}