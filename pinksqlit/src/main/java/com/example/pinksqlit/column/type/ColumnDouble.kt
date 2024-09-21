package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnDouble<E>(
    override val position: Int,
    override val mapValue: (entity: E) -> Double?,
    override val tableName: TableName,
    override val columnName: String,
) : ColumnSqlit<E, Double>() {
    override val sqlitType: SqlitType = SqlitType.REAL
    override val primaryKey: PrimaryKey = PrimaryKey.No
    override val autoincrement: Autoincrement = Autoincrement.No
    override val unique: Unique = Unique.No
    override fun getValue(cursor: Cursor?): Double? = cursor?.getDouble(position)

    override fun valueToString(velue: Double?): String = velue.toString()
}