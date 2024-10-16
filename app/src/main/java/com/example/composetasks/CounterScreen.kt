package com.example.composetasks

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    // Collect the latest value from StateFlow
    val counterValue by viewModel.counter.collectAsState()

    // UI
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Counter Value: $counterValue", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.incrementCounter() }) {
            Text(text = "Increment Counter")
        }
    }
}
