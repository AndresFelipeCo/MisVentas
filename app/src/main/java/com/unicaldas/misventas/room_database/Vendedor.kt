package com.unicaldas.misventas.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vendedor(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val nombreV: String,
    val documentoV: String,
    val correoEV: String,
    val contrasenaV: String
)