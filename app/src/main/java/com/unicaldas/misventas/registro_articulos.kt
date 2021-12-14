package com.unicaldas.misventas

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.unicaldas.misventas.room_database.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class registro_articulos : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registro_articulos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbFirebase = FirebaseFirestore.getInstance()

        var edtTipoCortina : EditText = view.findViewById(R.id.edtTipoCortina)
        var edtColor : EditText = view.findViewById(R.id.edtColor)
        var edtValorMC : EditText = view.findViewById(R.id.edtValorMetroC)

        var btnRegistrarP : Button = view.findViewById(R.id.btnRegistrarP)

        btnRegistrarP.setOnClickListener{
            if(!edtTipoCortina.text.trim().isEmpty()){
                if(!edtColor.text.trim().isEmpty()){
                    if(!edtValorMC.text.trim().isEmpty()){

                        dbFirebase.collection("Articulo").get().addOnSuccessListener {
                            var docs = it.documents
                            dbFirebase.collection("Articulo").document((docs.size+1).toString()).set(
                                hashMapOf(
                                    "tipoCortina" to edtTipoCortina.text.toString(),
                                    "color" to edtColor.text.toString(),
                                    "valorMC" to edtValorMC.text.toString()
                                )
                            )
                        }



                        /*val room : VentasDatabase = Room
                            .databaseBuilder(context?.applicationContext!!, VentasDatabase::class.java, "VentasDatabase")
                            .build()

                        val producto: Producto = Producto(0,edtTipoCortina.text.toString(),edtColor.text.toString(),edtValorMC.text.toString())
                        val productoDAO : ProductoDAO = room.productoDAO()
                        runBlocking {
                            launch {
                                var result = productoDAO.insertProductos(producto)
                            }
                        }*/
                        Navigation.findNavController(view).navigate(R.id.nav_registro_articulos)
                        Toast.makeText(context?.applicationContext, "¡Registro exitoso!", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                        edtValorMC.setText("")
                        edtValorMC.setHintTextColor(Color.RED)
                    }
                }
                else{
                    Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                    edtColor.setText("")
                    edtColor.setHintTextColor(Color.RED)
                }
            }
            else{
                Toast.makeText(context?.applicationContext, "Revisa el formulario", Toast.LENGTH_LONG).show()
                edtTipoCortina.setText("")
                edtTipoCortina.setHintTextColor(Color.RED)
            }
        }
    }
}