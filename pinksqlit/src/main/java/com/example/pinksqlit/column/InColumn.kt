package com.example.pinksqlit.column

import com.example.pinksqlit.model.TableName
import com.example.pinksqlit.model.Unique

interface InColumn {
    val position:Int
    val tableName: TableName
    val columnName: String
    val sqlitType: SqlitType
    val primaryKey: PrimaryKey
    val autoincrement: Autoincrement
    val unique: Unique

    fun nameTableColumn():String = "$tableName.$columnName"
    fun columnConfiguration(): String = "$columnName $sqlitType $primaryKey$autoincrement$unique,"
}