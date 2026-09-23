package com.clemente.lab_05_clinica_salud.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clemente.lab_05_clinica_salud.Components.MedicoCard
import com.clemente.lab_05_clinica_salud.Models.Medico
import com.clemente.lab_05_clinica_salud.Models.especialidades
import com.clemente.lab_05_clinica_salud.Models.medicos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(
    onMedicoClick: (Medico) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(

                title = {

                    Column() {
                        Text("Clinica Salud+")
                        Text(text = "Hola clemente",
                            fontSize = 15.sp)
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


            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(especialidades) { especialidad ->
                    AssistChip(
                        onClick = { },
                        label = {
                            Text(especialidad)
                        }
                    )
                }
            }

            Text(
                text = "Médicos disponibles"
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(medicos) { medico ->
                    MedicoCard(
                        medico = medico,
                        onClick = {
                            onMedicoClick(medico)
                        }
                    )
                }
            }
        }
    }
}