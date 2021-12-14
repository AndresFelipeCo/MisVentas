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
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.unicaldas.misventas.room_database.Vendedor
import com.unicaldas.misventas.room_database.VendedorDAO
import com.unicaldas.misventas.room_database.VentasDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class registro_vendedor : Fragment() {

    //private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_registro_vendedor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var edtNombre : EditText = view.findViewById(R.id.edtNombre)
        var edtDocumento : EditText = view.findViewById(R.id.edtDocumento)
        var edtCorreo : EditText = view.findViewById(R.id.edtEmailAddress)
        var  edtPassword : EditText = view.findViewById(R.id.edtPassword)

        //var documento : Int = String.toInt(edtDocumento.text)

        var btnRegistrar : Button = view.findViewById(R.id.btnRegistrarV)

        btnRegistrar.setOnClickListener{
            var bandera: Boolean = false
            val dbFirebase = FirebaseFirestore.getInstance()
            val room : VentasDatabase = Room
                .databaseBuilder(context?.applicationContext!!, VentasDatabase::class.java, "VentasDatabase")
                .build()

            val ventasDAO : VendedorDAO = room.vendedorDAO()

            val vendedor: Vendedor = Vendedor(0,edtNombre.text.toString(),edtDocumento.text.toString(),edtCorreo.text.toString(),edtPassword.text.toString())

            if(!edtNombre.text.trim().isEmpty()){
                if(!edtDocumento.text.trim().isEmpty()){
                    if(!edtCorreo.text.trim().isEmpty()){
                        if(!edtPassword.text.trim().isEmpty()){
                            dbFirebase.collection("Vendedor").get().addOnSuccessListener {
                                var docs = it.documents
                                if (docs.size == 0){
                                    dbFirebase.collection("Vendedor").document(edtDocumento.text.toString()).set(
                                        hashMapOf(
                                            "nombreV" to edtNombre.text.toString(),
                                            "documentoV" to edtDocumento.text.toString(),
                                            "correoEV" to edtCorreo.text.toString(),
                                            "contrasenaV" to edtPassword.text.toString()
                                        )
                                    )
                                }
                                else{
                                    var i : Int = 0
                                    while (i < docs.size){
                                        if(docs[i].get("documentoV") == edtDocumento.text.toString()){
                                            bandera = true
                                            Toast.makeText(context?.applicationContext, "Documento duplicado", Toast.LENGTH_LONG).show()
                                            edtDocumento.setHintTextColor(Color.RED)
                                            edtDocumento.setText("")
                                            break
                                        }
                                        if(docs[i].get("correoEV") == edtCorreo.text.toString()){
                                            bandera = true
                                            Toast.makeText(context?.applicationContext, "Correo duplicado", Toast.LENGTH_LONG).show()
                                            edtCorreo.setHintTextColor(Color.RED)
                                            edtCorreo.setText("")
                                            break
                                        }
                                        i++
                                    }
                                    if(bandera == false){
                                        dbFirebase.collection("Vendedor").document(edtDocumento.text.toString()).set(
                                            hashMapOf(
                                                "nombreV" to edtNombre.text.toString(),
                                                "documentoV" to edtDocumento.text.toString(),
                                                "correoEV" to edtCorreo.text.toString(),
                                                "contrasenaV" to edtPassword.text.toString()
                                            )
                                        )
                                        Toast.makeText(context?.applicationContext, "Registro exitoso", Toast.LENGTH_LONG).show()
                                    }
                                }
                            }
                        }
                        else{
                            Toast.makeText(context?.applicationContext, "Los Campos son obligatorios", Toast.LENGTH_LONG).show()
                            edtPassword.setText("")
                            edtPassword.setHintTextColor(Color.RED)
                        }
                    }
                    else{
                        Toast.makeText(context?.applicationContext, "Los Campos son obligatorios", Toast.LENGTH_LONG).show()
                        edtCorreo.setText("")
                        edtCorreo.setHintTextColor(Color.RED)
                    }
                }
                else{
                    Toast.makeText(context?.applicationContext, "Los Campos son obligatorios", Toast.LENGTH_LONG).show()
                    edtDocumento.setText("")
                    edtDocumento.setHintTextColor(Color.RED)
                }
            }
            else{
                Toast.makeText(context?.applicationContext, "Los Campos son obligatorios", Toast.LENGTH_LONG).show()
                edtNombre.setText("")
                edtNombre.setHintTextColor(Color.RED)
            }

            /*runBlocking {
                launch {
                    var result = ventasDAO.insertVendedor(vendedor)
                    if(result!=-1L){
                        dbFirebase.collection("Vendedor").document(result.toString()).set(
                            hashMapOf(
                                "nombreV" to edtNombre.text.toString(),
                                "correoEV" to edtCorreo.text.toString(),
                                "contrasenaV" to edtPassword.text.toString()
                            )
                        )
                    }

                    Toast.makeText(context?.applicationContext, "Estoy funcionando", Toast.LENGTH_LONG).show()
                }
            }*/

        }
    }
}