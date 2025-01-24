package com.example.myapplicationasdfasdf.ej3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationasdfasdf.R
import com.example.myapplicationasdfasdf.databinding.ItemComidaBinding

class ComidaAdapter2 (var comidas : MutableList<Comida>, private val listener: OnClickListener, private val mover: onItemChecked, private var contexto: Context? = null) : RecyclerView.Adapter<ComidaAdapter2.ComidaViewHolder>() {

    private lateinit var toAdapter: ComidaAdapter

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

        fun bind(ficha: Comida) {
            checkBox.text = ficha.nombre
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

    override fun getItemCount(): Int = comidas.size

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {

        holder.binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mover.onItemMoved2(comidas[position], position, this@ComidaAdapter2, toAdapter)
            }
        }

        val currentComida = comidas[position]
        holder.setListener(currentComida)
        holder.bind(currentComida)
    }

    fun addComida(comida: Comida) {
        comidas.add(comida)
        notifyDataSetChanged()
    }

    fun removeComida(comida: Comida, position: Int) {
        comidas.remove(comida)
        notifyItemRemoved(position)
    }

    fun setAdapter(adapter: ComidaAdapter) {
        toAdapter = adapter
    }

}