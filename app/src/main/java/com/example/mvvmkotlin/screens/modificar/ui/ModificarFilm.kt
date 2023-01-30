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
import com.example.mvvmkotlin.data.Modificar
import com.example.mvvmkotlin.viewModel.ViewModel

@Composable
fun ModificarFilm(navController: NavHostController, ViewModel: ViewModel) {

    val codigo: State<String> = ViewModel.codigo.observeAsState(initial = "")
    val nombre_film: State<String> = ViewModel.nombre.observeAsState (initial = "")
    val director_film: State<String> = ViewModel.director.observeAsState (initial = "")
    val actores_film: State<String> = ViewModel.director.observeAsState (initial = "")
    val fecha_film: State<String> = ViewModel.director.observeAsState (initial = "")
    val descripcion_film: State<String> = ViewModel.director.observeAsState (initial = "")
    val isButtonEnable:Boolean by ViewModel.isButtonEnable.observeAsState (initial = false)

    Cabezera(navController, image = R.drawable.modificar)

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
                texto = "Modificar Pelicula"
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextoFild(texto = "Introduce el codigo", ViewModel, value =codigo as MutableState<String>)

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(   texto = "Introduce el nombre", ViewModel, value = nombre_film as MutableState<String>)

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(texto = "Introduce el director", ViewModel, value = director_film as MutableState<String>)

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild( texto = "Introduce los actores", ViewModel, value = actores_film as MutableState<String>)

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild (texto = "Introduce la fecha", ViewModel,value=fecha_film as MutableState<String>)

            Spacer(modifier = Modifier.size(5.dp))

            TextoFild(texto = "Introduce la descripcion", ViewModel, value = descripcion_film as MutableState<String>)

            Spacer(modifier = Modifier.size(10.dp))

            Modificar(
                codigo = codigo.value,
                nombre_film = nombre_film.value,
                director_film = director_film.value,
                actores_film = actores_film.value,
                fecha_film = fecha_film.value,
                descripcion_film = descripcion_film.value
            )
        }
}