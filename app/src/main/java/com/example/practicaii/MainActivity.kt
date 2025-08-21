package com.example.practicaii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicaii.Screens.FormScreen
import com.example.practicaii.Screens.SummaryScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold (
                bottomBar = {
                    BottomBar(navController)
                }
            ){ innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "form",
                        modifier = Modifier.padding(innerPadding)
                    ){
                        //Pantalla del formulario.
                        composable("form"){
                            FormScreen(navController)
                        }

                        //Pantalla del resumen (recibe parámetros de navegación)
                        composable("summary?name={name}&age={age}"){ backStackEntry ->
                            SummaryScreen(
                                name= backStackEntry.arguments?.getString("name") ?: "",
                                age = backStackEntry.arguments?.getString("age") ?: ""
                            )

                        }
                    }

            }
        }
    }
}
