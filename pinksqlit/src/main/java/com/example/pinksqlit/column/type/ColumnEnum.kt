package com.example.pinksqlit.column.type

import android.database.Cursor
import androidx.core.database.getIntOrNull
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.ColumnSqlit
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.SqlitType
import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

class ColumnEnum<E,EN:Enum<EN>>(
    override val position: Int,
    override val mapValue: (entity: E) -> EN?,
    override val tableName: TableName,
    override val columnName: String,
    private val enumArray:Array<EN>
) : ColumnSqlit<E,EN>(){
    override val sqlitType: SqlitType = SqlitType.INTEGER
    override val primaryKey: PrimaryKey = PrimaryKey.No
    override val autoincrement: Autoincrement = Autoincrement.No
    override val unique: Unique = Unique.No
    override fun getValue(cursor: Cursor?): EN? {
        val index = cursor?.getIntOrNull(position)
        return if(index==null) null
        else enumArray.getOrNull(index)
    }

    override fun valueToString(velue: EN?): String = velue?.ordinal.toString()


}