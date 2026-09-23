package com.clemente.lab_05_clinica_salud.Screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
fun AgendarCitaScreen(
    medico: Medico,
    onConfirmarClick: (String, String) -> Unit,
    onBackClick: () -> Unit
) {

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
                    Text("Agendar Cita")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        },

        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        onConfirmarClick(
                            fechaSeleccionada ?: "",
                            horaSeleccionada ?: ""
                        )
                    },
                    enabled = fechaSeleccionada != null && horaSeleccionada != null
                ) {
                    Text("Confirmar cita")
                }
            }
        }
    ) { PaddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Selecciona Fecha")

            LazyRow {
                items(fechas) { fecha ->

                    Button(
                        onClick = {
                            fechaSeleccionada = fecha
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (fechaSeleccionada == fecha) Color(110, 15, 124, 255) else Color(0xFFE1BEE7),
                            contentColor = if (fechaSeleccionada == fecha) Color.White else Color(0xFF4A148C)
                        )
                    ) {
                        Text(
                            text = fecha
                        )
                    }
                }
            }


            Spacer(Modifier.height(20.dp))

            Text("Selecciona Hora")

            LazyRow {
                items(horarios) { horario ->

                    Button(
                        onClick = {
                            horaSeleccionada = horario
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (horaSeleccionada == horario) Color(110, 15, 124, 255) else Color(0xFFE1BEE7),
                            contentColor = if (horaSeleccionada == horario) Color.White else Color(0xFF4A148C)
                        )
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
