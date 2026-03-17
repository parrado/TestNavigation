package com.example.testnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ... your theme ...
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AppNavigation() // Call the main navigation composable
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController() // Create the NavController

    NavHost(
        navController = navController, // Pass the NavController to the NavHost
        startDestination = Routes.HOME_SCREEN // Define the starting screen
    ) {
        composable(Routes.HOME_SCREEN) {
            HomeScreen(
                onNavigateToDetail = {
                    navController.navigate(Routes.DETAIL_SCREEN) // Navigation action
                }
            )
        }
        composable(Routes.DETAIL_SCREEN) {
            DetailScreen(
                onNavigateBack = {
                    navController.popBackStack() // Go back to the previous screen
                }
            )
        }
    }
}

// Define routes as constants
object Routes {
    const val HOME_SCREEN = "home"
    const val DETAIL_SCREEN = "detail"
}



@Composable
fun HomeScreen(
    onNavigateToDetail: () -> Unit // Lambda to handle navigation
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNavigateToDetail) {
            Text("Go to Detail Screen")
        }
    }
}

@Composable
fun DetailScreen(
    onNavigateBack: () -> Unit // Lambda to handle popping the back stack
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onNavigateBack) {
            Text("Go back Home")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Text("Detail Screen")

    }
}


