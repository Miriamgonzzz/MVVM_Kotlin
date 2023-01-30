package com.example.mvvmkotlin.data

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmkotlin.common.TextoBoton
import com.example.mvvmkotlin.common.TextoMensaje

@Composable
fun GuardarDatos(
    codigo:String,
    nombre_film:String,
    director_film:String,
    actores_film:String,
    fecha_film:String,
    descripcion_film:String,
    isButtonEnable: Boolean
) {

    var codigo = codigo
    var nombre_film = nombre_film
    var director_film = director_film
    var actores_film = actores_film
    var fecha_film = fecha_film
    var descripcion_film = descripcion_film

    val dato = hashMapOf(
        "codigo" to codigo,
        "nombre" to nombre_film,
        "director" to director_film,
        "actores" to actores_film,
        "fecha" to fecha_film,
        "descripcion" to descripcion_film,
    )

    var mensaje_confirmacion by rememberSaveable { mutableStateOf("") }

    Button(

        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {

            if (codigo.isNotEmpty() && nombre_film.isNotEmpty() && director_film.isNotEmpty() && actores_film.isNotEmpty() && fecha_film.isNotEmpty() && descripcion_film.isNotEmpty()) {
                db.collection("Film")
                    .document(codigo)
                    .set(dato)
                    .addOnSuccessListener {
                        mensaje_confirmacion = "Datos guardados correctamente"

                            codigo = ""
                            nombre_film = ""
                            director_film = ""
                            actores_film = ""
                            fecha_film = ""
                            descripcion_film = ""

                    }
                    .addOnFailureListener {
                        mensaje_confirmacion = "No se ha podido guardar"
                        codigo = ""
                        nombre_film = ""
                        director_film = ""
                        actores_film = ""
                        fecha_film = ""
                        descripcion_film = ""
                    }
            } else {
                mensaje_confirmacion = "Por favor, llene todos los campos."

            }
        },
        enabled= isButtonEnable,

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Guardar")


    }
    Spacer(modifier = Modifier.size(10.dp))

    TextoMensaje(
        texto = mensaje_confirmacion,
    )

    Spacer(modifier = Modifier.size(10.dp))
}
