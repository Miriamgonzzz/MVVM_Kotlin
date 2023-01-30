package com.example.mvvmkotlin.data

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmkotlin.common.TextoBoton
import com.example.mvvmkotlin.common.TextoElementos
import com.example.mvvmkotlin.domain.Peliculas

@Composable
fun Informe() {

    var datos by remember { mutableStateOf("") }
    val pelicula = rememberSaveable { mutableListOf<Peliculas>() }

    datos = ""

    db.collection(nombre_coleccion)
        .get()
        .addOnSuccessListener { resultado ->
            pelicula.clear()
            for (encontrado in resultado) {
                Log.d("PRUEBA", encontrado.id)

                val aux = Peliculas(encontrado.getString("codigo") as String,encontrado.getString("nombre") as String,encontrado.getString("director") as String,encontrado.getString("actores") as String,encontrado.getString("fecha") as String,encontrado.getString("descripcion") as String)
                pelicula.add(aux)

            }

            if (datos.isEmpty()) {
                datos = "No existen datos"
            }
        }.addOnFailureListener { resultado ->
            datos = "La conexión a FireStore no se ha podido completar"
        }


    Text(
        text = datos,
        color = Color(0xFFFFFFFF),
        fontSize = 18.sp,
        textAlign = TextAlign.Center,

        )
    pelicula.forEachIndexed{ index, pelicula ->

        PeliculaItem(pelicula = pelicula)

    }

}

@Composable
fun InformeBoton(){
    var datos by remember { mutableStateOf("") }

    /*var code by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var actores by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }*/

    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {

            datos = ""
            /*code = ""
            nombre=""
            director=""
            actores=""
            fecha=""
            descripcion=""*/


            db.collection(nombre_coleccion)
                .get()
                .addOnSuccessListener { resultado ->
                    for (encontrado in resultado) {

                        datos += "Código: ${encontrado.getString("codigo")?: "No disponible"}\n"
                        datos += "Nombre ${encontrado.getString("nombre") ?: "No disponible"}\n"
                        datos += "Director: ${encontrado.getString("director")?: "No disponible"}\n"
                        datos += "Actores: ${encontrado.getString("actores")?: "No disponible"}\n"
                        datos += "Fecha: ${encontrado.getString("fecha")?: "No disponible"}\n"
                        datos += "Descripción: ${encontrado.getString("descripcion")?: "No disponible"}\n\n"

                    }

                    if (datos.isEmpty()) {
                        datos = "No existen datos"
                    }
                }.addOnFailureListener { resultado ->
                    datos = "La conexión a FireStore no se ha podido completar"
                }

        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)

    ) {

        TextoBoton(texto = "Cargar Datos")
    }

    Spacer(modifier = Modifier.size(10.dp))

    TextoElementos(texto = datos)


}


@Composable
fun PeliculaItem(pelicula: Peliculas){

    Spacer(modifier = Modifier.size(15.dp))
    Card(
        shape = RoundedCornerShape(topStart = 20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFFBE9999), Color(0xFF1F0031))),
                RoundedCornerShape(topStart = 20.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF300000)),
                RoundedCornerShape(topStart = 20.dp)
            )
    ) {
        Column() {

            Text(
                text= pelicula.codigo,
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(10.dp) ,
                color = Color(0xFFFFFDFD),
                fontSize = 20.sp, textAlign = TextAlign.Center)

            Text(
                text = pelicula.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 10.dp, end = 10.dp),
                color = Color(0xFFFFFDFD),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            Text(text ="Ditector: ${pelicula.director}",
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 10.dp, end = 10.dp) ,
                color = Color(0xFFFFFDFD),
                fontSize = 20.sp, textAlign = TextAlign.Center)

            Text(text = "Actores: ${pelicula.actores}",modifier= Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 10.dp, end = 12.dp) ,color = Color(0xFFFFFDFD), fontSize = 20.sp, textAlign = TextAlign.Center)

            Text(text = "Fecha: ${pelicula.fecha}",
                modifier= Modifier
                    .padding(top = 5.dp, start = 20.dp, end = 10.dp) ,
                color = Color(0xFFFFFDFD), fontSize = 20.sp,
                textAlign = TextAlign.Center)

            Text(text = pelicula.descripcion,modifier= Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp) ,color = Color(0xFFFFFDFD), fontSize = 20.sp, textAlign = TextAlign.Center)


        }
    }

}