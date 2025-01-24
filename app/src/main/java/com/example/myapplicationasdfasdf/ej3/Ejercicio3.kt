package com.example.myapplicationasdfasdf.ej3

import android.Manifest
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationasdfasdf.R
import com.example.myapplicationasdfasdf.databinding.ActivityEjercicio3Binding


class Ejercicio3 : AppCompatActivity(), OnClickListener, onItemChecked {

    private lateinit var bind : ActivityEjercicio3Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        bind = ActivityEjercicio3Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(bind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaComidas = mutableListOf(
            Comida("Pizza", false),
            Comida("Pizza", false)
        )

        var adapterC2 = ComidaAdapter2(listaComidas, this, this, applicationContext)
        var adapterC = ComidaAdapter(listaComidas, this, this, adapterC2, applicationContext)
        adapterC2.setAdapter(adapterC)

        bind.ej3ButtonAniadir.setOnClickListener {
            adapterC.addComida(Comida(bind.ej3TietBuscador.text.toString(), false))
            bind.ej3TietBuscador.setText("")
        }

        bind.recyclerViewComer.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio3)
            adapter = adapterC
        }
        bind.recyclerViewComido.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio3)
            adapter = adapterC2
        }
    }

    override fun onLongClick(comida: Comida) {
        TODO("Not yet implemented")
    }

    override fun onItemMoved1(comida: Comida, position: Int, fromAdapter: ComidaAdapter, toAdapter: ComidaAdapter2) {
        fromAdapter.removeComida(comida, position)
        toAdapter.addComida(comida)
    }

    override fun onItemMoved2(comida: Comida, position: Int, fromAdapter: ComidaAdapter2, toAdapter: ComidaAdapter) {
        fromAdapter.removeComida(comida, position)
        toAdapter.addComida(comida)
    }
}