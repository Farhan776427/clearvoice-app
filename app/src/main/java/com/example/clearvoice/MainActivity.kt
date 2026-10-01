package com.example.clearvoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClearVoiceScreen()
                }
            }
        }
    }
}

@Composable
fun ClearVoiceScreen() {
    var isEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "ClearVoice AI",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = if (isEnabled) "Noise Cancellation: ON" else "Noise Cancellation: OFF",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { isEnabled = !isEnabled },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isEnabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
            )
        ) {
            Text(if (isEnabled) "TURN OFF" else "TURN ON")
        }
    }
}
