package com.clemente.lab_05_clinica_salud.Screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.clemente.lab_05_clinica_salud.Models.Medico

val fechas = listOf(
    "24 Sep",
    "25 Sep",
    "26 Sep"
)

val horarios = listOf(
    "09:00",
    "10:00",
    "11:00"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendarCitaScreen(medico: Medico) {

    var fechaSeleccionada by remember {
        mutableStateOf<String?>(null)
    }

    var horaSeleccionada by remember {
        mutableStateOf<String?>(null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("AgendarCita")
                }
            )
        },

        bottomBar = {
            Button(
                onClick = {

                }
            ) {
                Text("Confirmar cita")
            }
        }
    ) { PaddingValues ->

        Column(
            modifier = Modifier.padding(PaddingValues)
        ) {

            Text("Selecciona Fecha")

            LazyRow {
                items(fechas) { fecha ->

                    Button(
                        onClick = {
                            fechaSeleccionada = fecha
                        }
                    ) {
                        Text(
                            text = fecha
                        )
                    }
                }
            }

            Text("Selecciona Hora")

            LazyRow {
                items(horarios) { horario ->

                    Button(
                        onClick = {
                            horaSeleccionada = horario
                        }
                    ) {
                        Text(
                            text = horario
                        )
                    }
                }
            }
        }
    }
}
