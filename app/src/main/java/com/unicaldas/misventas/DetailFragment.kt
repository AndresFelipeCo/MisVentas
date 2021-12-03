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
        var fecha = requireArguments().getString("fecha")
        var cliente = requireArguments().getString("cliente")
        var direccion = requireArguments().getString("direccion")
        var metrosC = requireArguments().getString("metrosC")
        var lat = requireArguments().getString("lat")
        var long = requireArguments().getString("long")
        var valor = requireArguments().getString("valor")

        var textViewVenta : TextView = fragmento.findViewById(R.id.textViewVenta)
        var textViewFecha : TextView = fragmento.findViewById(R.id.textViewFecha)
        var textViewCliente : TextView = fragmento.findViewById(R.id.textViewCliente)
        var textViewDireccion : TextView = fragmento.findViewById(R.id.textViewDirección)
        var textViewMetrosC : TextView = fragmento.findViewById(R.id.textViewMetrosC)
        var textViewLat : TextView = fragmento.findViewById(R.id.textViewLat)
        var textViewLong : TextView = fragmento.findViewById(R.id.textViewLong)
        var textViewValor : TextView = fragmento.findViewById(R.id.textViewValor)

        textViewVenta.text = venta
        textViewFecha.text = fecha
        textViewCliente.text = cliente
        textViewDireccion.text = direccion
        textViewMetrosC.text = metrosC
        textViewLat.text = lat
        textViewLong.text = long
        textViewValor.text = valor

        return fragmento
    }
}