package com.clemente.lab_05_clinica_salud.Navigation

import android.R.attr.type
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.clemente.lab_05_clinica_salud.Models.medicos
import com.clemente.lab_05_clinica_salud.Screens.AgendarCitaScreen
import com.clemente.lab_05_clinica_salud.Screens.ConfirmacionScreen
import com.clemente.lab_05_clinica_salud.Screens.InicioScreen
import com.clemente.lab_05_clinica_salud.Screens.PerfilMedicoScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        composable(
            route = "inicio"
        ) {
            InicioScreen(
                onMedicoClick = { medico ->
                    navController.navigate("perfil/${medico.id}")
                }
            )
        }

        composable(
            route = "perfil/{medicoId}",
            arguments = listOf(
                navArgument("medicoId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val medicoId =
                backStackEntry.arguments?.getInt("medicoId") ?: 0

            val medico = medicos.first { it.id == medicoId }

            PerfilMedicoScreen(medico = medico, onAgendarClick = {
                navController.navigate("agendar/${medicoId}")
            })

        }

        composable(
            route = "agendar/{medicoId}",
            arguments = listOf(
                navArgument("medicoId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val medicoId =
                backStackEntry.arguments?.getInt("medicoId") ?: 0

            val medico = medicos.first { it.id == medicoId }

            AgendarCitaScreen(
                medico = medico,
                onConfirmarClick = { fecha, hora ->
                    navController.navigate(
                        "confirmacion/$medicoId/${Uri.encode(fecha)}/${Uri.encode(hora)}"
                    )
                }
            )
        }

        composable(
            route = "confirmacion/{medicoId}/{fecha}/{hora}",
            arguments = listOf(
                navArgument("medicoId") {
                    type = NavType.IntType
                },
                navArgument("fecha") {
                    type = NavType.StringType
                },
                navArgument("hora") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val medicoId =
                backStackEntry.arguments?.getInt("medicoId") ?: 0

            val fecha =
                backStackEntry.arguments?.getString("fecha") ?: ""

            val hora =
                backStackEntry.arguments?.getString("hora") ?: ""

            val medico = medicos.first { it.id == medicoId }

            ConfirmacionScreen(
                medico = medico,
                fecha = fecha,
                hora = hora,
                onVolverInicio = {}
            )
        }
    }
}