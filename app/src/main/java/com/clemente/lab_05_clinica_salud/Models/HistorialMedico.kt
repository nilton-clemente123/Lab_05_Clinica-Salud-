package com.clemente.lab_05_clinica_salud.Models

data class HistorialMedico(
    val fecha: String,
    val titulo: String,
    val descripcion: String,
    val medico: String
)

val historialMedico = listOf(
    HistorialMedico(
        fecha = "20/09/2026",
        titulo = "Consulta general",
        descripcion = "Revisión de rutina sin hallazgos relevantes.",
        medico = "Dra. Ana Torres"
    ),
    HistorialMedico(
        fecha = "05/08/2026",
        titulo = "Análisis de sangre",
        descripcion = "Resultados dentro de los valores normales.",
        medico = "Dr. Luis Vega"
    ),
    HistorialMedico(
        fecha = "12/06/2026",
        titulo = "Dermatología",
        descripcion = "Tratamiento tópico para dermatitis leve.",
        medico = "Dra. Rosa Díaz"
    )
)
