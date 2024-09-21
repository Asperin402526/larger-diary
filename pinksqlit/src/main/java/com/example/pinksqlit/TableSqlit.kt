package com.example.pinksqlit

import android.database.Cursor
import com.example.pinksqlit.model.Select
import com.example.pinksqlit.model.SqlQuery
import com.example.pinksqlit.table.TableConnect
import com.example.pinksqlit.table.TableSetColumn
private const val Insert = "INSERT INTO "
private const val Replace ="REPLACE INTO "
private const val CreateTable ="CREATE TABLE "
private const val Values =" VALUES "


abstract class TableSqlit<E>: TableSetColumn<E>() {
    companion object:TableConnect()

    /**Возвращает SQL запрос на создание таблицы*/
    override val createTable: SqlQuery get() =
        SqlQuery("$CreateTable$tableName (")
            .add(columnList){it.columnConfiguration()}
                .dropLast(1)
                .add(")")

    abstract val mapCursorToEntity:(cursor: Cursor?)->E

    fun insert(entity: E): Int? {
        SqlQuery("$Insert$tableName$Values(")
            .add(columnList) { it.entityToValueString(entity) + "," }.dropLast(1).add(")")
            .execSQL
        val cursor = sqlGetIndex.cursor
        if (cursor != null) {
            // Переходим к началу списка
            cursor.moveToFirst()
            val id = cursor.getInt(0)
            cursor.close()
            return id
        }

        return null
    }

    fun insert(vararg entityList: E) {
        val sql = SqlQuery("$Insert$tableName$Values")
        entityList.forEach { entity ->
            sql.add("(").add(columnList) { it.entityToValueString(entity) + "," }.dropLast(1).add("),")
        }
        sql.dropLast(1).execSQL
    }

    fun insert(entityList: List<E>) {
        val sql = SqlQuery("$Insert$tableName$Values")
        entityList.forEach { entity ->
            sql.add("(").add(columnList) { it.entityToValueString(entity) + "," }.dropLast(1).add("),")
        }
        sql.dropLast(1).execSQL
    }

    fun replace (entity: E): Int? {
        SqlQuery("$Replace$tableName$Values(")
            .add(columnList) { it.entityToValueString(entity) + "," }.dropLast(1).add(")")
            .execSQL
        val cursor = sqlGetIndex.cursor
        if (cursor != null) {
            // Переходим к началу списка
            cursor.moveToFirst()
            val id = cursor.getInt(0)
            cursor.close()
            return id
        }

        return null
    }
    fun replace(vararg entityList: E) {
        val sql = SqlQuery("$Replace$tableName$Values")
        entityList.forEach { entity ->
            sql.add("(").add(columnList) { it.entityToValueString(entity) + "," }.dropLast(1).add("),")
        }
        sql.dropLast(1).execSQL
    }

    fun replace(entityList: List<E>) {
        val sql = SqlQuery("$Replace$tableName$Values")
        entityList.forEach { entity ->
            sql.add("(").add(columnList) { it.entityToValueString(entity) + "," }.dropLast(1).add("),")
        }
        sql.dropLast(1).execSQL
    }
    val select: Select<E> get() = Select(columnList,mapCursorToEntity,)


}