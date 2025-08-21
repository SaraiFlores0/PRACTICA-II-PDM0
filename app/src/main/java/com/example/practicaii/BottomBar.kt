package com.example.practicaii

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController){
    val items = listOf("form" to "Formulario", "summary" to "Resumen")

    NavigationBar{
        val current = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { (route, label)->
            NavigationBarItem(
                label = { Text(label)},
                icon = {},
                selected = current == route,
                onClick ={
                    navController.navigate(route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}