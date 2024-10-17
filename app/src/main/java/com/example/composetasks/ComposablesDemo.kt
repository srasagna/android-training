package com.example.composetasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimplePageDesign() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(16.dp),
        ,horizontalAlignment = Alignment.CenterHorizontally
    ) {

        StaticHeader()

        Spacer(modifier = Modifier.height(32.dp)) // Spacer between header and content

        // Counter section (stateful and dynamic)
        CounterSection()

        Spacer(modifier = Modifier.height(32.dp)) // Spacer between sections

        // Form input section (stateful and dynamic)
        InputSection()
    }
}

@Composable
fun StaticHeader() {
    Text(
        text = "Welcome to the Simple Page",
        style = TextStyle.Default,
        color = Color.DarkGray
    )
}

@Composable
fun CounterSection() {
    // Remember the count value across recompositions
    var count by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have clicked $count times")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text(text = "Increment Counter")
        }
    }
}

@Composable
fun InputSection() {
    var inputText by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input field to take user input
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter some text") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the entered text dynamically
        Text(text = "You typed: $inputText")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSimplePageDesign() {
    SimplePageDesign()
}
