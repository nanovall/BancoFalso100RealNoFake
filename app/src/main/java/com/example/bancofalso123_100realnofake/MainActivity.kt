package com.example.bancofalso123_100realnofake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bancofalso123_100realnofake.DineroViewModel
import com.example.bancofalso123_100realnofake.ui.theme.BancoFalso123100RealNoFakeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BancoFalso123100RealNoFakeTheme {

                val navController = rememberNavController()

                val dineroViewModel: DineroViewModel = viewModel()


                NavHost(navController, startDestination = "2") {
                    composable(route = "1") {
                        Deposito(
                            navController = navController,
                            dineroViewModel = dineroViewModel
                        )
                    }
                    composable("2") {
                        Home(
                            navController = navController,
                            dineroViewModel = dineroViewModel
                        )
                    }
                    composable("3") {
                        PantallaComprobante(
                            navController = navController,
                            dineroViewModel = dineroViewModel
                        )
                    }
                }
            }
        }
    }
}