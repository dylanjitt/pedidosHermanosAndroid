package com.grupof.aaft.activity

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import com.grupof.aaft.R
import com.grupof.aaft.databinding.ActivityDireccionPagoBinding

class Activity_Direccion_Pago : AppCompatActivity() {

    private var parentLinearLayout: LinearLayout? = null

    private lateinit var binding: ActivityDireccionPagoBinding

    var zonasDisponibles: List<Zonas> = listOf(
        Zonas(0,"Miraflores"),
        Zonas(1,"Irpavi"),
        Zonas(2,"Irpavi 2"),
        Zonas(3,"Obrajes"),
        Zonas(4,"San Pedro"),
        Zonas(5,"San Antonio"),
        Zonas(6,"Tempbladerani"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDireccionPagoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.zonaRecycler.visibility = View.GONE
        iniciarRecyclerView()

        binding.editingZone.setOnClickListener(){
            if(binding.zonaRecycler.visibility == View.GONE){
                binding.zonaRecycler.visibility = View.VISIBLE
                binding.zonaOriginal.visibility = View.GONE
            }else{
                binding.zonaRecycler.visibility = View.GONE
                binding.zonaOriginal.visibility = View.VISIBLE
            }
        }

    }

    fun iniciarRecyclerView(){
        binding.zonaRecycler.layoutManager = LinearLayoutManager(this)
        binding.zonaRecycler.adapter = ZonaSucursalAdapter(zonasDisponibles) {
            llave -> zonaSeleccionada(llave)
        }
    }

    fun zonaSeleccionada(identificador: Int){
//        Toast.makeText(this,zonasDisponibles[identificador].nombreZona, Toast.LENGTH_SHORT).show()
        binding.textSucursal.text = zonasDisponibles[identificador].nombreZona
        binding.zonaRecycler.visibility = View.GONE
        binding.zonaOriginal.visibility = View.VISIBLE
    }
}
