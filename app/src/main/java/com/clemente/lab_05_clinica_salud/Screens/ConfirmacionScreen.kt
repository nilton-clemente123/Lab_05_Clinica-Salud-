package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clemente.lab_05_clinica_salud.Models.Medico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmacionScreen(
    medico: Medico,
    fecha: String,
    hora: String,
    onVolverInicio: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Confirmación de cita")
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF4CAF50)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Cita confirmada",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )

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