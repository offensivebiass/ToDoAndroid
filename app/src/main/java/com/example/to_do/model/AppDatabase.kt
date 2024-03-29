package com.example.to_do.model

import android.content.Context
import androidx.room.*

@Database(entities = [ToDo::class, Users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDAO
    abstract fun usersDao(): UsersDAO

    companion object {

        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "todo.db")
            .allowMainThreadQueries()
            .build()
    }
}