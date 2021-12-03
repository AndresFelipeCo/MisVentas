package com.unicaldas.misventas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface

class MainActivity : AppCompatActivity() {
    private var edtEmailAddress : EditText? = null
    private var edtPassword : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmailAddress = findViewById(R.id.edtEmailAddress)
        edtPassword = findViewById(R.id.edtPassword)
    }

    fun onLogin(botonLogin: android.view.View) {
        if(edtEmailAddress!!.text.toString() == "correo@gmail.com"){
            if(edtPassword!!.text.toString() == "123"){
                val intento = Intent(this, Administrador::class.java)
                startActivity(intento)
            }
            else{
                val dialog = AlertDialog.Builder(this).setTitle("Error!").setMessage(R.string.incorrectPassword).show()
            }
        }
        else{
            val dialog = AlertDialog.Builder(this).setTitle("Error!").setMessage(R.string.incorrectEMail).show()
        }
    }
}