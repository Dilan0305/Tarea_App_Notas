package com.example.notasapp_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NotasDatabaseHelper (context: Context) : SQLiteOpenHelper (
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object{
        private const val DATABASE_NAME  = "notas.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "notas"
        private const val COLUM_ID = "id"
        private const val COLUM_TITLE = "titulo"
        private const val COLUMN_DESCRIPTION = "descripcion"
    }

    override fun onCreate(db: SQLiteDatabase?) {
      val createTableQuery =
          "CREATE TABLE $TABLE_NAME ($COLUM_ID INTEGER PRIMARY KEY, $COLUM_TITLE TEXT, $COLUMN_DESCRIPTION TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int
    ) {
        val dropTableQuery =
            "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

}