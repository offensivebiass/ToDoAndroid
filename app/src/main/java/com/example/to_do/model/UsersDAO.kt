package com.example.to_do.model

import androidx.room.*

@Dao
interface UsersDAO {
    @Insert
    fun insert(vararg users: Users)

    @Update
    fun update(vararg users: Users)

    @Delete
    fun delete(users: Users)

    @Query("SELECT id from users WHERE username LIKE :username AND password = :password")
    fun userLogin(username: String, password : String) : Int
}