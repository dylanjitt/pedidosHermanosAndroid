package com.grupof.aaft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.fondoOpcionesZonas.visibility = View.GONE
        iniciarRecyclerView()

        binding.editingZone.setOnClickListener(){
            if(binding.zonaRecycler.visibility == View.GONE){
                binding.zonaRecycler.visibility = View.VISIBLE
                binding.fondoOpcionesZonas.visibility = View.VISIBLE
                binding.zonaOriginal.visibility = View.GONE
            }else{
                binding.zonaRecycler.visibility = View.GONE
                binding.fondoOpcionesZonas.visibility = View.GONE
                binding.zonaOriginal.visibility = View.VISIBLE
            }
        }

        binding.pagoDar.addTextChangedListener {
            if(!binding.pagoDar.text.isEmpty()){
                if(binding.pagoDar.text.toString().toInt()>0 &&
                    !binding.pagoDar.text.isEmpty() &&
                    binding.pagoDar.text.toString().toInt() >= binding.totalDar.text.toString().toInt()){
                    binding.cajaDatos.text = (binding.pagoDar.text.toString().toInt()-binding.totalDar.text.toString().toInt()).toString()
                }else{
                    binding.cajaDatos.text = "0"
                }
            }
        }

        binding.goNext.setOnClickListener{
            if(binding.IntroduccionDatos.text.isEmpty()){
                Toast.makeText(this, "Direccion no agregada",
                    Toast.LENGTH_SHORT).show()
            }else if(binding.pagoDar.text.isEmpty()){
                Toast.makeText(this, "Cantidad de dinero insuficiente",
                    Toast.LENGTH_SHORT).show()
            }else if(binding.pagoDar.text.toString().toInt() <
                binding.totalDar.text.toString().toInt()){
                Toast.makeText(this, "Cantidad de dinero insuficiente",
                    Toast.LENGTH_SHORT).show()
            }else{
                val cambioAhora = Intent(this,Pedido::class.java)
                startActivity(cambioAhora)
            }
        }
    }

    fun iniciarRecyclerView(){
        binding.zonaRecycler.layoutManager = LinearLayoutManager(this)
        binding.zonaRecycler.adapter = ZonaSucursalAdapter(zonasDisponibles
        ,{ llave -> zonaSeleccionada(llave) })
    }

    fun zonaSeleccionada(identificador: Int){
//        Toast.makeText(this,zonasDisponibles[identificador].nombreZona, Toast.LENGTH_SHORT).show()
        binding.selectingZone.text = zonasDisponibles[identificador].nombreZona
        binding.zonaRecycler.visibility = View.GONE
        binding.fondoOpcionesZonas.visibility = View.GONE
        binding.zonaOriginal.visibility = View.VISIBLE
    }
}
