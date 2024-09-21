package com.example.pinksqlit.table

import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.InColumnEntity
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.type.ColumnInt
import com.example.pinksqlit.column.type.ColumnString
import com.example.pinksqlit.model.Unique

/** методы создани\ колоннок*/
abstract class TableSetColumn<E>:TableInitializing(){

    protected val columnList: MutableList<InColumnEntity<E>> = mutableListOf()
    protected fun int(nameColumn:String, primaryKey: PrimaryKey = PrimaryKey.No, autoincrement: Autoincrement = Autoincrement.No, unique: Unique = Unique.No, mapValue:(entity:E)->Int?): ColumnInt<E> {
        val newColumn = ColumnInt<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            primaryKey = primaryKey,
            autoincrement=autoincrement,
            unique = unique
            )
        columnList.add(newColumn)
        return newColumn
    }

    protected fun string(nameColumn:String, unique: Unique = Unique.No, mapValue:(entity:E)->String?): ColumnString<E> {
        val newColumn = ColumnString<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            unique = unique
        )
        columnList.add(newColumn)
        return newColumn
    }
}