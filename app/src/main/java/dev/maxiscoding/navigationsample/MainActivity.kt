package dev.maxiscoding.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.maxiscoding.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            FirstScreen {
                navController.navigate("secondScreen")
            }
        }
        composable("secondScreen") {
            SecondScreen(
                onNavigateToFirstScreen = { navController.navigate("firstScreen") },
                onNavigateToThirdScreen = { navController.navigate("thirdScreen") }
            )
        }
        composable("thirdScreen") {
            ThirdScreen(
                onNavigateToFirstScreen = { navController.navigate("firstScreen") },
                onNavigateToSecondScreen = { navController.navigate("secondScreen") }
            )
        }
    }
}