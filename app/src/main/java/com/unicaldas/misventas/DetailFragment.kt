package com.unicaldas.misventas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_detail, container, false)

        var venta = requireArguments().getString("titulo")
        var codigo = requireArguments().getString("codigo")
        var fecha = requireArguments().getString("fecha")
        var cliente = requireArguments().getString("cliente")
        var direccion = requireArguments().getString("direccion")
        var telefono = requireArguments().getString("telefono")
        var correo = requireArguments().getString("correo")
        var metrosC = requireArguments().getString("metrosC")
        var lat = requireArguments().getString("lat")
        var long = requireArguments().getString("long")
        var valor = requireArguments().getString("valor")
        var saldo = requireArguments().getString("saldo")

        var textViewVenta : TextView = fragmento.findViewById(R.id.textViewVenta)
        var textViewCodigo : TextView = fragmento.findViewById(R.id.textViewCodigoV)
        var textViewFecha : TextView = fragmento.findViewById(R.id.textViewFecha)
        var textViewCliente : TextView = fragmento.findViewById(R.id.textViewCliente)
        var textViewDireccion : TextView = fragmento.findViewById(R.id.textViewDirección)
        var textViewTelefono : TextView = fragmento.findViewById(R.id.textViewTelefono)
        var textViewCorreo : TextView = fragmento.findViewById(R.id.textViewCorreo)
        var textViewMetrosC : TextView = fragmento.findViewById(R.id.textViewMetrosC)
        var textViewLat : TextView = fragmento.findViewById(R.id.textViewLat)
        var textViewLong : TextView = fragmento.findViewById(R.id.textViewLong)
        var textViewValor : TextView = fragmento.findViewById(R.id.textViewValor)
        var textViewSaldo : TextView = fragmento.findViewById(R.id.textViewSaldo)

        textViewVenta.text = venta
        textViewCodigo.text = codigo
        textViewFecha.text = fecha
        textViewCliente.text = cliente
        textViewDireccion.text = direccion
        textViewTelefono.text = telefono
        textViewCorreo.text = correo
        textViewMetrosC.text = metrosC
        textViewLat.text = lat
        textViewLong.text = long
        textViewValor.text = valor
        textViewSaldo.text = saldo

        return fragmento
    }
}