package com.example.mvvmkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel:ViewModel() {

    private val _codigo = MutableLiveData<String>()
    val codigo : LiveData<String> = _codigo

    private val _nombre = MutableLiveData<String>()
    val nombre : LiveData<String> = _nombre

    private val _director = MutableLiveData<String>()
    val director : LiveData<String> = _director

    private val _actores = MutableLiveData<String>()
    val actores : LiveData<String> = _actores

    private val _fecha = MutableLiveData<String>()
    val fecha : LiveData<String> = _fecha

    private val _descripcion = MutableLiveData<String>()
    val descripcion : LiveData<String> = _descripcion

    private val _datos = MutableLiveData<String>()
    val datos : LiveData<String> = _datos

    private val _mensajeConfirmacion = MutableLiveData<String>()
    val mensajeConfirmacion : LiveData<String> = _mensajeConfirmacion

    private val _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    fun onCompletedFields(
        codigo: String,
        nombre: String,
        director:String,
        actores:String,
        fecha:String,
        descripcion:String) {
        _codigo.value = codigo
        _nombre.value = nombre
        _director.value = director
        _actores.value = actores
        _fecha.value = fecha
        _descripcion.value = descripcion
        _isButtonEnable.value = enableButton(codigo, nombre,director,actores,fecha,descripcion)
    }

    fun enableButton(
        codigo: String,
        nombre: String,
        director: String,
        actores: String,
        fecha: String,
        descripcion: String
    ) =
        //Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        codigo.length >0 && nombre.length >0 && director.length >0 && actores.length >0 && fecha.length >0 && descripcion.length >0

    fun vaciar(){
        _datos.value=""
        _codigo.value=""
        _nombre.value= ""
        _director.value= ""
        _actores.value= ""
        _fecha.value= ""
        _descripcion.value=""

    }
}

