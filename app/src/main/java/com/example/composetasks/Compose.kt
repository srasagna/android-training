package com.example.composetasks

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleTodoListPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Simple Todo List", style = androidx.compose.ui.text.TextStyle.Default)

        Spacer(modifier = Modifier.height(16.dp))

        TaskInputSection()
    }
}

@Composable
fun TaskInputSection() {
    var taskText by remember { mutableStateOf("") }
    val taskList = remember { mutableStateListOf<String>() }
    var warningMessage by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = taskText,
            onValueChange = {
                taskText = it

                warningMessage = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Enter a task") },
            isError = warningMessage.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (taskText.isNotEmpty()) {
                taskList.add(taskText)
                taskText = ""
            } else {
                warningMessage = "Please enter a task."
            }
        }) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (warningMessage.isNotEmpty()) {
            Text(
                text = warningMessage,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TaskListSection(taskList = taskList)
    }
}

@Composable
fun TaskListSection(taskList: List<String>) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        taskList.forEach { task ->
            Text(text = task)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSimpleTodoListPage() {
    SimpleTodoListPage()
}
