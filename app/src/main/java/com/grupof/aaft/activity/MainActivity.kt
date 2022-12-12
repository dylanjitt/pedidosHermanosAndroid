package com.grupof.aaft.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grupof.aaft.R
import com.grupof.aaft.databinding.ActivityDireccionPagoBinding
import com.grupof.aaft.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.cambioAhora.setOnClickListener(){
            val intentoDos = Intent(this,Activity_Direccion_Pago::class.java)
            startActivity(intentoDos)
        }
    }
}