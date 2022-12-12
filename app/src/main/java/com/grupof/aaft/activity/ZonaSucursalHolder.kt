package com.grupof.aaft.activity

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.grupof.aaft.databinding.ActivityDireccionPagoBinding
import com.grupof.aaft.databinding.ZonaSucursalBinding

class ZonaSucursalHolder(view:View): RecyclerView.ViewHolder(view) {

    private var binding = ZonaSucursalBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(zonasDisponibles: Zonas,onClickListener:(Int) -> Unit){
        binding.textSucursal.text = zonasDisponibles.nombreZona
//        binding2.selectingZone.setOnClickListener{
//
//        }
//        binding2.textSucursal.text = "Hola Mundo"
        binding.selectingZone.setOnClickListener{onClickListener(zonasDisponibles.identificacion)}
    }

}