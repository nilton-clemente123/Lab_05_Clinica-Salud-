package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clemente.lab_05_clinica_salud.Models.Medico


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilMedicoScreen(
    medico: Medico,
    onAgendarClick: (Medico) -> Unit

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text= "Perfil del médico",
                        color = Color(255, 255, 255, 255))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(110, 15, 124, 255)
                )
            )
        },

        bottomBar = {
            Button(
                onClick = {
                    onAgendarClick(medico)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Agendar cita")
            }
        }


    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Foto del médico",
                    tint = Color(0xFF9E9E9E),
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = medico.nombre
            )

            Text(
                text = medico.especialidad
            )

            Text(
                text = "⭐ ${medico.calificacion}"
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

        }
    }
}