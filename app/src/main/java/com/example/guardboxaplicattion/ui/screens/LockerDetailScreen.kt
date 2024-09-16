package com.example.guardboxaplicattion.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guardboxaplicattion.model.Locker
import com.example.guardboxaplicattion.ui.components.LockerStatusSwitch

@Composable
fun LockerDetailScreen(locker: Locker, onReserveClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(locker.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        if (locker.isReserved) {
            LockerStatusSwitch(locker)
        } else {
            Button(onClick = onReserveClick) {
                Text("Reservar")
            }
        }
    }
}