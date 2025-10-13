package com.example.bancofalso123_100realnofake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bancofalso123_100realnofake.ui.theme.BancoFalso123100RealNoFakeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BancoFalso123100RealNoFakeTheme {

                val navController = rememberNavController()

                NavHost(navController, startDestination = "1") {
                    composable ( "1" ) { Home(navController) }
                    composable ( "2" ) { PantallaComprobante(navController) }
                }

            }
        }
    }
}