package com.example.guardboxaplicattion.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.guardboxaplicattion.R
import com.example.guardboxaplicattion.model.Locker
import com.example.guardboxaplicattion.ui.components.sortLockers
@Composable
fun LockerListScreen(lockers: List<Locker>, onLockerClick: (Locker) -> Unit) {
    val sortedLockers = sortLockers(lockers)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(sortedLockers) { locker ->
            LockerItem(locker, onLockerClick)
        }
    }
}

@Composable
fun LockerItem(locker: Locker, onLockerClick: (Locker) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del casillero
        Image(
            painter = painterResource(id = R.drawable.casillero_3577886),
            contentDescription = locker.name,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Botón de reserva
        Button(
            onClick = { onLockerClick(locker) },
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            )
        ) {
            Text("Reservar ${locker.name}")
        }
    }
}