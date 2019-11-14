package com.example.to_do.Model

import androidx.room.*

@Dao
interface UsersDAO {
    @Insert
    fun insert(vararg users: Users)

    @Update
    fun update(vararg users: Users)

    @Delete
    fun delete(users: Users)

    @Query("SELECT * FROM users")
    fun getToDo(): List<Users>
}