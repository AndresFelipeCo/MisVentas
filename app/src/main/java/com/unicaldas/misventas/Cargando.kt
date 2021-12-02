package com.unicaldas.misventas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Cargando : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargando)
        supportActionBar?.hide();
        Thread.sleep(3000)
        val intento = Intent(this, MainActivity::class.java)
        startActivity(intento)
    }
}