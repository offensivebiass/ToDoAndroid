package com.example.to_do.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class ToDo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "user_id") var userId: Int = -1,
    @ColumnInfo(name = "date") var date: String = "",
    @ColumnInfo(name = "todo") var todo: String = ""
)