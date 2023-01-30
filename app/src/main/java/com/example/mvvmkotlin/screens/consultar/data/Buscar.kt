package com.example.mvvmkotlin.data

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmkotlin.common.TextoBoton
import com.example.mvvmkotlin.common.TextoElementos

@Composable
fun Buscar(codigo_busqueda:String){
    //DECLARAMOS LA VARIABLE QUE VA A RECOGER LOS DATOS DE LA CONSULTA CON EL ESTADO REMEMBER
    var datos by remember { mutableStateOf("") }
    var nombre_film = remember { mutableStateOf("") }
    var director_film = remember { mutableStateOf("") }
    var actores_film = remember { mutableStateOf("") }
    var fecha_film = remember { mutableStateOf("") }
    var descripcion_film = remember { mutableStateOf("") }

    var codigo_busqueda = codigo_busqueda
    val field_busqueda = "nombre"
    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {


            // VACIAMOS VARIABLE AL DAR AL BOTON
            datos = ""
            nombre_film.value = ""
            director_film.value=""
            actores_film.value = ""
            fecha_film.value=""
            descripcion_film.value=""
            // HACEMOS LA CONSULTA A LA COLECCION CON GET
            db.collection(nombre_coleccion)
                .whereEqualTo(field_busqueda,codigo_busqueda)
                .get()

                //SI SE CONECTA CORRECTAMENTE
                // RECORRO TODOS LOS DATOS ENCONTRADOS EN LA COLECCIÓN Y LOS ALMACENO EN DATOS
                .addOnSuccessListener { resultado ->
                    for (encontrado in resultado) {
                        //Para crear un HashMap con todos los datos
                        datos += "${encontrado.id}: ${encontrado.data}\n"

                        //Para crear un HashMap con todos los datos
                        nombre_film.value +="Nombre: ${encontrado["nombre"].toString()}"
                        director_film.value +="Director: ${encontrado["director"].toString()}"
                        actores_film.value +="Actores: ${encontrado["actores"].toString()}"
                        fecha_film.value += "Fecha:${encontrado["fecha"].toString()}"
                        descripcion_film.value +="Descripcion ${encontrado["descripcion"].toString()}"

                    }

                    if (datos.isEmpty()) {
                        datos = "No existen datos"
                    }
                }
                //SI NO CONECTA CORRECTAMENTE
                .addOnFailureListener { resultado ->
                    datos = "La conexión a FireStore no se ha podido completar"
                }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Cargar Datos")
    }

    Spacer(modifier = Modifier.size(10.dp))
    Column(
        //shape = RoundedCornerShape(20.dp),
        // backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color(0xFFE20202),
                RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF1B0303)),
                RoundedCornerShape(20.dp)
            ),
    ) {
        // PINTAMOS EL RESULTADO DE LA CONSULTA A LA BASE DE DATOS
        //Text (text = datos)
        TextoElementos(texto =  nombre_film.value)
        TextoElementos(texto =  director_film.value)
        TextoElementos(texto =  actores_film.value)
        TextoElementos(texto =  fecha_film.value)
        TextoElementos(texto = descripcion_film.value)
    }
}