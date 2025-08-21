package com.example.practicaii.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun FormScreen(navController: NavController){
    var name by rememberSaveable { mutableStateOf("") }
    var age  by  rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ){
        Text(
            "Ingrese sus datos",
            style= MaterialTheme.typography.titleMedium
        )

        OutlinedTextField(
            value= name,
            onValueChange = {name = it},
            label = {Text("Nombre")}
        )

        OutlinedTextField(
            value = age,
            onValueChange = {age = it},
            label = {Text("Edad")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                navController.navigate("summary?name=$name&age=$age")
            }
        ){
            Text("Enviar")
        }
    }
}
