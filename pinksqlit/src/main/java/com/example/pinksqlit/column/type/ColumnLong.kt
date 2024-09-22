package com.example.pinksqlit.column.type

import android.database.Cursor
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnLong<E>(
    override val position: Int,
    override val tableName: TableName,
    override val columnName: String,
    override val primaryKey: PrimaryKey=PrimaryKey.No,
    override val autoincrement: Autoincrement=Autoincrement.No,
    override val mapValue: (entity: E) -> Long?,
) :ColumnSqlit<E,Long>() {
    override val sqlitType: SqlitType= SqlitType.INTEGER
    override val unique: Unique = Unique.No
    override fun getValue(cursor: Cursor?): Long? = cursor?.getLong(position)

    override fun valueToString(velue: Long?): String = velue.toString()

}