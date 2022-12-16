package com.grupof.aaft

import android.annotation.SuppressLint
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

    private lateinit var binding: ActivityDireccionPagoBinding

    companion object{
        val MontoTotal: String = "0"
    }

    var zonasDisponibles: List<Zonas> = listOf(
        Zonas(0,"Miraflores"),
        Zonas(1,"Irpavi"),
        Zonas(2,"Irpavi 2"),
        Zonas(3,"Obrajes"),
        Zonas(4,"San Pedro"),
        Zonas(5,"San Antonio"),
        Zonas(6,"Tempbladerani"),
    )

    private lateinit var variableTotal:String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDireccionPagoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.totalDar.text = intent.getStringExtra(MontoTotal).orEmpty()

        variableTotal = binding.totalDar.text.toString()

        binding.zonaRecycler.visibility = View.GONE
        binding.fondoOpcionesZonas.visibility = View.GONE
        iniciarRecyclerView()

        actualizarMontoPago()

        binding.selectingZone.setOnClickListener(){

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

        binding.selectingZone.addTextChangedListener {
            actualizarMontoPago()
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
                enviarMensaje("Direccion no agregada")
            }else if(binding.pagoDar.text.isEmpty() || binding.pagoDar.text.toString().toInt() <
                binding.totalDar.text.toString().toInt()){
                enviarMensaje("Cantidad de dinero insuficiente")
            }else{
                val cambioAhora = Intent(this,Pedido::class.java)
                startActivity(cambioAhora)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun actualizarMontoPago(){
        val aux:Float = if(binding.selectingZone.text.toString().lowercase() == "miraflores"){
            0.2F
        }else if(binding.selectingZone.text.toString().lowercase() == "irpavi"){
            0.3F
        }else if(binding.selectingZone.text.toString().lowercase() == "irpavi 2"){
            0.4F
        }else if(binding.selectingZone.text.toString().lowercase() == "obrajes"){
            0.2F
        }else if(binding.selectingZone.text.toString().lowercase() == "san pedro"){
            0.4F
        }else{
            0.5F
        }

        binding.totalDar.text = "${(variableTotal.toFloat() + variableTotal.toFloat()*aux).toInt()}"

        enviarMensaje("Cobro total actualizado")
    }

    fun enviarMensaje(mensaje:String){
        Toast.makeText(this, mensaje,
            Toast.LENGTH_SHORT).show()
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
