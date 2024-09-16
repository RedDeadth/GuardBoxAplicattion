package com.example.guardboxaplicattion.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guardboxaplicattion.model.Locker

@Composable
fun ConfirmationScreen(locker: Locker, onConfirm: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¡Reserva confirmada para ${locker.name}!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onConfirm) {
            Text("Volver al casillero")
        }
    }
}