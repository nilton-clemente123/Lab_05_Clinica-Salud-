package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.lab_05_clinica_salud.Models.historialMedico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistorialMedicoScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Historial médico")
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(historialMedico) { registro ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = registro.titulo)
                        Text(text = registro.fecha)
                        Text(text = registro.descripcion)
                        Text(text = "Médico: ${registro.medico}")
                    }
                }
            }
        }
    }
}
