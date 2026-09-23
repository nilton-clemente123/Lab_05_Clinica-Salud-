package com.clemente.lab_05_clinica_salud.Models

import androidx.compose.runtime.mutableStateListOf

data class Cita(
    val medico: String,
    val fecha: String,
    val hora: String,
    val estado: String
)

val citas = mutableStateListOf<Cita>()