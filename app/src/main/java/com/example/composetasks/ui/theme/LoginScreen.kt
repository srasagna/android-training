package com.example.composetasks.ui.theme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetasks.R

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.b),
            contentDescription = "Login Image",
            modifier = Modifier.size(200.dp)
        )

        Text(text = "Welcome to our page", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login with your account details")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Enter your Email Id") }
        )
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(15.dp))


        val isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isValidPassword = password.isNotEmpty()

        Button(
            onClick = {
                if (isValidEmail && isValidPassword) {
                    val firstName = email.substringBefore("@")
                    navController.navigate("HomeScreen/$firstName")
                } else {
                    errorMessage = "Please enter valid email & password"
                }
            },
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(15.dp))

        TextButton(onClick = { /* Handle forgot password */ }) {
            Text(text = "Forgot password?")
        }

        Text(text = "or Sign in with")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
                        context.startActivity(intent)
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.goog),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {

                    }
            )
            Image(
                painter = painterResource(id = R.drawable.instagrm),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
