package com.example.pinksqlit.table

import com.example.pinksqlit.column.Autoincrement
import com.example.pinksqlit.column.InColumnEntity
import com.example.pinksqlit.column.PrimaryKey
import com.example.pinksqlit.column.type.ColumnBoolean
import com.example.pinksqlit.column.type.ColumnByte
import com.example.pinksqlit.column.type.ColumnChar
import com.example.pinksqlit.column.type.ColumnDouble
import com.example.pinksqlit.column.type.ColumnEnum
import com.example.pinksqlit.column.type.ColumnFloat
import com.example.pinksqlit.column.type.ColumnInt
import com.example.pinksqlit.column.type.ColumnLong
import com.example.pinksqlit.column.type.ColumnShort
import com.example.pinksqlit.column.type.ColumnString
import com.example.pinksqlit.model.Unique

/** методы создани\ колоннок*/
abstract class TableSetColumn<E>:TableInitializing(){

    protected val columnList: MutableList<InColumnEntity<E>> = mutableListOf()
    protected fun int(nameColumn:String, primaryKey: PrimaryKey = PrimaryKey.No, autoincrement: Autoincrement = Autoincrement.No, mapValue:(entity:E)->Int?): ColumnInt<E> {
        val newColumn = ColumnInt<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            primaryKey = primaryKey,
            autoincrement=autoincrement,
            unique = Unique.No
            )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun long(nameColumn:String, primaryKey: PrimaryKey = PrimaryKey.No, autoincrement: Autoincrement = Autoincrement.No, mapValue:(entity:E)->Long?): ColumnLong<E> {
        val newColumn = ColumnLong<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            primaryKey = primaryKey,
            autoincrement=autoincrement,
            )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun short(nameColumn:String, primaryKey: PrimaryKey = PrimaryKey.No, autoincrement: Autoincrement = Autoincrement.No, mapValue:(entity:E)->Short?): ColumnShort<E> {
        val newColumn = ColumnShort<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            primaryKey = primaryKey,
            autoincrement=autoincrement,
            )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun byte(nameColumn:String, mapValue:(entity:E)->Byte?): ColumnByte<E> {
        val newColumn = ColumnByte<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
        )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun double(nameColumn:String, mapValue:(entity:E)->Double?): ColumnDouble<E> {
        val newColumn = ColumnDouble<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
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
    protected fun char(nameColumn:String, mapValue:(entity:E)->Char?): ColumnChar<E> {
        val newColumn = ColumnChar<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn
        )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun boolean(nameColumn:String, mapValue:(entity:E)->Boolean?): ColumnBoolean<E> {
        val newColumn = ColumnBoolean<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn
        )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun float(nameColumn:String, unique: Unique = Unique.No, mapValue:(entity:E)->Float?): ColumnFloat<E> {
        val newColumn = ColumnFloat<E>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            unique=unique
        )
        columnList.add(newColumn)
        return newColumn
    }
    protected fun <EN:Enum<EN>>enum(nameColumn:String,enumArray:Array<EN>, mapValue:(entity:E)->EN?): ColumnEnum<E,EN>{
        val newColumn = ColumnEnum<E,EN>(
            position = columnList.size,
            mapValue = mapValue,
            tableName = tableName,
            columnName = nameColumn,
            enumArray = enumArray
        )
        columnList.add(newColumn)
        return newColumn
    }
}