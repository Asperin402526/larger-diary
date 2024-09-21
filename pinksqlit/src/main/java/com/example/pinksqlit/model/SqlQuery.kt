package com.example.pinksqlit.model

import android.database.Cursor
import com.example.pinksqlit.TableSqlit

class SqlQuery(query:String) {
    var query: String = query
        set(value) {
            field = setQuery(value, field)
        }
    private var setQuery: (v: String, f: String) -> String = { v, f -> v }

    val end: SqlQuery
        get() {
            setQuery = { v, f -> f }
            return this
        }

    fun add(query: String): SqlQuery {
        this.query += query
        return this
    }

    fun <E> add(entityList: List<E>, map: (entity: E) -> String): SqlQuery {
        entityList.forEach { query += map(it) }
        return this
    }

    fun dropLast(dropLast: Int): SqlQuery {
        this.query = query.dropLast(dropLast)
        return this
    }

    val execSQL: Unit  get() =  TableSqlit.execSQL(this)
    val cursor: Cursor? get() = TableSqlit.cursor(this)
}