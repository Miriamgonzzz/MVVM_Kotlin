package com.example.mvvmkotlin.data

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmkotlin.common.TextoBoton
import com.example.mvvmkotlin.common.TextoMensaje

@Composable
fun Borrar(codigo: String){

    var mensaje_borrado by remember { mutableStateOf("") }
    var codigo = codigo

    Button(
        shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        modifier = Modifier
            .size(220.dp, 50.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0xD3E72C2C), Color(0xFF000000))),
                CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            ),
        onClick = {
            if (codigo.isNotBlank()) {
                db.collection(nombre_coleccion)
                    .document(codigo)
                    .delete()
                    .addOnSuccessListener {
                        mensaje_borrado = "Datos borrados correctamente"
                        codigo = ""
                    }
                    .addOnFailureListener {
                        mensaje_borrado = "No se ha podido borrar"
                        codigo = ""
                    }
            }else{
                mensaje_borrado = "Esta en blanco"
            }
        },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),
        border = BorderStroke(2.dp, Color.Black)
    )
    {

        TextoBoton(texto = "Borrar")


    }
    Spacer(modifier = Modifier.size(5.dp))
    TextoMensaje(texto = mensaje_borrado)

}
