package com.unicaldas.misventas.room_database

import androidx.room.*

@Dao
interface ProductoDAO {
    @Query("SELECT * FROM Producto")
    suspend fun getAllProductos(): List<Producto>

    @Query("SELECT * From Producto WHERE id = :id")
    suspend fun findById(id : Int): Producto

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductos(producto : Producto): Long

    @Update
    suspend fun updateProductos(producto : Producto)

    @Delete
    suspend fun deleteProductos(producto : Producto)
}