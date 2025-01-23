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


class Ejercicio3 : AppCompatActivity() {

    private lateinit var bind : ActivityEjercicio3Binding
    private var imagenComida : Int = 0
    private lateinit var pickMedia :  androidx.activity.result.ActivityResultLauncher<PickVisualMediaRequest>

    private val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            // Permission Granted
        } else {
            // Permission Denied
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        bind = ActivityEjercicio3Binding.inflate(layoutInflater)

        launcher.launch(Manifest.permission.READ_MEDIA_IMAGES)

        pickMedia =  registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri: Uri? ->
            // Handle the returned Uri
            if (uri != null) {
                // Use the Uri to display the image or perform other actions
                bind.ej3ImagenComida.setImageURI(uri)
                // ...
            } else {
                // No media selected
                Log.d("PhotoPicker", "No media selected")
            }

        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(bind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val listaComidas = mutableListOf(
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza"),
            Comida(R.drawable.pizza, "Pizza")
        )

        var adapterC = ComidaAdapter(listaComidas, applicationContext)

        bind.ej3ImagenComida.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        bind.ej3ButtonAniadir.setOnClickListener {
            adapterC.addComida(Comida(imagenComida, bind.ej3TietBuscador.text.toString()))
            adapterC.notifyDataSetChanged()
        }



        bind.reciclar3.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio3)
            adapter = adapterC
        }
    }


}