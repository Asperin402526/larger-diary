package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnShort<E>(
    override val position: Int,
    override val mapValue: (entity: E) -> Short?,
    override val tableName: TableName,
    override val columnName: String,
    override val primaryKey: PrimaryKey,
    override val autoincrement: Autoincrement,

) :ColumnSqlit<E,Short>() {
    override val sqlitType: SqlitType = SqlitType.INTEGER
    override val unique: Unique = Unique.No
    override fun getValue(cursor: Cursor?): Short? = cursor?.getShort(position)

    override fun valueToString(velue: Short?): String = velue.toString()
}