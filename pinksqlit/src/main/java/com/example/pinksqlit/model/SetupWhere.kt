package com.example.pinksqlit.model

import com.example.pinksqlit.column.InColumnValue
import com.example.pinksqlit.table.TableInitializing

abstract class SetupWhere<T> {
    protected abstract val tables :TableNameList
    protected abstract val where:Where
    protected abstract fun thisO():T
    val and:T get(){
        where.and
        return thisO()
    }
    val or:T get(){
        where.or
        return thisO()
    }
    fun <V>where(column:InColumnValue<V>,compare:String = "=",value1:V?):T{
        tables.add(column.tableName)
        where.addWhere("${column.nameTableColumn()} $compare ${column.valueToString(value1)}")
        return thisO()
    }
    fun <V>where(column:InColumnValue<V>,compare:String = "=",column2:InColumnValue<V>):T{
        tables.add(column.tableName)
        tables.add(column2.tableName)
        where.addWhere("${column.nameTableColumn()} $compare ${column2.nameTableColumn()}")
        return thisO()
    }
    fun where(where:String,vararg tables:TableInitializing):T{
        tables.forEach {
            this.tables.add(it.tableName)
        }
        this.where.addWhere(where)
        return thisO()
    }
    fun <V>whereIn(column:InColumnValue<V>,vararg values: V?):T{
        tables.add(column.tableName)
        var w = "${column.nameTableColumn()} IN ("
        values.forEach {
            w += column.valueToString(it)+","
        }
        where.addWhere(w.dropLast(1)+")")
        return thisO()
    }
    fun <V>whereNotIn(column:InColumnValue<V>,vararg v: V?):T{
        tables.add(column.tableName)
        var w = "${column.nameTableColumn()} NOT IN ("
        v.forEach {
            w += column.valueToString(it)+","
        }
        where.addWhere(w.dropLast(1)+")")
        return thisO()
    }

    /**WHERE price BETWEEN 20000 AND 50000*/
    fun <V> whereBetween(column: InColumnValue<V>, value1: V, value2: V): T {
        tables.add(column.tableName)

        where.addWhere(
            "${column.nameTableColumn()} BETWEEN ${column.valueToString(value1)} AND ${
                column.valueToString(
                    value2
                )
            }"
        )
        return thisO()
    }
    /**WHERE column BETWEEN 20000 AND 50000*/
    fun <V> whereNotBetween(column: InColumnValue<V>, value1: V, value2: V): T {
        tables.add(column.tableName)

        where.addWhere(
            "${column.nameTableColumn()} NOT BETWEEN ${column.valueToString(value1)} AND ${
                column.valueToString(
                    value2
                )
            }"
        )
        return thisO()
    }

    /**
     ** %: соответствует любой подстроке, которая может иметь любое количество символов,
     * при этом подстрока может и не содержать ни одного символ
     *
     ** _: соответствует любому одиночному символу
      */
    fun whereLike(column: InColumnValue<String>, like:String): T {
        tables.add(column.tableName)

        where.addWhere("${column.nameTableColumn()} LIKE '$like'"
        )
        return thisO()
    }
    /**
     * %: соответствует любой подстроке, которая может иметь любое количество символов, при этом подстрока может и не содержать ни одного символ
     *
     * _: соответствует любому одиночному символу
     */
    fun whereNotLike(column: InColumnValue<String>, like:String): T {
        tables.add(column.tableName)

        where.addWhere("${column.nameTableColumn()} NOT LIKE '$like'"
        )
        return thisO()
    }
    /**
     *  *: соответствует любому количеству символов
     *
     *  ?: соответствует одному символу
     *
     *  .: соответствует любому одиночному символу
     *
     * (символы]): соответствует любому одиночному символу из списка символов внутри скобок (abc])
     *
     * (начальный_символ-конечный_символ): соответствует любому одиночному символу из диапазона символов (a-zA-Z0-9])
     *
     * ^: этот символ используется в начале списка символов и соответствует любому символу, которое НЕ входит в список (^0-9])
     */
    fun whereGlob (column: InColumnValue<String>, glob:String): T {
        tables.add(column.tableName)

        where.addWhere("${column.nameTableColumn()} GLOB '$glob'"
        )
        return thisO()
    }
    /**
     *  *: соответствует любому количеству символов
     *
     *  ?: соответствует одному символу
     *
     *  .: соответствует любому одиночному символу
     *
     * (символы]: соответствует любому одиночному символу из списка символов внутри скобок (abc])
     *
     * начальный_символ-конечный_символ]: соответствует любому одиночному символу из диапазона символов (a-zA-Z0-9])
     *
     * ^: этот символ используется в начале списка символов и соответствует любому символу, которое НЕ входит в список (^0-9])
     */
    fun whereNotGlob (column: InColumnValue<String>, glob:String): T {
        tables.add(column.tableName)

        where.addWhere("${column.nameTableColumn()} NOT GLOB '$glob'"
        )
        return thisO()
    }

    fun <V>whereIsNull(column:InColumnValue<V>):T{
        tables.add(column.tableName)
        where.addWhere("${column.nameTableColumn()} IS NULL")
        return thisO()
    }
    fun <V>whereIsNotNull(column:InColumnValue<V>):T{
        tables.add(column.tableName)
        where.addWhere("${column.nameTableColumn()} IS NOT NULL")
        return thisO()
    }
}