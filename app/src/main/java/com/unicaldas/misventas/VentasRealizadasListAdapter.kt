package com.unicaldas.misventas

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class VentasRealizadasListAdapter(context: AppCompatActivity,
                                  val info: Bundle) : RecyclerView.Adapter<VentasRealizadasListAdapter.MyViewHolder>() {
    class MyViewHolder(val layout: View) : RecyclerView.ViewHolder(layout)

    private var context: AppCompatActivity = context

    var myVentaTitulos: ArrayList<String> = info.getStringArrayList("titulos") as ArrayList<String>
    var myVentaCodigos : ArrayList<String> = info.getStringArrayList("codigos") as ArrayList<String>
    var myVentaFechas: ArrayList<String> = info.getStringArrayList("fechas") as ArrayList<String>
    var myVentaClientes: ArrayList<String> = info.getStringArrayList("clientes") as ArrayList<String>
    var myVentaDirecciones: ArrayList<String> = info.getStringArrayList("direcciones") as ArrayList<String>
    var myVentaCorreos: ArrayList<String> = info.getStringArrayList("correos") as ArrayList<String>
    var myVentaTelefonos: ArrayList<String> = info.getStringArrayList("telefonos") as ArrayList<String>
    var myVentaMetrosC: ArrayList<String> = info.getStringArrayList("metrosC") as ArrayList<String>
    var myVentaLat: ArrayList<String> = info.getStringArrayList("lat") as ArrayList<String>
    var myVentaLong: ArrayList<String> = info.getStringArrayList("long") as ArrayList<String>
    var myVentaValores: ArrayList<String> = info.getStringArrayList("valores") as ArrayList<String>
    var myVentaSaldos: ArrayList<String> = info.getStringArrayList("saldos") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.ventas_realizadas_list_items, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var textViewVenta = holder.layout.findViewById<TextView>(R.id.textViewProducto)
        textViewVenta.text = myVentaTitulos[position]

        var textViewFecha = holder.layout.findViewById<TextView>(R.id.textViewFecha)
        textViewFecha.text = myVentaFechas[position]

        var textViewCliente = holder.layout.findViewById<TextView>(R.id.textViewCliente)
        textViewCliente.text = myVentaClientes[position]

        holder.layout.setOnClickListener {
            //Toast.makeText(holder.itemView.context, myVentaValores[position], Toast.LENGTH_LONG).show()
            val datos = Bundle()
            datos.putString("titulo", textViewVenta.text as String)
            datos.putString("codigo", myVentaCodigos[position])
            datos.putString("fecha", textViewFecha.text as String)
            datos.putString("cliente", textViewCliente.text as String)
            datos.putString("direccion", myVentaDirecciones[position])
            datos.putString("telefono",myVentaTelefonos[position])
            datos.putString("correo", myVentaCorreos[position])
            datos.putString("metrosC", myVentaMetrosC[position])
            datos.putString("lat", myVentaLat[position])
            datos.putString("long", myVentaLong[position])
            datos.putString("valor", myVentaValores[position])
            datos.putString("saldo", myVentaSaldos[position])

            context.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view, DetailFragment::class.java, datos, "detail")
                ?.addToBackStack("")
                ?.commit()
        }
    }

    override fun getItemCount(): Int {
        return myVentaTitulos.size
    }

}