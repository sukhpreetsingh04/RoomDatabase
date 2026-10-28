package com.sukhpreet.roomdatabase.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sukhpreet.roomdatabase.data.local.EmployeeEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeScreen(
    modifier: Modifier = Modifier,
    onSave: (String, Int) -> Unit,
    employees: List<EmployeeEntity> = emptyList(),
    onUpdate: (String, Int, Int) -> Unit,
    onDelete: (Int) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Employee Manager",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            EmployeeForm(
                name = name,
                age = age,
                id = id,
                onNameChange = { name = it },
                onAgeChange = { age = it },
                onIdChange = { id = it },
                onSave = onSave,
                onUpdate = onUpdate
            )

            Spacer(modifier = Modifier.height(4.dp))

            EmployeeList(
                modifier = Modifier.weight(1f),
                employees = employees,
                onDelete = onDelete
            )
        }
    }
}
