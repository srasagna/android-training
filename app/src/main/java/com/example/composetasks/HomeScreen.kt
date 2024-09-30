package com.example.composetasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(firstName: String){
    Column{

        Text(text = " Welcome to Home Screen, $firstName")

    }

}