package com.grupof.aaft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.grupof.aaft.databinding.ActivityPedidoBinding

class Pedido : AppCompatActivity() {

    private var activitichange = true
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        object : CountDownTimer(3600, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minute = (millisUntilFinished / 1000) / 60
                val seconds = seconds(millisUntilFinished)
                binding.textView.text = "$minute:$seconds"
            }
            override fun onFinish() {
                if(activitichange)
                    next()
            }

        }.start()

        binding.sillegaAntes.setOnClickListener{
            next()
        }
    }

    fun next(){
        val intent = Intent(this, Calificanos::class.java)
        startActivity(intent)
        finish()
        activitichange = false
    }

    fun seconds(millisUntilFinished: Long): String {
        return if ((millisUntilFinished / 1000) % 60 < 10) {
            "0${(millisUntilFinished / 1000) % 60}"
        } else {
            "${(millisUntilFinished / 1000) % 60}"
        }
    }
 }
