import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle // Ejemplo para "Resumen"
import androidx.compose.material.icons.filled.List // Ejemplo para "Formulario"
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavController) {



    val items = listOf(

        Triple("form", "Formulario", Icons.Filled.List),
        Triple("summary", "Resumen", Icons.Filled.AccountCircle),

    )

    NavigationBar {
        val current = navController.currentBackStackEntryAsState().value?.destination?.route
        Log.d("BottomBar", "Current route for selection: $current")
        items.forEach { (route, label, iconVector) ->
            NavigationBarItem(
                label = { Text(label) },
                icon = {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = label
                    )
                },
                selected = current == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            //saveState = true
                        }
                        launchSingleTop = true
                            // restoreState = true
                    }
                }
            )
        }
    }
}
