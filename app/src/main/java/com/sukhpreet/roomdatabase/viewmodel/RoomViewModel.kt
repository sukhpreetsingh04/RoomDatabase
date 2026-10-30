package com.sukhpreet.roomdatabase.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sukhpreet.roomdatabase.data.local.AppDatabase
import com.sukhpreet.roomdatabase.data.local.EmployeeDao
import com.sukhpreet.roomdatabase.data.local.EmployeeEntity
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel() {

    private var _dao: EmployeeDao? = null
    var selectedEmployee by mutableStateOf<EmployeeEntity?>(null)
        private set
    fun initializeRoomDatabase(context: Context) {
        _dao = AppDatabase.getInstance(context).getEmployeeDao()
    }

    fun getAllEmployees() = _dao?.getAllEmployees()

    fun save(name:String,age:Int) = viewModelScope.launch{
        val employeeEntity = EmployeeEntity(name = name, age = age)
        _dao?.save(employeeEntity)
        selectedEmployee = null
    }

    fun update(name:String, age: Int, id: Int) = viewModelScope.launch {
        val employeeEntity = EmployeeEntity(id = id, name = name, age = age)
        _dao?.updateEmployee(employeeEntity)
    }

    fun delete(id: Int) = viewModelScope.launch {
        _dao?.delete(id)
    }
}