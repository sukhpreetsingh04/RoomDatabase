package com.sukhpreet.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sukhpreet.roomdatabase.ui.theme.RoomDatabaseTheme
import com.sukhpreet.roomdatabase.view.EmployeeScreen
import com.sukhpreet.roomdatabase.viewmodel.RoomViewModel

class MainActivity : ComponentActivity() {

    private val viewModel : RoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel.initializeRoomDatabase(this)
        setContent {
            RoomDatabaseTheme {

                val employees = viewModel.getAllEmployees()?.collectAsStateWithLifecycle(emptyList())

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmployeeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        employees = employees?.value ?: emptyList(),
                        onSave = { name: String, age: Int ->
                            viewModel.save(name, age)
                        },
                        onUpdate = { name: String, age: Int, id: Int ->
                            viewModel.update(name, age, id)
                        },
                        onDelete = { id -> viewModel.delete(id)},
                    )
                }
            }
        }
    }
}