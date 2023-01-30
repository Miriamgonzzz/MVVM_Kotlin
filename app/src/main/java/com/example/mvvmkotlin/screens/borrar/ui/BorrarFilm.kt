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
import com.example.mvvmkotlin.data.Borrar
import com.example.mvvmkotlin.viewModel.ViewModel

@Composable
fun BorrarFilm(navController: NavHostController, ViewModel: ViewModel) {

    val codigo: State<String> = ViewModel.codigo.observeAsState(initial = "")

    Cabezera(navController, image = R.drawable.borrar)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 185.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .verticalScroll(rememberScrollState()),

    ) {
        Spacer(modifier = Modifier.size(10.dp))

        Texto(
            texto = "Eliminar pelicula"
        )

        Spacer(modifier = Modifier.size(10.dp))

        TextoFild(texto = "Introduce el codigo a borrar",ViewModel, value = codigo as MutableState<String>)

        Spacer(modifier = Modifier.size(5.dp))

        Borrar(codigo = codigo.value)
    }
}