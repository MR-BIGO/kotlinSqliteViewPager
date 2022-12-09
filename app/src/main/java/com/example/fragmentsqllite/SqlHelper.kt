package com.example.fragmentsqllite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class SqlHelper(context: Context) : SQLiteOpenHelper(context, "employee.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ${DbEntry.FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${DbEntry.FeedEntry.COLUMN_NAME} TEXT," +
                "${DbEntry.FeedEntry.COLUMN_LAST_NAME} TEXT, " +
                "${DbEntry.FeedEntry.COLUMN_AGE} INTEGER, " +
                "${DbEntry.FeedEntry.COLUMN_MAIL} TEXT, " +
                "${DbEntry.FeedEntry.COLUMN_DEPARTMENT}, TEXT, " +
                "${DbEntry.FeedEntry.COLUMN_SALARY} INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${DbEntry.FeedEntry.TABLE_NAME}")
        onCreate(db)
    }

    fun addEmployee(employee: Employee): Long{
        val values = ContentValues()

        values.put(DbEntry.FeedEntry.COLUMN_NAME, employee.name)
        values.put(DbEntry.FeedEntry.COLUMN_LAST_NAME, employee.lastName)
        values.put(DbEntry.FeedEntry.COLUMN_AGE, employee.age)
        values.put(DbEntry.FeedEntry.COLUMN_MAIL, employee.mail)
        values.put(DbEntry.FeedEntry.COLUMN_DEPARTMENT, employee.department)
        values.put(DbEntry.FeedEntry.COLUMN_SALARY, employee.salary)

        val db = this.writableDatabase

        val newRow = db.insert(DbEntry.FeedEntry.TABLE_NAME, null, values)

        db.close()

        return newRow

    }

    @SuppressLint("Range")
    fun readData(): ArrayList<Employee>{
        val employeeList: ArrayList<Employee> = ArrayList()
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery("SELECT * FROM " + DbEntry.FeedEntry.TABLE_NAME, null)
        }catch (e: Exception){
            e.printStackTrace()
            db.execSQL("SELECT * FROM " + DbEntry.FeedEntry.TABLE_NAME)
            return ArrayList()
        }
        var name: String
        var lastName: String
        var age: Int
        var mail: String
        var dep: String
        var salary: Int

        if (cursor.moveToFirst()){
            do {
                name = cursor.getString(cursor.getColumnIndex(DbEntry.FeedEntry.COLUMN_NAME))
                lastName = cursor.getString(cursor.getColumnIndex(DbEntry.FeedEntry.COLUMN_LAST_NAME))
                age = cursor.getInt(cursor.getColumnIndex(DbEntry.FeedEntry.COLUMN_AGE))
                mail = cursor.getString(cursor.getColumnIndex(DbEntry.FeedEntry.COLUMN_MAIL))
                dep = cursor.getString(cursor.getColumnIndex(DbEntry.FeedEntry.COLUMN_DEPARTMENT))
                salary = cursor.getInt(cursor.getColumnIndex(DbEntry.FeedEntry.COLUMN_SALARY))

                val employee = Employee(name = name, lastName = lastName, age = age, mail = mail, department = dep, salary = salary)
                employeeList.add(employee)
            }while (cursor.moveToNext())
        }
        db.close()

        return employeeList
    }
}