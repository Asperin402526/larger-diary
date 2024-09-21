package com.example.pinksqlit.model

import android.database.Cursor
import com.example.pinksqlit.column.InColumn
import com.example.pinksqlit.column.InColumnEntity

private const val SELECT = "SELECT"
private const val FROM = "FROM"


// SELECT список_столбцов FROM имя_таблицы
class Select<E>(columnList : List<InColumnEntity<E>>, private val mapCursorToEntity:(cursor: Cursor?)->E):SetupWhere<Select<E>>() {
    override val tables :TableNameList = TableNameList()
    private var columns:String =""
    override val where:Where = Where()
    override fun thisO(): Select<E> = this
    private val orderBy=OrderBy()
    private val limit:Limit = Limit()
    val sqlSelect get() =  SqlQuery("$SELECT $columns $FROM $tables$where$orderBy$limit")
    init {
        columnList.forEach {
            tables.add(it.tableName)
            columns += it.nameTableColumn()+","
        }
       columns=columns.dropLast(1)
    }
    fun orderByAsc(column: InColumn):Select<E>{
        orderBy.asc(column)
        return this
    }
    fun orderByDesc(column: InColumn):Select<E>{
        orderBy.desc(column)
        return this
    }

    fun getEntity (offset:Int=0):E? {
        limit.count=1
        limit.offset=offset
        val cursor = sqlSelect.cursor
        if (cursor==null || cursor.count==0) return null

        cursor.moveToFirst()
        val entity:E = mapCursorToEntity(cursor)
        cursor.close()
        return entity
    }

    fun getEntityList (limit:Int=0,offset:Int=0):MutableList<E> {
        this.limit.count=limit
        this.limit.offset=offset
        val cursor = sqlSelect.cursor
        val entityList = mutableListOf<E>()
        if (cursor==null) return entityList
        else{
            cursor.moveToFirst()
            while (cursor.isAfterLast == false) {
                entityList.add(mapCursorToEntity(cursor))
                cursor.moveToNext()
            }
            cursor.close()
            return entityList
        }
    }
}