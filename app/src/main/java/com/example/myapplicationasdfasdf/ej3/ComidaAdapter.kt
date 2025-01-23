package com.example.myapplicationasdfasdf.ej3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationasdfasdf.R
import com.example.myapplicationasdfasdf.databinding.ItemComidaBinding

class ComidaAdapter (var comidas : MutableList<Comida>, private val listener: OnClickListener, private var contexto: Context? = null) : RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>() {

    inner class ComidaViewHolder(comida: View) : RecyclerView.ViewHolder(comida) {

        val binding = ItemComidaBinding.bind(comida)
        private var nombreComida: TextView = comida.findViewById(R.id.nombreComida)
        private var imagenComida: ImageView = comida.findViewById(R.id.ej3_button_borrar)

        init {
            imagenComida.setOnClickListener {
                comidas.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }

        fun bind(ficha: Comida) {
            nombreComida.setText(ficha.nombre)
        }

        fun setListener(comida: Comida) {
            binding.root.setOnLongClickListener {
                listener.onLongClick(comida)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comida, parent, false)
        return ComidaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val currentComida = comidas[position]
        holder.setListener(currentComida)
        holder.bind(currentComida)
    }

    override fun getItemCount(): Int = comidas.size

    fun addComida(comida: Comida) {
        comidas.add(comida)
        notifyDataSetChanged()
    }

    fun removeComida(comida: Comida) {
        comidas.remove(comida)
        notifyDataSetChanged()
    }
}