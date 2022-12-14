package com.grupof.aaft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.yesButton.setOnClickListener {
            val intentRedirect = Intent(this, MainActivity::class.java)
            startActivity(intentRedirect)
            finish()
        }

        binding.noButtom.setOnClickListener {
            Toast.makeText(applicationContext,"Muchas gracias por usar Pedidos Hermanos!!",Toast.LENGTH_LONG).show()
            finishAffinity();
            System.exit(0);

        }

        binding.star1.setOnClickListener{
            star1ac()
            Toast.makeText(applicationContext,"Muchas gracias por calificarnos!!",Toast.LENGTH_LONG).show()
        }

        binding.star2.setOnClickListener{
            star1ac()
            star2ac()
            Toast.makeText(applicationContext,"Muchas gracias por calificarnos!!",Toast.LENGTH_LONG).show()
        }
        binding.star3.setOnClickListener{
            star1ac()
            star2ac()
            star3ac()
            Toast.makeText(applicationContext,"Muchas gracias por calificarnos!!",Toast.LENGTH_LONG).show()
        }
        binding.star4.setOnClickListener{
            star1ac()
            star2ac()
            star3ac()
            star4ac()
            Toast.makeText(applicationContext,"Muchas gracias por calificarnos!!",Toast.LENGTH_LONG).show()
        }
        binding.star5.setOnClickListener{
            star1ac()
            star2ac()
            star3ac()
            star4ac()
            star5ac()
            Toast.makeText(applicationContext,"Muchas gracias por calificarnos!!",Toast.LENGTH_LONG).show()
        }
    }

    fun star1ac(){
        binding.star1.setImageResource(R.drawable.star_view_activated)
        blockall()
    }
    fun star2ac(){
        binding.star2.setImageResource(R.drawable.star_view_activated)
        blockall()
    }
    fun star3ac(){
        binding.star3.setImageResource(R.drawable.star_view_activated)
        blockall()

    }
    fun star4ac(){
        binding.star4.setImageResource(R.drawable.star_view_activated)
        blockall()

    }
    fun star5ac(){
        binding.star5.setImageResource(R.drawable.star_view_activated)
        blockall()
    }

    fun blockall(){
        binding.star5.isEnabled = false
        binding.star5.isClickable = false
        binding.star4.isEnabled = false
        binding.star4.isClickable = false
        binding.star3.isEnabled = false
        binding.star3.isClickable = false
        binding.star2.isEnabled = false
        binding.star2.isClickable = false
        binding.star1.isEnabled = false
        binding.star1.isClickable = false
    }
}