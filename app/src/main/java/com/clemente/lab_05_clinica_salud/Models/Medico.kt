package com.clemente.lab_05_clinica_salud.Models

data class Medico(
    val id: Int,
    val nombre: String,
    val especialidad: String,
    val calificacion: Double,
    val descripcion: String
)

val medicos = listOf(
    Medico(
        id = 1,
        nombre = "Dra. Ana Torres",
        especialidad = "Cardiología",
        calificacion = 4.9,
        descripcion = "DESCRIPCION DE PRUEBA"
    ),
    Medico(
        id = 2,
        nombre = "Dr. Luis Vega",
        especialidad = "Pediatría",
        calificacion = 4.7,
        descripcion = "DESCRIPCION DE PRUEBA"
    ),
    Medico(
        id = 3,
        nombre = "Dra. Rosa Díaz",
        especialidad = "Dermatología",
        calificacion = 4.8,
        descripcion = "DESCRIPCION DE PRUEBA"
    )
)