package com.example.composetasks


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    var message by remember { mutableStateOf("Hello, World!") }
    var textFieldInput by remember { mutableStateOf("") }
    var isSwitchOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageDisplay(message)

        Spacer(modifier = Modifier.height(16.dp))

        InputField(textFieldInput) {
            textFieldInput = it
            message = it
        }

        Spacer(modifier = Modifier.height(16.dp))

        ChangeMessageButton(onClick = { message = "Message changed!" })

        Spacer(modifier = Modifier.height(32.dp))

        SwitchWithLabel(isSwitchOn) { isSwitchOn = it }

        Spacer(modifier = Modifier.height(16.dp))

        ToggleMessageDisplay(isSwitchOn)
    }
}

@Composable
fun MessageDisplay(message: String) {
    Text(
        text = message,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun InputField(text: String, onTextChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text("Enter message") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ChangeMessageButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Change Message")
    }
}

@Composable
fun SwitchWithLabel(isOn: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = if (isOn) "Switch is ON" else "Switch is OFF")
        Spacer(modifier = Modifier.width(8.dp))
        Switch(checked = isOn, onCheckedChange = onSwitchChange)
    }
}

@Composable
fun ToggleMessageDisplay(isSwitchOn: Boolean) {
    Text(
        text = if (isSwitchOn) "The switch is ON!" else "The switch is OFF!",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPrevie() {

        MainScreen()

}
