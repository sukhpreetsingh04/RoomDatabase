package com.sukhpreet.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sukhpreet.roomdatabase.ui.theme.RoomDatabaseTheme
import com.sukhpreet.roomdatabase.view.EmployeeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDatabaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmployeeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        onSave = { name: String, age: Int -> },
                        onUpdate = { name: String, age: Int, id: Int -> },
                        onDelete = { id -> },
                    )
                }
            }
        }
    }
}