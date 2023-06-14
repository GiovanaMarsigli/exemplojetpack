package com.example.noteapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MaterialTheme {
            NoteApp()
        }
    }
}

fun application(function: () -> Unit): Any {
    TODO("Not yet implemented")
}

@Composable
fun NoteApp() {
    var noteText by mutableStateOf("")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bloco de Notas") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = noteText,
                    onValueChange = { noteText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    textStyle = MaterialTheme.typography.body1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    ),
                    maxLines = Int.MAX_VALUE,
                    singleLine = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { noteText = "" },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Limpar")
                }
            }
        }
    )
}
