package com.example.mvvmkotlin.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmkotlin.viewModel.ViewModel


@Composable
fun TextoFild(
    texto: String,
    ViewModel: ViewModel,
    value: MutableState<String>
){

    OutlinedTextField(
        shape = RoundedCornerShape(topStart = 30.dp),
        value = value.value,
        onValueChange = {
            ViewModel.codigo.value?.let { it1 ->
                ViewModel.nombre.value?.let { it2 ->
                    ViewModel.director.value?.let { it3 ->
                        ViewModel.actores.value?.let { it4 ->
                            ViewModel.fecha.value?.let { it5 ->
                                ViewModel.descripcion.value?.let { it6 ->
                                    ViewModel.onCompletedFields(
                                        codigo = it1,
                                        nombre = it2,
                                        director = it3,
                                        actores = it4,
                                        fecha = it5,
                                        descripcion = it6
                                    )
                                }
                            }
                        }
                    }
                }
            }
            value.value = it
            },
        label = { Text(texto) },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(listOf(Color(0xFFBE9999), Color(0xFF1F0031))),
                RoundedCornerShape(topStart = 30.dp)
            ),

        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFF1B0303),
            focusedBorderColor = Color(0xFFBC7AE6),
            focusedLabelColor = Color(0xFFFCACFF),
            unfocusedLabelColor = Color(0xFFFEFFFE),
            cursorColor = Color(0xFF6904F7)
        ),
        textStyle = TextStyle.Default.copy(fontSize = 28.sp),
    )
}