package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

private const val NALL = "NULL"

class ColumnString<E>(
    override val position: Int,
    override val mapValue: (entity: E) -> String?,
    override val tableName: TableName,
    override val columnName: String,
    override val unique: Unique,
) : ColumnSqlit<E, String>() {
    override val sqlitType: SqlitType = SqlitType.TEXT
    override val primaryKey: PrimaryKey = PrimaryKey.No
    override val autoincrement: Autoincrement = Autoincrement.No
    override fun getValue(cursor: Cursor?): String? = cursor?.getString(position)
    override fun valueToString(velue: String?): String = if (velue == null) NALL else "'$velue'"
}