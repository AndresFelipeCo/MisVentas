package com.unicaldas.misventas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ventas_realizadas.newInstance] factory method to
 * create an instance of this fragment.
 */
class ventas_realizadas : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<VentasRealizadasListAdapter.MyViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        val fragmento: View = inflater.inflate(R.layout.fragment_ventas_realizadas, container, false)
        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        var myVentaTitulos: ArrayList<String> = ArrayList()

        myVentaTitulos.add("Cortina plegable")
        myVentaTitulos.add("Cortina Española")
        myVentaTitulos.add("Cortina Italiana")

        var myVentaFechas: ArrayList<String> = ArrayList()
        myVentaFechas.add("30/11/2021")
        myVentaFechas.add("29/11/2021")
        myVentaFechas.add("30/11/2021")

        var myVentaCliente: ArrayList<String> = ArrayList()
        myVentaCliente.add("Pedro Jaramillo")
        myVentaCliente.add("Angel Guaraca")
        myVentaCliente.add("Alirio Estrada")

        var myVentaDireccion: ArrayList<String> = ArrayList()
        myVentaDireccion.add("Sandona")
        myVentaDireccion.add("Pasto")
        myVentaDireccion.add("Ipiales")

        var myVentaMetrosC: ArrayList<String> = ArrayList()
        myVentaMetrosC.add("15")
        myVentaMetrosC.add("25")
        myVentaMetrosC.add("35")

        var  myVentaLat: ArrayList<String> = ArrayList()
        myVentaLat.add("0")
        myVentaLat.add("0")
        myVentaLat.add("0")

        var  myVentaLong: ArrayList<String> = ArrayList()
        myVentaLong.add("0")
        myVentaLong.add("0")
        myVentaLong.add("0")

        var myVentaValores: ArrayList<String> = ArrayList()
        myVentaValores.add("2000")
        myVentaValores.add("2000")
        myVentaValores.add("2000")

        var info: Bundle = Bundle()
        info.putStringArrayList("titulos", myVentaTitulos)
        info.putStringArrayList("fechas", myVentaFechas)
        info.putStringArrayList("clientes", myVentaCliente)
        info.putStringArrayList("direcciones", myVentaDireccion)
        info.putStringArrayList("metrosC", myVentaLong)
        info.putStringArrayList("lat", myVentaLat)
        info.putStringArrayList("long", myVentaLong)
        info.putStringArrayList("valores", myVentaValores)

        listRecyclerView = requireView().findViewById(R.id.recyclerVentasRealizadasList)

        myAdapter = VentasRealizadasListAdapter(activity as AppCompatActivity, info)

        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}