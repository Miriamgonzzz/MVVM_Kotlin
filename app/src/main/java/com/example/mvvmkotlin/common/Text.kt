package com.example.mvvmkotlin.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextoMensaje(texto:String){
    Card(
        shape = CutCornerShape( 20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color=Color(0xFF5C0606),CutCornerShape( 20.dp))
            .border(
                BorderStroke(5.dp, Color(0xFF300000)),
                CutCornerShape( 20.dp)
            ),

        ) {
        Text(
            text = texto,
            modifier = Modifier.padding(top = 10.dp),
            color = Color(0xFFFFFFFF),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun TextoElementos(texto:String){

    Column(
        //shape = RoundedCornerShape(20.dp),
        // backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFFBE9999), Color(0xFF1F0031))),
                RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(5.dp, Color(0xFF1B0303)),
                RoundedCornerShape(20.dp)
            ),
    ) {


        Text(text = texto,modifier=Modifier.fillMaxWidth().padding(10.dp) ,color = Color(0xFFFFFDFD), fontSize = 20.sp, textAlign = TextAlign.Center)


    }

}

@Composable
fun Texto(texto:String){
    Card(
        shape = CutCornerShape( 20.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color=Color(0xFF422626),CutCornerShape( 20.dp))
            .border(
                BorderStroke(5.dp, Color(0xFF300000)),
                CutCornerShape( 20.dp)
            ),

        ) {
        Text(
            text = texto,
            modifier = Modifier.padding(top = 10.dp),
            color = Color(0xFFF03C3C),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


