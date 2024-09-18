package com.example.guardboxaplicattion.ui.components

import com.example.guardboxaplicattion.model.Locker

fun sortLockers(lockers: List<Locker>): List<Locker> {
    return lockers.sortedByDescending { it.isReserved }
}
