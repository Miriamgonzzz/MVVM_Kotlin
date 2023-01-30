package com.example.conexionbasedatos.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.common.Cabezera
import com.example.mvvmkotlin.common.Texto
import com.example.mvvmkotlin.data.Informe
import com.example.mvvmkotlin.viewModel.ViewModel

@Composable
fun InformeFilm(navController: NavHostController, ViewModel: ViewModel) {

    Cabezera(navController, image = R.drawable.peliculas)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(10.dp))

        Texto(
            texto = "Seleccionar todos los datos en Cloud FireStore"

        )

        Spacer(modifier = Modifier.size(10.dp))

        Informe()
    }
}