package com.sukhpreet.roomdatabase.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun EmployeeItem(
    modifier: Modifier = Modifier,
    id: Int,
    name: String,
    age: Int,
    onDelete: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Color.Yellow, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp)
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {

        Column(modifier = Modifier.weight(1f)) {
            Text(name, style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(12.dp))
            Text(age.toString(), style = MaterialTheme.typography.bodyLarge)
        }

        IconButton(onClick = { onDelete(id) }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun EmployeeItemPreview(modifier: Modifier = Modifier) {
    EmployeeItem(
        modifier = modifier,
        id = 1,
        name = "John",
        age = 12
    ) { }
}