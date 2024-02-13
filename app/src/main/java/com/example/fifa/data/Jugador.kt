package com.example.fifa.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Jugador(
    @StringRes val nombre: Int,
    @StringRes val puntuacion: Int,
    @DrawableRes val foto: Int,
    @DrawableRes val bandera: Int,
    @DrawableRes val escudo: Int,
    @StringRes val posicion: Int,
    @StringRes val ritmo: Int,
    @StringRes val tiro: Int,
    @StringRes val pase: Int,
    @StringRes val regate: Int,
    @StringRes val defensa: Int,
    @StringRes val fisico: Int,
    )