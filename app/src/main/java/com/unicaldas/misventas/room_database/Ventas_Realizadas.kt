package com.unicaldas.misventas.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ventas_Realizadas(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val nombreC : String,
    val documentoC : String,
    val fechaVenta : String,
    val telefono : String,
    val correo : String,
    val direccionC : String,
    val latC : String,
    val longC : String,
    val cortina : String,
    val anchoCortina : String,
    val altoCortina : String
)