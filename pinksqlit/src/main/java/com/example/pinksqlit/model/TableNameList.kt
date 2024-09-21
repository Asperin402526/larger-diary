package com.example.pinksqlit.model

class TableNameList {
    private val tableNameList:MutableList<TableName> = mutableListOf()
    fun add(tableName:TableName):TableNameList{
        if(tableNameList.none { it == tableName }) tableNameList.add(tableName)
        return this
    }

    override fun toString(): String {
        var tableNames = ""
        tableNameList.forEach { tableNames+="$it," }
        return tableNames.dropLast(1)
    }
}