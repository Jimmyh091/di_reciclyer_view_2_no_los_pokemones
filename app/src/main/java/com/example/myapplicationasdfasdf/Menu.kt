package com.example.myapplicationasdfasdf

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationasdfasdf.databinding.ActivityMenuBinding
import com.example.myapplicationasdfasdf.ej1.Ejercicio1
import com.example.myapplicationasdfasdf.ej2.ejericico2
import com.example.myapplicationasdfasdf.ej3.Ejercicio3

class Menu : AppCompatActivity() {

    private lateinit var bind : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        bind = ActivityMenuBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(bind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bind.buttonEj1.setOnClickListener {
            startActivity(Intent(this, Ejercicio1::class.java))
        }
        bind.buttonEj2.setOnClickListener {
            startActivity(Intent(this, ejericico2::class.java))
        }
        bind.buttonEj3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3::class.java))
        }
        bind.buttonEj4.setOnClickListener {
            //startActivity(Intent(this, Ejercicio4::class.java))
        }
    }
}