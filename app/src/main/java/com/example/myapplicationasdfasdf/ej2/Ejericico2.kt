package com.example.myapplicationasdfasdf.ej2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationasdfasdf.R
import com.example.myapplicationasdfasdf.databinding.ActivityEjericico2Binding

class ejericico2 : AppCompatActivity() {

    private lateinit var bind : ActivityEjericico2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEjericico2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(bind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaFichas = listOf(
            Ficha(R.drawable.pizza, "Pizza"),
            Ficha(R.drawable.pizza, "Pizza"),
            Ficha(R.drawable.pizza, "Pizza"),
            Ficha(R.drawable.pizza, "Pizza"),
            Ficha(R.drawable.pizza, "Pizza"),
            Ficha(R.drawable.pizza, "Pizza"),
            Ficha(R.drawable.pizza, "Pizza")
            )

        var adapterF = FichaAdapter(listaFichas, applicationContext)

        bind.reciclar2.apply {
            layoutManager = LinearLayoutManager(this@ejericico2, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterF
        }
    }
}