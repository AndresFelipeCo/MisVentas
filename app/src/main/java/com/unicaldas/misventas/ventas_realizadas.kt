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
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.unicaldas.misventas.room_database.VentasDatabase
import com.unicaldas.misventas.room_database.Ventas_RealizadasDAO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.NumberFormatException

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
        val dbFirebase = FirebaseFirestore.getInstance()

        var myVentaTitulos: ArrayList<String> = ArrayList()
        var myVentaCodigos: ArrayList<String> = ArrayList()
        var myVentaFechas: ArrayList<String> = ArrayList()
        var myVentaCliente: ArrayList<String> = ArrayList()
        var myVentaDireccion: ArrayList<String> = ArrayList()
        var myVentaCorreoE: ArrayList<String> = ArrayList()
        var myVentaTelefono: ArrayList<String> = ArrayList()
        var myVentaMetrosC: ArrayList<String> = ArrayList()
        var  myVentaLat: ArrayList<String> = ArrayList()
        var  myVentaLong: ArrayList<String> = ArrayList()
        var myVentaValores: ArrayList<String> = ArrayList()
        var myVentaSaldos: ArrayList<String> = ArrayList()

        dbFirebase.collection("Ventas").get().addOnSuccessListener {
            var docs = it.documents
            var i = 0
            while (i < docs.size){
                myVentaTitulos.add(docs[i].get("cortina").toString())
                myVentaCodigos.add(docs[i].id.toString())
                myVentaFechas.add(docs[i].get("fechaVenta").toString())
                myVentaCliente.add(docs[i].get("nombreC").toString())
                myVentaDireccion.add(docs[i].get("direccionC").toString())
                if(isNumeric(docs[i].get("altoCortina").toString())&& isNumeric(docs[i].get("anchoCortina").toString())){
                    var alto : Double = 0.0
                    var ancho : Double = 0.0
                    alto = docs[i].get("altoCortina").toString().toDouble()
                    ancho = docs[i].get("anchoCortina").toString().toDouble()
                    myVentaMetrosC.add((alto*ancho).toString())
                }
                else{
                    myVentaMetrosC.add("Error en los datos")
                }
                myVentaLat.add(docs[i].get("latC").toString())
                myVentaLong.add(docs[i].get("longC").toString())
                myVentaValores.add(docs[i].get("valorVenta").toString())
                myVentaCorreoE.add(docs[i].get("correo").toString())
                myVentaTelefono.add(docs[i].get("telefono").toString())
                myVentaSaldos.add(docs[i].get("Saldo").toString())

                i++
            }

        }

        /*val room : VentasDatabase = Room
            .databaseBuilder(context?.applicationContext!!, VentasDatabase::class.java, "VentasDatabase")
            .build()

        var ventasRealizadasDAO : Ventas_RealizadasDAO = room.ventas_RealizadasDAO()

        runBlocking {
            launch {
                var result = ventasRealizadasDAO.getAllVentas()
                var i : Int = 0
                while (i < result.size){
                    myVentaTitulos.add(result[i].cortina)
                    myVentaCodigos.add(result[i].id.toString())
                    myVentaFechas.add(result[i].fechaVenta)
                    myVentaCliente.add(result[i].nombreC)
                    myVentaDireccion.add(result[i].direccionC)
                    if(isNumeric(result[i].altoCortina)&& isNumeric(result[i].anchoCortina)){
                        myVentaMetrosC.add((result[i].altoCortina.toFloat()*result[i].anchoCortina.toFloat()).toString())
                    }
                    else{
                        myVentaMetrosC.add("Error en los datos")
                    }
                    myVentaLat.add(result[i].latC)
                    myVentaLong.add(result[i].longC)
                    myVentaValores.add("200000")

                    i= i+1
                }
            }
        }*/

        var info: Bundle = Bundle()
        info.putStringArrayList("titulos", myVentaTitulos)
        info.putStringArrayList("codigos",myVentaCodigos)
        info.putStringArrayList("fechas", myVentaFechas)
        info.putStringArrayList("clientes", myVentaCliente)
        info.putStringArrayList("direcciones", myVentaDireccion)
        info.putStringArrayList("correos", myVentaCorreoE)
        info.putStringArrayList("telefonos", myVentaTelefono)
        info.putStringArrayList("metrosC", myVentaMetrosC)
        info.putStringArrayList("lat", myVentaLat)
        info.putStringArrayList("long", myVentaLong)
        info.putStringArrayList("valores", myVentaValores)
        info.putStringArrayList("saldos",myVentaSaldos)

        listRecyclerView = requireView().findViewById(R.id.recyclerVentasRealizadasList)

        myAdapter = VentasRealizadasListAdapter(activity as AppCompatActivity, info)

        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    fun isNumeric(cadena: String): Boolean {
        val resultado: Boolean
        resultado = try {
            cadena.toInt()
            true
        } catch (excepcion: NumberFormatException) {
            false
        }
        return resultado
    }
}