package com.example.pinksqlit.column

enum class SqlitType(val type: String) {
    /** представляет целое число, которое может быть положительным и отрицательным
     * и в зависимости от своего значения может занимать 1, 2, 3, 4, 6 или 8 байт */
    INTEGER("INTEGER"),

    /** строка текста в одинарных кавычках, которая сохраняется в кодировке базы данных (UTF-8, UTF-16BE или UTF-16LE)*/
    TEXT("TEXT"),
    BOOLEAN("INTEGER"),

    /** указывает фактически на отсутствие значения*/
    NULL("NULL"),

    /** бинарные данные*/
    BLOB("BLOB"),

    /** представляет число с плавающей точкой, занимает 8 байт в памяти*/
    REAL("REAL");

    override fun toString(): String = type
}