package com.unicaldas.misventas.room_database

import androidx.room.*

@Database(
    entities = arrayOf(Vendedor::class, Ventas_Realizadas::class, Producto::class),
    version = 1
)

abstract class VentasDatabase: RoomDatabase() {
    abstract fun vendedorDAO(): VendedorDAO
    abstract fun ventas_RealizadasDAO(): Ventas_RealizadasDAO
    abstract fun productoDAO(): ProductoDAO

    /*companion object{
        @Volatile
        private var INSTANCE: VentasDatabase? = null

        fun getDatabase(context: Context): VentasDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    VentasDatabase::class.java,
                    "VentasDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}