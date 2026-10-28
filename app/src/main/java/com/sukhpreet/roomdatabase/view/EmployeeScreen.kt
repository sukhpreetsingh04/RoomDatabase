package com.sukhpreet.roomdatabase.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeScreen(
    modifier: Modifier = Modifier,
    onSave: (String, Int) -> Unit,
    onUpdate: (String, Int, Int) -> Unit,
    onDelete: (Int) -> Unit
) {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(), topBar = {
            TopAppBar(title = { Text("Room Database") })
        }) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(12.dp)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("Enter your name...") }
                )
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = age,
                    onValueChange = { age = it },
                    placeholder = { Text("Enter your age...") }
                )
                Spacer(Modifier.height(12.dp))

                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = id,
                    onValueChange = { id = it },
                    placeholder = { Text("Enter your id to update the employee info") }
                )
                Spacer(Modifier.height(12.dp))
                Row {
                    Button(onClick = {
                        onSave.invoke(
                            name,
                            age.toInt()
                        )
                    }) {
                        Text("Save Employee")
                    }
                    Spacer(Modifier.width(12.dp))
                    Button(onClick = {
                        onUpdate.invoke(name, age.toInt(), id.toInt())
                    }) {
                        Text("Update Employee")
                    }
                }

            }

            LazyColumn(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
            ) {
                item {
                    Text(
                        "Employee List",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(top = 24.dp)
                            .padding(bottom = 12.dp)
                            .fillMaxWidth()
                    )
                }
                repeat(12) {
                    item {
                        EmployeeItem(
                            modifier = Modifier.padding(8.dp),
                            id = 1,
                            name = "John",
                            age = 26,
                            onDelete = onDelete
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EmployeeScreenPreview(modifier: Modifier = Modifier) {

    EmployeeScreen(
        modifier = modifier,
        onSave = { a, b -> },
        onUpdate = { a, b, c -> },
        onDelete = {},
    )
}