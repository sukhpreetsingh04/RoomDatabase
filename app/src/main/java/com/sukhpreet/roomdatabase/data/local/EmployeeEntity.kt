package com.sukhpreet.roomdatabase.data.local

import androidx.room.Entity

@Entity
data class EmployeeEntity(
    @androidx.room.PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int
)
