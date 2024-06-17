package com.example.travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import com.example.travel.ui.theme.TravelTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                TravelTheme {
                   App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface
    ){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "opening screen") {
            composable("opening screen") {
                OpeningScreen(
                    OnNextTela = {
                        navController.navigate("MainScreen")
                    }
                )
            }
            composable("MainScreen"){
                MainScreen()
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    TravelTheme {
//        App()
    }
}
