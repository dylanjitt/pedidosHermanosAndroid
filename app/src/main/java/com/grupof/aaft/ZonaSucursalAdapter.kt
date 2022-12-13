package com.grupof.aaft

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ZonaSucursalAdapter(val zonasLista:List<Zonas>,
                          private val onClickListener:(Int) -> Unit):
    RecyclerView.Adapter<ZonaSucursalHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZonaSucursalHolder {
//        binding = ActivityDireccionPagoBinding.inflate(layoutInflater)
        val layoutInflater = LayoutInflater.from(parent.context)
        return ZonaSucursalHolder(layoutInflater.inflate(R.layout.zona_sucursal,parent,false))
    }

    override fun onBindViewHolder(holder: ZonaSucursalHolder, position: Int) {
        holder.render(zonasLista[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return zonasLista.size
    }
}
