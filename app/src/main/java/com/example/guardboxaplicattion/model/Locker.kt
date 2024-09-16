package com.example.guardboxaplicattion.model

data class Locker(val name: String, var isReserved: Boolean = false, var isOpen: Boolean = false)