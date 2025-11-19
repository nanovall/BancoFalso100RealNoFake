package com.example.bancofalso123_100realnofake

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Deposito(navController: NavController,dineroViewModel: DineroViewModel) {
    var depositarplata by rememberSaveable { mutableStateOf("") }
    val saldo by dineroViewModel.saldoactual



    //ACA PONEMOS EL FONDO
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


        //ACA PONEMOS EL DINERO ACTUAL
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter).
                padding(top = 100.dp).
                background(Color.White, shape = RoundedCornerShape(15.dp)).
                padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            Text(text = "Dinero Actual", fontSize = 17.sp)
            Text(
                text = "$${String.format("%.2f", saldo)}",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }




        //ACA PONEMOS EL DINERO A DEPOSITAR
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.White, shape = RoundedCornerShape(15.dp))
                .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Dinero a Depositar?",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = depositarplata,
                onValueChange = { depositarplata = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color(0xFFEEEEEE),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedTextColor = Color.Black,
                    )
            )
        }

        //EL BOTON DE Depositar
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 200.dp)
                .background(Color.White, shape = RoundedCornerShape(15.dp))
                .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Button(
                onClick = {
                    val montoadepositar = depositarplata.toDoubleOrNull()
                    if (montoadepositar != null && montoadepositar > 0) {

                        dineroViewModel.depositarDinero(montoadepositar)

                        val montoreti = String.format("%.2f", montoadepositar)

                        depositarplata = ""
                    } else {
                        "No es valido"
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Depositar", fontSize = 30.sp)
            }
        }

        //Boton para ir a Retirar
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
                .background(Color.White, shape = RoundedCornerShape(15.dp))
                .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = {
                    navController.navigate("2")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Retirar", fontSize = 16.sp,)
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun DepositoPreview() {
    Deposito (navController = rememberNavController(),
        dineroViewModel = viewModel()
    )
}