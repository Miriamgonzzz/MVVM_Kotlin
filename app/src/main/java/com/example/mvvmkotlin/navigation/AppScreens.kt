package com.example.conexionbasedatos.navigation

open class AppScreens(val ruta: String) {
    object MenuInicial:AppScreens("MenuInicial")
    object GuardarFilm:AppScreens("GuardarFilm")
    object ModificarFilm:AppScreens("ModificarFilm")
    object BorrarFilm:AppScreens("BorrarFilm")
    object ConsultarFilm:AppScreens("ConsultarFilm")
    object InformeFilm:AppScreens("InformeFilm")
}