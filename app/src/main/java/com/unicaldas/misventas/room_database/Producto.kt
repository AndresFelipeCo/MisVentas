package com.unicaldas.misventas.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val tipoCortina : String,
    val color : String,
    val valorMC : String
)