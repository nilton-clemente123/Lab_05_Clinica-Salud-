package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.lab_05_clinica_salud.Models.paciente

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilPacienteScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Perfil del paciente")
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
                .padding(16.dp)
        ) {

            Text(text = paciente.nombre)

            Text(text = paciente.rol)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Email: ${paciente.email}")

            Text(text = "Teléfono: ${paciente.telefono}")

            Text(text = "DNI: ${paciente.dni}")

            Text(text = "Fecha de nacimiento: ${paciente.fechaNacimiento}")

            Text(text = "Grupo sanguíneo: ${paciente.grupoSanguineo}")
        }
    }
}
