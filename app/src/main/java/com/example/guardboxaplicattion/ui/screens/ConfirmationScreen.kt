package com.example.guardboxaplicattion.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.guardboxaplicattion.model.Locker

@Composable
fun ConfirmationScreen(locker: Locker, onConfirm: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFF4CAF50)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¡Reserva confirmada para ${locker.name}!")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onConfirm) {
            Text("Volver al casillero")
        }
    }
}