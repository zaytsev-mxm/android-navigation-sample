package dev.maxiscoding.navigationsample

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    data object FirstScreen : Screen("firstScreen")
    data object SecondScreen : Screen("secondScreen/{name}") {
        fun createRoute(name: String) = "secondScreen/$name"
    }
    data object ThirdScreen : Screen("thirdScreen")
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(Screen.FirstScreen.route) {
            FirstScreen { name ->
                navController.navigate(Screen.SecondScreen.createRoute(name))
            }
        }

        composable(
            route = Screen.SecondScreen.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
            val name = it.arguments?.getString("name") ?: "no name"
            SecondScreen(
                name = name,
                onNavigateToFirstScreen = { navController.navigate(Screen.FirstScreen.route) },
                onNavigateToThirdScreen = { navController.navigate(Screen.ThirdScreen.route) }
            )
        }

        composable(Screen.ThirdScreen.route) {
            ThirdScreen(
                onNavigateToFirstScreen = { navController.navigate(Screen.FirstScreen.route) }
            )
        }
    }
}