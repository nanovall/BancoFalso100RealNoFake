package com.example.bancofalso123_100realnofake

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun PantallaComprobante(navController: NavController) {
    val monto = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<String>("monto") ?: "0.00"

    val fecha = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<String>("fecha") ?: "-"


//ACA VA EL FONDO
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondodinero),
            contentDescription = "XD",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


//ACA VAN LOS DATOS DEL COMPROBANTE

        Column(
            modifier = Modifier
                .align(Alignment.Center).
                background(Color.White, shape = RoundedCornerShape(15.dp)).
                padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Retiro de dinero exitoso", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(12.dp))
            Text("Monto retirado: $$monto", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(12.dp))
            Text("Fecha: $fecha", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(24.dp))
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter).
                padding(bottom = 50.dp).
                background(Color.White, shape = RoundedCornerShape(15.dp)).
                padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Button(
                onClick = {
                    navController.navigate("1")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Volver", fontSize = 16.sp,)
            }
        }
    }
}








@Preview(showBackground = true)
@Composable
fun PantallComprobantePreview() {
    PantallaComprobante(navController = rememberNavController())
}