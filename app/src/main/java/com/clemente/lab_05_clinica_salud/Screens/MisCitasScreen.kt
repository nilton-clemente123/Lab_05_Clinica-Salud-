package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.clemente.lab_05_clinica_salud.Models.Cita
import com.clemente.lab_05_clinica_salud.Models.citas


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisCitasScreen(
    onBackClick: () -> Unit,
    onCancelarCita: (Cita) -> Unit
) {

    var citaPendiente by remember { mutableStateOf<Cita?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Mis citas")
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
        }
    ) { paddingValues ->

        if (citas.isEmpty()) {
            Text(
                text = "No tienes citas agendadas",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(citas) { cita ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(text = cita.medico)
                                Text(text = "Fecha: ${cita.fecha}")
                                Text(text = "Hora: ${cita.hora}")
                                Text(
                                    text = cita.estado,
                                    color = if (cita.estado == "Cancelada") {
                                        Color(0xFFD32F2F)
                                    } else {
                                        Color(0xFF4CAF50)
                                    }
                                )
                            }

                            if (cita.estado != "Cancelada") {
                                IconButton(
                                    onClick = { citaPendiente = cita }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Cancelar cita",
                                        tint = Color(0xFFD32F2F)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    citaPendiente?.let { cita ->
        AlertDialog(
            onDismissRequest = { citaPendiente = null },
            title = {
                Text("Cancelar cita")
            },
            text = {
                Text(
                    "¿Seguro que deseas cancelar la cita con ${cita.medico} " +
                        "el ${cita.fecha} a las ${cita.hora}?"
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onCancelarCita(cita)
                        citaPendiente = null
                    }
                ) {
                    Text(
                        text = "Sí, cancelar",
                        color = Color(0xFFD32F2F)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { citaPendiente = null }
                ) {
                    Text("Volver")
                }
            }
        )
    }
}