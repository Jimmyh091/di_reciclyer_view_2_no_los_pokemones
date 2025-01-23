package com.example.myapplicationasdfasdf.ej3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationasdfasdf.R
import com.example.myapplicationasdfasdf.databinding.ActivityEjercicio3Binding

class Ejercicio3 : AppCompatActivity() {

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

        val listaComidas = listOf(
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza")
        )

        var adapterC = ComidaAdapter(listaComidas, applicationContext)

        bind.reciclar3.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio3)
            adapter = adapterC
        }
    }

}