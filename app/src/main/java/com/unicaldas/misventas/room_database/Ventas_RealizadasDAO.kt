package com.unicaldas.misventas.room_database

import androidx.room.*

@Dao
interface Ventas_RealizadasDAO{
    @Query("SELECT * FROM Ventas_Realizadas")
    suspend fun getAllVentas(): List<Ventas_Realizadas>

    @Query("SELECT * From Ventas_Realizadas WHERE id = :id")
    suspend fun findById(id : Int): Ventas_Realizadas

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVentas_Realizadas(ventasRealizadas: Ventas_Realizadas): Long

    @Update
    suspend fun updateVentas_Realizadas(ventasRealizadas: Ventas_Realizadas)

    @Delete
    suspend fun deleteVentas_Realizadas(ventasRealizadas: Ventas_Realizadas)
}