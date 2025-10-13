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
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Home(navController: NavController) {
    var extraerplata by rememberSaveable { mutableStateOf("") }
    var saldoactual by rememberSaveable { mutableStateOf(10000.0) }
    var fecharetirada by remember { mutableStateOf("") }
    var montoretirado by remember { mutableStateOf(0.0) }

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
                text = "$${String.format("%.2f", saldoactual)}",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }

        
//ACA PONEMOS EL DINERO A RETIRAR

        Column(
            modifier = Modifier
                .align(Alignment.Center).
                background(Color.White, shape = RoundedCornerShape(15.dp)).
                padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Dinero a Retirar?",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
           )
            TextField(
                value = extraerplata,
                onValueChange = { extraerplata = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color(0xFFEEEEEE),
                    focusedContainerColor = Color(0xFFF5F5F5),
                    focusedTextColor = Color.Black,

                )
            )
        }

//ACA EL BOTON DE RETIRAR

        Column(
            modifier = Modifier
            .align(Alignment.BottomCenter).
            padding(bottom = 200.dp).
            background(Color.White, shape = RoundedCornerShape(15.dp)).
            padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Button(
                onClick = {
                    val montoaretirar = extraerplata.toDoubleOrNull()
                    if (montoaretirar != null && montoaretirar > 0 && montoaretirar <= saldoactual) {

                        saldoactual -= montoaretirar

                    val montoreti = String.format("%.2f", montoaretirar)
                    val fechareti = java.time.LocalDateTime.now().
                    format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))


                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("monto", montoreti)

                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("fecha", fechareti)

                        extraerplata = ""
                        navController.navigate("2")
                    } else {
                    }
                },
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Retirar", fontSize = 30.sp,)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home (navController = rememberNavController())
}