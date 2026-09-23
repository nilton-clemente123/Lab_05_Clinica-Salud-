package com.clemente.lab_05_clinica_salud.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.lab_05_clinica_salud.Models.Medico

@Composable
fun MedicoCard(
    medico: Medico,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable{onClick()}
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = medico.nombre
            )

            Text(
                text = medico.especialidad
            )

            Text(
                text = "⭐ ${medico.calificacion}"
            )
        }
    }
}
