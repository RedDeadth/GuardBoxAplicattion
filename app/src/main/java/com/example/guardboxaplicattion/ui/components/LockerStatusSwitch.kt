package com.example.guardboxaplicattion.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.example.guardboxaplicattion.model.Locker

@Composable
fun LockerStatusSwitch(locker: Locker) {
    var isOpen by remember { mutableStateOf(locker.isOpen) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = if (isOpen) "Casillero Abierto" else "Casillero Cerrado")
        Switch(
            checked = isOpen,
            onCheckedChange = {
                isOpen = it
                locker.isOpen = it

            }
        )
    }
}