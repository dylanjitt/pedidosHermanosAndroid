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
        var botones = listOf(binding.star1,binding.star2,binding.star3,binding.star4,binding.star5)
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
        binding.star1.setOnClickListener{
            change(botones,0)
        }
        binding.star2.setOnClickListener{
            change(botones,1)

        }
        binding.star3.setOnClickListener{
            change(botones,2)

        }
        binding.star4.setOnClickListener{
            change(botones,3)

        }
        binding.star5.setOnClickListener{
            change(botones,4)
        }
    }

    private fun change(tyty: List<ImageButton>, num: Int){
        for (i in 0 .. num){
            tyty[i].setImageResource(R.drawable.star_view_activated)
        }
        tyty.forEach{it.isClickable = false}
        tyty.forEach{it.isEnabled = false}
        Toast.makeText(applicationContext,"Muchas gracias por calificarnos!!",Toast.LENGTH_LONG).show()
    }
}