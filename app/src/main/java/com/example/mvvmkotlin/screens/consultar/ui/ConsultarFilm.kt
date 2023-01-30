package com.example.conexionbasedatos.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.common.Cabezera
import com.example.mvvmkotlin.common.Texto
import com.example.mvvmkotlin.common.TextoFild
import com.example.mvvmkotlin.data.Buscar
import com.example.mvvmkotlin.viewModel.ViewModel


@Composable
fun ConsultarFilm(navController: NavHostController,ViewModel: ViewModel) {

    Cabezera(navController, image = R.drawable.busqueda)
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 185.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .verticalScroll(rememberScrollState())

    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Texto(
            texto = "Búsqueda de peliculas "
        )

        Spacer(modifier = Modifier.size(20.dp))

        val nombre_film: State<String> = ViewModel.nombre.observeAsState(initial = "")

        TextoFild(texto = "Introduce el nombre a consultar", ViewModel, value = nombre_film as MutableState<String>)

        Spacer(modifier = Modifier.size(5.dp))

        Buscar(codigo_busqueda = nombre_film.value)

    }

}