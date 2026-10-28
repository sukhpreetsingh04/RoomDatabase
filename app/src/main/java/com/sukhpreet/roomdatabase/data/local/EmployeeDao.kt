package com.sukhpreet.roomdatabase.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(employeeEntity: EmployeeEntity)

    @Update
    suspend fun update(employeeEntity: EmployeeEntity)

    @Query("DELETE FROM EmployeeEntity Where id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM EMPLOYEEENTITY")
    fun getAllEmployees(): Flow<List<EmployeeEntity>>
}