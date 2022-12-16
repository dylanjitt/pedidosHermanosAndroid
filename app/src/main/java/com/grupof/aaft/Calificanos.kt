package com.grupof.aaft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.grupof.aaft.databinding.ActivityCalificanosBinding
import kotlin.system.exitProcess

class Calificanos : AppCompatActivity() {
    private lateinit var binding: ActivityCalificanosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalificanosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.textIdCali.setOnClickListener {
            Toast.makeText(applicationContext,
                "Muchas Gracias por calificarnos!!", Toast.LENGTH_SHORT).show()
        }

        binding.yesButton.setOnClickListener {
            val intentRedirect = Intent(this, MainActivity::class.java)
            startActivity(intentRedirect)
            finish()
        }

        binding.noButtom.setOnClickListener {
            Toast.makeText(applicationContext,"Muchas gracias por usar Pedidos Hermanos!!",Toast.LENGTH_LONG).show()
            finishAffinity()
            exitProcess(0)
        }

    }

}