package com.sukhpreet.roomdatabase.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EmployeeForm(
    name: String,
    age: String,
    id: String,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onIdChange: (String) -> Unit,
    onSave: (String, Int) -> Unit,
    onUpdate: (String, Int, Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Employee Details",
                style = MaterialTheme.typography.titleMedium
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = onNameChange,
                label = { Text("Employee name") },
                singleLine = true
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = age,
                onValueChange = onAgeChange,
                label = { Text("Employee age") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = id,
                onValueChange = onIdChange,
                label = { Text("Employee ID (for update)") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        val parsedAge = age.toIntOrNull()

                        if (name.isNotBlank() &&
                            parsedAge != null &&
                            parsedAge >= 0
                        ) {
                            onSave(name.trim(), parsedAge)
                        }
                    }
                ) {
                    Text("Save")
                }

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        val parsedAge = age.toIntOrNull()
                        val parsedId = id.toIntOrNull()

                        if (name.isNotBlank() &&
                            parsedAge != null &&
                            parsedAge >= 0 &&
                            parsedId != null &&
                            parsedId > 0
                        ) {
                            onUpdate(
                                name.trim(),
                                parsedAge,
                                parsedId
                            )
                        }
                    }
                ) {
                    Text("Update")
                }
            }
        }
    }
}
