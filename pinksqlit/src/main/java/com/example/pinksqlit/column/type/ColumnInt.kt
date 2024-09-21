package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnInt<E>(
    override val position: Int,
    override val mapValue: (entity:E) -> Int?,
    override val tableName: TableName,
    override val columnName: String,
    override val primaryKey: PrimaryKey,
    override val autoincrement: Autoincrement,
    override val unique: Unique
): ColumnSqlit<E, Int>() {
    override val sqlitType: SqlitType = SqlitType.INTEGER
    override fun getValue(cursor: Cursor?): Int? = cursor?.getInt(position)
    override fun valueToString(velue: Int?): String = velue.toString()
}