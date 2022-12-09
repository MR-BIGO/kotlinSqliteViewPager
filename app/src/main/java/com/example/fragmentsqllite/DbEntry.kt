package com.example.fragmentsqllite

import android.provider.BaseColumns

object DbEntry {
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "employee"
        const val COLUMN_NAME = "name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_AGE = "age"
        const val COLUMN_MAIL = "e_mail"
        const val COLUMN_DEPARTMENT = "department"
        const val COLUMN_SALARY = "salary"
    }
}