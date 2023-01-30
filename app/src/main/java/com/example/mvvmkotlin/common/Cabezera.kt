package com.example.mvvmkotlin.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvvmkotlin.R


@Composable
fun Cabezera(navController: NavHostController, image:Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFFFE4B4), Color(0xFF410202))))
    )
    {

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

    ) {
        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = "Fondo",
            contentScale = ContentScale.FillBounds
        )
    }
    Boton(navController, Router = "MenuInicial", Text = "Menu")
    Image(
        painter = painterResource(image),
        contentDescription = "Encabezado",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 133.dp)
    )

}