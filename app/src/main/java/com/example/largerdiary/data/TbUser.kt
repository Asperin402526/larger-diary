package com.example.largerdiary.data

import android.database.Cursor
import com.example.pinksqlit.TableSqlit
import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.model.TableName

object TbUser : TableSqlit<User>() {
    override val mapCursorToEntity: (cursor: Cursor?) -> User = {
        User(ID.getValue(it), NAME.getValue(it, ""))
    }
    override val tableName: TableName = TableName("user")
    val ID = int("id", PrimaryKey.Yes, Autoincrement.Yes) { it.id }
    val NAME = string("name") { it.name }
}