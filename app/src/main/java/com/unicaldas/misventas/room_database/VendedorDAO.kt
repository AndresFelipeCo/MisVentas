package com.unicaldas.misventas.room_database

import androidx.room.*

@Dao
interface VendedorDAO{
    @Query("SELECT * FROM Vendedor")
    suspend fun getAllVendedores(): List<Vendedor>

    @Query("SELECT * From Vendedor WHERE id = :id")
    suspend fun findById(id : Int): Vendedor

    @Query("SELECT * FROM Vendedor WHERE documentoV = :documentoV")
    suspend fun findVDocumento(documentoV : String): List<Vendedor>

    @Query("SELECT * FROM Vendedor WHERE correoEV = :correoEV")
    suspend fun findVCorreo(correoEV : String): Vendedor

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVendedor(vendedor: Vendedor): Long

    @Update
    suspend fun updateVendedor(vendedor: Vendedor)

    @Delete
    suspend fun deleteVendedor(vendedor: Vendedor)
}