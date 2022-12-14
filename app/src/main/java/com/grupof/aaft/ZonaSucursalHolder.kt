package com.grupof.aaft

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.grupof.aaft.Zonas
import com.grupof.aaft.databinding.ZonaSucursalBinding

class ZonaSucursalHolder(view:View): RecyclerView.ViewHolder(view) {

    private var binding = ZonaSucursalBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(zonasDisponibles: Zonas, onClickListener:(Int) -> Unit){
        binding.selectingZone.text = zonasDisponibles.nombreZona
//        binding2.selectingZone.setOnClickListener{
//
//        }
//        binding2.textSucursal.text = "Hola Mundo"
        binding.selectingZone.setOnClickListener{onClickListener(zonasDisponibles.identificacion)}
    }

}
