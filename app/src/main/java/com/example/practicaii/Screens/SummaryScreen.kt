package com.example.practicaii.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SummaryScreen(name: String, age: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Resumen",
            style = MaterialTheme.typography.titleMedium
        )
        Text("Nombre: $name")
        Text("Edad: $age")
    }
}