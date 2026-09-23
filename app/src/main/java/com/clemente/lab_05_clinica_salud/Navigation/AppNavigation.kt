package com.clemente.lab_05_clinica_salud.Navigation

import android.R.attr.type
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch
import com.clemente.lab_05_clinica_salud.Models.Cita
import com.clemente.lab_05_clinica_salud.Models.citas
import com.clemente.lab_05_clinica_salud.Models.medicos
import com.clemente.lab_05_clinica_salud.Screens.AgendarCitaScreen
import com.clemente.lab_05_clinica_salud.Screens.ConfirmacionScreen
import com.clemente.lab_05_clinica_salud.Screens.HistorialMedicoScreen
import com.clemente.lab_05_clinica_salud.Screens.InicioScreen
import com.clemente.lab_05_clinica_salud.Screens.MisCitasScreen
import com.clemente.lab_05_clinica_salud.Screens.PerfilPacienteScreen
import com.clemente.lab_05_clinica_salud.Screens.PerfilMedicoScreen



@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Usuario",
                        modifier = Modifier.size(48.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = "Clemente Nilton"
                        )

                        Text(
                            text = "Paciente"
                        )
                    }
                }



                NavigationDrawerItem(
                    label = {
                        Text("Inicio")
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate("inicio")
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text("Mis citas")
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate("mis_citas")
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text("Historial médico")
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate("historial")
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text("Perfil")
                    },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate("perfil_usuario")
                    }
                )
            }
        }
    ) {
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
                    },
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            }

            composable(
                route = "mis_citas"
            ) {
                MisCitasScreen(
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = "historial"
            ) {
                HistorialMedicoScreen(
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = "perfil_usuario"
            ) {
                PerfilPacienteScreen(
                    onBackClick = {
                        navController.popBackStack()
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

                PerfilMedicoScreen(
                    medico = medico,
                    onAgendarClick = {
                        navController.navigate("agendar/${medicoId}")
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )

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
                        citas.add(
                            Cita(
                                medico = medico.nombre,
                                fecha = fecha,
                                hora = hora,
                                estado = "Confirmada"
                            )
                        )
                        navController.navigate(
                            "confirmacion/$medicoId/${Uri.encode(fecha)}/${Uri.encode(hora)}"
                        )
                    },
                    onBackClick = {
                        navController.popBackStack()
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
                    onVolverInicio = {
                        navController.navigate("mis_citas")
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }


}