package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnFloat<E>(
    override val position: Int,
    override val mapValue: (entity: E) -> Float?,
    override val tableName: TableName,
    override val columnName: String,
    override val unique: Unique = Unique.No,
) : ColumnSqlit<E, Float>() {
    override val sqlitType: SqlitType = SqlitType.REAL
    override val primaryKey: PrimaryKey = PrimaryKey.No
    override val autoincrement: Autoincrement = Autoincrement.No
    override fun getValue(cursor: Cursor?): Float? = cursor?.getFloat(position)

    override fun valueToString(velue: Float?): String = velue.toString()

}