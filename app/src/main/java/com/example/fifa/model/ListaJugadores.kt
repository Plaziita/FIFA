package com.example.fifa.model

import com.example.fifa.R
import com.example.fifa.data.Jugador

object ListaJugadores {

    val jugadores = listOf(

        Jugador(
            nombre = R.string.nombre,
            puntuacion = R.string.puntiacion,
            foto = R.drawable.fotombappe,
            bandera = R.drawable.banderafrancia,
            escudo = R.drawable.escudopsg,
            posicion = R.string.posicion,
            ritmo = R.string.ritmo,
            tiro = R.string.tiro,
            pase = R.string.pase,
            regate = R.string.regate,
            defensa = R.string.defensa,
            fisico = R.string.fisico
        )

    )

}