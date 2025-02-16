package com.example.myapplicationasdfasdf.ej3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationasdfasdf.R
import com.example.myapplicationasdfasdf.databinding.ItemComidaBinding

class ComidaAdapter (var comidas : MutableList<Comida>, private val listener: OnClickListener, private val mover: onItemChecked, private val toAdapter2: ComidaAdapter2, private var contexto: Context? = null) : RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>() {

    inner class ComidaViewHolder(comida: View) : RecyclerView.ViewHolder(comida) {

        val binding = ItemComidaBinding.bind(comida)
        private var checkBox = binding.checkBox
        private var imagenComida: ImageView = comida.findViewById(R.id.ej3_button_borrar)

        init {
            imagenComida.setOnClickListener {
                comidas.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

        }

        fun bind(comida: Comida) {
            checkBox.text = comida.nombre
            checkBox.isChecked = comida.checkeada
            Log.v("checkeada", "${comida.checkeada.toString()}")
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

        holder.binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mover.onItemMoved1(comidas[position], position, this, toAdapter2)
                comidas[position].checkeada = false
            }else{
                comidas[position].checkeada = true
            }
        }

        val currentComida = comidas[position]
        holder.setListener(currentComida)
        holder.bind(currentComida)
    }

    override fun getItemCount(): Int = comidas.size

    fun addComida(comida: Comida) {
        comidas.add(comida)
        notifyDataSetChanged()
    }

    fun removeComida(comida: Comida, position: Int) {
        comidas.remove(comida)
        notifyItemRemoved(position)
    }
}