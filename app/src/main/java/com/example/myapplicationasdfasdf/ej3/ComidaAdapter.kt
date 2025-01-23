package com.example.myapplicationasdfasdf.ej3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationasdfasdf.R

class ComidaAdapter (var comidas : MutableList<Comida>, var contexto: Context? = null) : RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>() {

    inner class ComidaViewHolder(comida: View) : RecyclerView.ViewHolder(comida) {
        private var imagenComida: ImageView = comida.findViewById(R.id.imagenComida)
        private var nombreComida: TextView = comida.findViewById(R.id.nombreComida)

        fun bind(ficha: Comida) {
            imagenComida.setImageResource(ficha.imagen)
            nombreComida.setText(ficha.nombre)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comida, parent, false)
        return ComidaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val currentComida = comidas[position]
        holder.bind(currentComida)
    }

    override fun getItemCount(): Int = comidas.size

    fun addComida(comida: Comida) {
        comidas.add(comida)
    }

    fun removeComida(comida: Comida) {
        comidas.remove(comida)
    }
}