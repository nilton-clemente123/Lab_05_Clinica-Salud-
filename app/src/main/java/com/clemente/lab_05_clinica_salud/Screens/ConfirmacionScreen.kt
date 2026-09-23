package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.lab_05_clinica_salud.Models.Medico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmacionScreen(
    medico: Medico,
    fecha: String,
    hora: String,
    onVolverInicio: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Confirmación de cita")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text("Cita agendada")

            Text(
                text = "${medico.nombre}"
            )

            Text(
                text = "${medico.especialidad}"
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Row() {
                Text(
                    text = "$fecha"
                )

                Text(
                    text = "$hora"
                )
            }



            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Button(
                onClick = { onVolverInicio() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver mis citas")
            }
        }
    }
}