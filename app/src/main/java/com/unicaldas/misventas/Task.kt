package com.unicaldas.misventas

data class Task (val edtNombre: String, val edtDocumento: String, val edtFechaVenta: String, val edtDireccion: String, val edtLatitud: String, val edtLongitud: String, val spinnerTCortinas: String, val edtAncho: String, val edtAlto: String) {
    override fun toString(): String {
        return spinnerTCortinas
    }
}