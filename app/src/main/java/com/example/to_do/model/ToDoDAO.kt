package com.example.to_do.model

import androidx.room.*


@Dao
interface ToDoDAO {
    @Insert
    fun insert(vararg todo: ToDo)

    @Update
    fun update(vararg todo: ToDo)

    @Delete
    fun delete(todo: ToDo)

    @Query("SELECT * FROM todo WHERE user_id LIKE :user_id")
    fun getToDo(user_id : Int): List<ToDo>

    @Query("SELECT * FROM todo WHERE id LIKE :id")
    fun geToDoEdit(id: Int): ToDo

    @Query("UPDATE todo SET todo=:todo WHERE id = :id")
    fun updateToDo(todo: String?, id: Int)
}