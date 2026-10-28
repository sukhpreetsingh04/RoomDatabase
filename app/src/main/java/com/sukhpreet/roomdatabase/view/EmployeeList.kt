package com.sukhpreet.roomdatabase.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sukhpreet.roomdatabase.data.local.EmployeeEntity

@Composable
fun EmployeeList(
    modifier: Modifier = Modifier,
    employees: List<EmployeeEntity>,
    onDelete: (Int) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Employee List (${employees.size})",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        if (employees.isEmpty()) {
            Text(
                text = "No employees yet. Add one using the form above.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = employees,
                    key = { employee -> employee.id }
                ) { employee ->
                    EmployeeItem(
                        modifier = Modifier.fillMaxWidth(),
                        id = employee.id,
                        name = employee.name,
                        age = employee.age,
                        onDelete = {
                            onDelete(employee.id)
                        }
                    )
                }
            }
        }
    }
}
