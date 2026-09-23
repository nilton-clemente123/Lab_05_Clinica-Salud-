package com.clemente.lab_05_clinica_salud.Models

data class Paciente(
    val nombre: String,
    val rol: String,
    val email: String,
    val telefono: String,
    val dni: String,
    val fechaNacimiento: String,
    val grupoSanguineo: String
)

val paciente = Paciente(
    nombre = "Nilton Clemente",
    rol = "Paciente",
    email = "Nilton.Clemente@tecsup.edu.pe",
    telefono = "+51 999 888 777",
    dni = "12345678",
    fechaNacimiento = "15/03/1990",
    grupoSanguineo = "O+"
)
