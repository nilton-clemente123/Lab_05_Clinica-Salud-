package com.clemente.lab_05_clinica_salud.Models

import androidx.compose.runtime.mutableStateListOf

data class Cita(
    val id: Int,
    val medico: String,
    val fecha: String,
    val hora: String,
    val estado: String
)

val citas = mutableStateListOf<Cita>()

private var contadorId = 0

fun agendarCita(medico: String, fecha: String, hora: String): Cita {
    val cita = Cita(
        id = ++contadorId,
        medico = medico,
        fecha = fecha,
        hora = hora,
        estado = "Confirmada"
    )
    citas.add(cita)
    return cita
}

fun cancelarCita(id: Int) {
    val index = citas.indexOfFirst { it.id == id }
    if (index != -1) {
        citas[index] = citas[index].copy(estado = "Cancelada")
    }
}