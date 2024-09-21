package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnChar<E>(
    override val position: Int,
    override val mapValue: (entity: E) -> Char?,
    override val tableName: TableName,
    override val columnName: String,
) : ColumnSqlit<E, Char>() {
    override val sqlitType: SqlitType = SqlitType.TEXT
    override val primaryKey: PrimaryKey = PrimaryKey.No
    override val autoincrement: Autoincrement = Autoincrement.No
    override val unique: Unique = Unique.No
    override fun getValue(cursor: Cursor?): Char? = cursor?.getString(position)?.getOrNull(0)

    override fun valueToString(velue: Char?): String = "'$velue'"

}