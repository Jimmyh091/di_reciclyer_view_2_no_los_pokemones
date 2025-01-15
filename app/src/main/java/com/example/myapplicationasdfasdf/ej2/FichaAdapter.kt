package com.example.myapplicationasdfasdf.ej2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationasdfasdf.R

class FichaAdapter (private val fichas : List<Ficha>) : RecyclerView.Adapter<FichaAdapter.FichaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FichaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ficha, parent, false)
        return FichaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FichaViewHolder, position: Int) {
        val currentFicha = fichas[position]
        holder.bind(currentFicha)
    }

    override fun getItemCount(): Int = fichas.size

    inner class FichaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var imagenFicha: ImageView = itemView.findViewById(R.id.imagenFicha)
        private var nombreFicha: TextView = itemView.findViewById(R.id.nombreFicha)

        fun bind(ficha: Ficha) {
            imagenFicha = ficha.imagen
            nombreFicha = ficha.nombre
        }
    }
}