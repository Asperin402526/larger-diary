package com.example.pinksqlit.table

import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.pinksqlit.model.SqlQuery

private const val GetIndex = "SELECT LAST_INSERT_ROWID()"

abstract class TableConnect {
    /**Устанавливает нужно ли выводить SQL запросы в Logcat*/
    protected val sqlGetIndex: SqlQuery =  SqlQuery(GetIndex).end

    private var debug:(sql: SqlQuery)->Unit={
        Log.e("PinkSqlit", it.query)
        Log.e("PinkSqlit", "подключите БД TableSqlit.connect")
    }
    private val debuggingTrue:(sql: SqlQuery)->Unit={ Log.i("PinkSqlit", it.query)}
    private val debuggingFalse:(sql: SqlQuery)->Unit={}

    private var db: SQLiteDatabase? = null


    fun execSQL(sql: SqlQuery) {
        debug(sql)
        db?.execSQL(sql.query)
    }
    fun cursor(sql: SqlQuery):Cursor?{
        debug(sql)
        return db?.rawQuery(sql.query,null)
    }

    fun connect(context: Context,vararg tables:TableInitializing,debugging: Boolean = true, nameDb: String = "myDataBase" ) {
        /**Подключаем базу данных*/
        db = context.openOrCreateDatabase(nameDb, Context.MODE_PRIVATE, null)
        /**устанавливаем функцию проверки SQL запросов*/
        if(db!=null) if(debugging) debug= debuggingTrue else debug= debuggingFalse

        val storage: SharedPreferences =
            context.getSharedPreferences(nameDb + "_402526", Context.MODE_PRIVATE)

        val editor = storage.edit() // открываем фаил для записи
        tables.forEach {
            // если предыдущий запрос на создание таблицы отличался от текущего
            val sqlCreateTable = it.createTable
            if (sqlCreateTable.query != storage.getString(it.tableName.name, "")) {
                // отправляем запрос на удаление таблицы
                execSQL(it.dropTable)

                // отправляем запрос на создание таблицы
                execSQL(sqlCreateTable)


                // сохраняем новый запрос на создание таблицы
                editor.putString(it.tableName.name, sqlCreateTable.query)
            }
        }
        editor.apply()// закрываем фаил для записи применяем изменения
    }
}