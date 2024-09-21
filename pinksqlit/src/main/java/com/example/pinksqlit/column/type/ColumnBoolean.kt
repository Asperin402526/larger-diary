package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

private const val NULL = "NULL"
private const val TRUE = "1"
private const val FALSE = "0"

class ColumnBoolean<E>(
    override val position: Int,
    override val mapValue: (entity: E) -> Boolean?,
    override val tableName: TableName,
    override val columnName: String,
) : ColumnSqlit<E, Boolean>() {
    override val sqlitType: SqlitType = SqlitType.INTEGER
    override val primaryKey: PrimaryKey = PrimaryKey.No
    override val autoincrement: Autoincrement = Autoincrement.No
    override val unique: Unique = Unique.No
    override fun getValue(cursor: Cursor?): Boolean? = when (cursor?.getInt(position)) {
        1 -> true
        0 -> false
        else -> null
    }

    override fun valueToString(velue: Boolean?): String = when (velue) {
        true -> TRUE
        false -> FALSE
        else -> NULL
    }
}