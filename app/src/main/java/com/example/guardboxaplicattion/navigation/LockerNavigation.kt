package com.example.guardboxaplicattion.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guardboxaplicattion.model.Locker
import com.example.guardboxaplicattion.ui.screens.LockerListScreen
import com.example.guardboxaplicattion.ui.screens.LockerDetailScreen
import com.example.guardboxaplicattion.ui.screens.ConfirmationScreen

@Composable
fun LockerApp() {
    val navController = rememberNavController()
    val lockers = remember { mutableStateListOf(
        Locker("Locker 1"),
        Locker("Locker 2"),
        Locker("Locker 3"),
        Locker("Casillero Suizo"),
        Locker("Casillero Norte"),
        Locker("Casillero Oeste"),

    )}

    NavHost(navController = navController, startDestination = "lockerList") {
        composable("lockerList") {
            LockerListScreen(lockers) { locker ->
                navController.navigate("lockerDetail/${locker.name}")
            }
        }
        composable("lockerDetail/{lockerName}") { backStackEntry ->
            val lockerName = backStackEntry.arguments?.getString("lockerName") ?: return@composable
            val locker = lockers.find { it.name == lockerName } ?: return@composable
            LockerDetailScreen(locker) {
                navController.navigate("confirmationScreen/${locker.name}")
            }
        }
        composable("confirmationScreen/{lockerName}") { backStackEntry ->
            val lockerName = backStackEntry.arguments?.getString("lockerName") ?: return@composable
            val locker = lockers.find { it.name == lockerName } ?: return@composable
            ConfirmationScreen(
                locker = locker,
                onConfirm = {
                    locker.isReserved = true
                    navController.navigate("lockerDetail/${locker.name}") {
                        popUpTo("lockerList") { inclusive = false }
                    }
                }
            )
        }
    }
}