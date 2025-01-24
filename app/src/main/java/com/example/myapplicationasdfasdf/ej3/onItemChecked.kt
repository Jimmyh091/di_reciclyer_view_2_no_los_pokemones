package com.example.myapplicationasdfasdf.ej3

import androidx.constraintlayout.helper.widget.Carousel.Adapter

interface onItemChecked{
    fun onItemMoved1(item: Comida, position: Int, fromAdapter: ComidaAdapter, toAdapter: ComidaAdapter2)
    fun onItemMoved2(item: Comida, position: Int, fromAdapter: ComidaAdapter2, toAdapter: ComidaAdapter)
}