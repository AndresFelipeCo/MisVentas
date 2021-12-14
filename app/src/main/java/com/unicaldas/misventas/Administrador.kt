package com.unicaldas.misventas

import android.media.AudioPlaybackConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class Administrador : AppCompatActivity() {
    private lateinit var  appbarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrador)
        //supportActionBar?.hide();
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val fab: View = findViewById((R.id.fab))
        fab.setOnClickListener { view ->
            //Add new task
        }

        val drawerLayout:DrawerLayout = findViewById(R.id.drawer_layout)
        val navView:NavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        appbarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_ventas_realizadas,
            R.id.nav_registro_ventas,
            R.id.nav_detail,
            R.id.nav_abonos,
            R.id.nav_registro_articulos,
            R.id.nav_registro_vendedor,
        ), drawerLayout)

        setupActionBarWithNavController(navController, appbarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        return  navController.navigateUp(appbarConfiguration) || super.onSupportNavigateUp()
    }
}