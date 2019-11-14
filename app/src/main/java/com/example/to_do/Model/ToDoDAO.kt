package com.example.to_do.Model

import androidx.room.*
import com.example.to_do.Model.ToDo


@Dao
interface ToDoDAO {
    @Insert
    fun insert(vararg todo: ToDo)

    @Update
    fun update(vararg todo: ToDo)

    @Delete
    fun delete(todo: ToDo)

    @Query("SELECT * FROM todo")
    fun getToDo(): List<ToDo>
}