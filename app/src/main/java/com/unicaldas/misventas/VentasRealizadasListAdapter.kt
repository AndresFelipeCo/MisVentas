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
    var myVentaFechas: ArrayList<String> = info.getStringArrayList("fechas") as ArrayList<String>
    var myVentaValores: ArrayList<String> = info.getStringArrayList("valores") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.ventas_realizadas_list_items, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var textViewVenta = holder.layout.findViewById<TextView>(R.id.textViewProducto)
        textViewVenta.text = myVentaTitulos[position]

        var textViewFecha = holder.layout.findViewById<TextView>(R.id.textViewFecha)
        textViewFecha.text = myVentaFechas[position]

        holder.layout.setOnClickListener {
            Toast.makeText(holder.itemView.context, myVentaValores[position], Toast.LENGTH_LONG).show()
            // val datos = Bundle() .../
        }
    }

    override fun getItemCount(): Int {
        return myVentaTitulos.size
    }

}