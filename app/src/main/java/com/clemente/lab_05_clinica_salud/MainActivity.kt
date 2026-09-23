package com.clemente.lab_05_clinica_salud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clemente.lab_05_clinica_salud.Navigation.AppNavigation
import com.clemente.lab_05_clinica_salud.Screens.InicioScreen
import com.clemente.lab_05_clinica_salud.ui.theme.Lab_05_clinica_saludTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_05_clinica_saludTheme {
                AppNavigation()
            }
        }
    }
}

