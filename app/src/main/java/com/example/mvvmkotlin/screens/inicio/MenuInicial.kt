package com.example.conexionbasedatos.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.common.Boton

@Composable
fun MenuInicial(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Brush.verticalGradient(listOf(Color(0xFFFFE4B4), Color(0xFF410202))))) {

    }
    Card(
    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp),
    modifier = Modifier
        .height(130.dp)
        .fillMaxWidth()
        .border(
            BorderStroke(5.dp, Color(0xFF300000)),
            RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
        )

){
    Image(
        painter = painterResource(R.drawable.fondo),
        contentDescription ="Fondo",
        contentScale = ContentScale.FillBounds
    )
}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(270.dp)
            )

            //Spacer(modifier = Modifier.padding(top=100.dp ))

            Boton(navController, Router = "GuardarFilm", Text = "Alta")

            Spacer(modifier = Modifier.size(15.dp))

            Boton(navController, Router = "ModificarFilm", Text = "Modificar")

            Spacer(modifier = Modifier.size(15.dp))

            Boton(navController, Router = "BorrarFilm", Text = "Borrar")

            Spacer(modifier = Modifier.size(15.dp))

            Boton(navController, Router = "ConsultarFilm", Text = "Consultar")

            Spacer(modifier = Modifier.size(15.dp))

            Boton(navController, Router = "InformeFilm", Text = "Informe general")

        }

}