package com.example.pinksqlit.table

import com.example.pinksqlit.model.SqlQuery
import com.example.pinksqlit.model.TableName
private const val Drop = "DROP TABLE IF EXISTS "
abstract class TableInitializing {
    abstract val tableName: TableName

    /**Возвращает SQL запрос на создание таблицы*/
    abstract val createTable: SqlQuery
    /**Возвращает SQL запрос на удаление таблицы*/
    val dropTable: SqlQuery get() = SqlQuery("$Drop$tableName")
}