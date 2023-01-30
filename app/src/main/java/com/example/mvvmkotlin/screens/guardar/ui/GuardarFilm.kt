package com.example.mvvmkotlin.guardar.ui

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
import com.example.mvvmkotlin.common.TextoFild
import com.example.mvvmkotlin.data.GuardarDatos
import androidx.compose.runtime.livedata.observeAsState
import com.example.mvvmkotlin.viewModel.ViewModel


@Composable
fun GuardarFilm(navController: NavHostController, ViewModel: ViewModel) {

    val codigo: State<String> = ViewModel.codigo.observeAsState(initial = "")
    val nombre_film: State<String> = ViewModel.nombre.observeAsState (initial = "")
    val director_film: State<String> = ViewModel.director.observeAsState (initial = "")
    val actores_film: State<String> = ViewModel.actores.observeAsState (initial = "")
    val fecha_film: State<String> =ViewModel.fecha.observeAsState (initial = "")
    val descripcion_film: State<String> = ViewModel.descripcion.observeAsState (initial = "")
    val isButtonEnable: State<Boolean> = ViewModel.isButtonEnable.observeAsState (initial = true)

    Cabezera(navController, image = R.drawable.guardar)

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

        TextoFild( texto = "Introduce el Codigo", ViewModel, value = codigo as MutableState<String>)

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild( texto = "Introduce el nombre", ViewModel, value = nombre_film as MutableState<String>)

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild(texto = "Indroduce el direcctor", ViewModel, value = director_film as MutableState<String>)

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild(texto = "Introduce a los actores", ViewModel, value = actores_film as MutableState<String>)

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild(texto = "Introduce la fecha", ViewModel, value = fecha_film as MutableState<String>)

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild(texto = "Introduce la descripcion", ViewModel, value = descripcion_film as MutableState<String>)

        Spacer(modifier = Modifier.size(10.dp))

        GuardarDatos(
            codigo = codigo.value,
            nombre_film = nombre_film.value,
            director_film = director_film.value,
            actores_film = actores_film.value,
            fecha_film = fecha_film.value,
            descripcion_film = descripcion_film.value,
            isButtonEnable = isButtonEnable.value,

        )
    }
}

