package com.example.composetasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetasks.ui.theme.ComposeTasksTheme
import com.example.composetasks.ui.theme.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTasksTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "LoginScreen", builder = {
                    composable("LoginScreen"){
                        LoginScreen(navController)
                    }
                        composable("HomeScreen/{firstName}") { backStackEntry ->
                            val firstName = backStackEntry.arguments?.getString("firstName") ?: ""
                            HomeScreen(firstName = firstName)
                        }
                    } )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun CustomText(text: String){
    Text(text = text,
        style = TextStyle.Default)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTasksTheme {
        Column {
        Greeting("Android")
        CustomText(text = "Rasagna")
    }
    }
}