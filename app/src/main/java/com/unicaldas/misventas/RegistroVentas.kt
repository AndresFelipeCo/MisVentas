package com.unicaldas.misventas

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.unicaldas.misventas.room_database.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroVentas.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroVentas : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro_ventas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbFirebase = FirebaseFirestore.getInstance()

        val spinnerTCortina: Spinner = view.findViewById(R.id.spinnerTCortina)

        var productos : ArrayList<String> = arrayListOf()

        productos.add(0, "Selecciona")

        dbFirebase.collection("Articulo").get().addOnSuccessListener {
            var docs = it.documents

            var i = 0
            while (i < docs.size){
                productos.add(docs[i].id.toInt(), docs[i].get("tipoCortina").toString() +" " +docs[i].get("color"))
                i++
            }
        }



        val productoAdapter = ArrayAdapter(context?.applicationContext!!, android.R.layout.simple_spinner_item, productos)
        productoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTCortina.adapter = productoAdapter



        /*val room : VentasDatabase = Room
            .databaseBuilder(context?.applicationContext!!, VentasDatabase::class.java, "VentasDatabase")
            .build()

        var productoDAO : ProductoDAO = room.productoDAO()

        runBlocking {
            launch {
                var productos = productoDAO.getAllProductos()

                val productoAdapter = ArrayAdapter(context?.applicationContext!!, android.R.layout.simple_spinner_item, productos)
                productoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerTCortina.adapter = productoAdapter
            }
        }*/







        var edtNombre : EditText = view.findViewById(R.id.edtNombre)
        var edtDocumento : EditText = view.findViewById(R.id.edtDocumento)
        var edtFecha: EditText = view.findViewById(R.id.editTextDate)
        var edtDirection : EditText = view.findViewById(R.id.edtDireccion)
        var edtTelefono : EditText = view.findViewById(R.id.edtTelefono)
        var edtCorreoE : EditText = view.findViewById(R.id.edtEmailAddress)
        var edtLat : EditText = view.findViewById(R.id.edtLatitud)
        var edtLong : EditText = view.findViewById(R.id.edtextLongitud)
        var edtAncho: EditText = view.findViewById(R.id.edtAncho)
        var edtALto : EditText = view.findViewById(R.id.edtAlto)

        var btnVender : Button = view.findViewById(R.id.btnVender)

        btnVender.setOnClickListener{
            if(!edtNombre.text.trim().isEmpty()){
                if(!edtDocumento.text.trim().isEmpty()){
                    if(!edtFecha.text.trim().isEmpty()){
                        if(!edtDirection.text.trim().isEmpty()){
                            if(!edtTelefono.text.trim().isEmpty()){
                                if(!edtCorreoE.text.trim().isEmpty()){
                                    if(!edtLat.text.trim().isEmpty()){
                                        if(!edtLong.text.trim().isEmpty()){
                                            if(!edtAncho.text.trim().isEmpty()){
                                                if(!edtALto.text.trim().isEmpty()){
                                                    if(spinnerTCortina.selectedItemId.toInt() != 0){
                                                        var valor:Double
                                                        var alto:Double
                                                        var ancho:Double
                                                        dbFirebase.collection("Articulo").document(spinnerTCortina.selectedItemId.toString()).get().addOnSuccessListener {


                                                            var valorS:String = (it.get("valorMC")).toString()
                                                            valor = valorS.toDouble()
                                                            valorS = edtALto.text.toString()
                                                            alto = valorS.toDouble()
                                                            valorS = edtAncho.text.toString()
                                                            ancho = valorS.toDouble()
                                                            valor = valor*alto*ancho
                                                            dbFirebase.collection("Ventas").document().set(
                                                                hashMapOf(
                                                                    "nombreC" to edtNombre.text.toString(),
                                                                    "documentoC" to edtDocumento.text.toString(),
                                                                    "fechaVenta" to edtFecha.text.toString(),
                                                                    "telefono" to edtTelefono.text.toString(),
                                                                    "correo" to edtCorreoE.text.toString(),
                                                                    "direccionC" to edtDirection.text.toString(),
                                                                    "latC" to edtLat.text.toString(),
                                                                    "longC" to edtLong.text.toString(),
                                                                    "cortina" to spinnerTCortina.selectedItem.toString(),
                                                                    "anchoCortina" to edtAncho.text.toString(),
                                                                    "altoCortina" to edtAncho.text.toString(),
                                                                    "valorVenta" to valor.toString(),
                                                                    "Saldo" to valor.toString()
                                                                )
                                                            )

                                                            Navigation.findNavController(view).navigate(R.id.nav_ventas_realizadas)
                                                            Toast.makeText(context?.applicationContext, "¡Registro exitoso!", Toast.LENGTH_LONG).show()

                                                        }

                                                    }

                                                    /*dbFirebase.collection("Ventas").document().set(){
                                                        "nombreC"
                                                        "documentoC"
                                                        "fechaVenta"
                                                        "telefono"
                                                        "correo"
                                                        "direccionC"
                                                        "latC"
                                                        "longC"
                                                        "cortina"
                                                        "anchoCortina"
                                                        "altoCortina"
                                                        "valorVenta"
                                                        "Saldo"
                                                    }*/

                                                    /*val ventasRealizadas: Ventas_Realizadas = Ventas_Realizadas(0,edtNombre.text.toString(),edtDocumento.text.toString(),edtFecha.text.toString(), "3188676717", "cliente@gmail.com",edtDirection.text.toString(), edtLat.text.toString(), edtLong.text.toString(), "Española", edtAncho.text.toString(), edtALto.text.toString())
                                                    val ventasRealizadasDAO : Ventas_RealizadasDAO = room.ventas_RealizadasDAO()
                                                    runBlocking {
                                                        launch {
                                                            var result = ventasRealizadasDAO.insertVentas_Realizadas(ventasRealizadas)
                                                        }
                                                    }*/

                                                }
                                                else{
                                                    Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                                                    edtALto.setText("")
                                                    edtALto.setHintTextColor(Color.RED)
                                                }
                                            }
                                            else{
                                                Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                                                edtAncho.setText("")
                                                edtAncho.setHintTextColor(Color.RED)
                                            }
                                        }
                                        else{
                                            Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                                            edtLong.setText("")
                                            edtLong.setHintTextColor(Color.RED)
                                        }
                                    }
                                    else{
                                        Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                                        edtLat.setText("")
                                        edtLat.setHintTextColor(Color.RED)
                                    }

                                }
                                else{
                                    Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                                    edtTelefono.setText("")
                                    edtTelefono.setHintTextColor(Color.RED)
                                }
                            }
                            else{
                                Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                                edtTelefono.setText("")
                                edtTelefono.setHintTextColor(Color.RED)
                            }

                        }
                        else{
                            Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                            edtDirection.setText("")
                            edtDirection.setHintTextColor(Color.RED)
                        }
                    }
                    else{
                        Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                        edtFecha.setText("")
                        edtFecha.setHintTextColor(Color.RED)
                    }
                }
                else{
                    Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                    edtDocumento.setText("")
                    edtDocumento.setHintTextColor(Color.RED)
                }
            }
            else{
                Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                edtNombre.setText("")
                edtNombre.setHintTextColor(Color.RED)
            }
        }
    }

}