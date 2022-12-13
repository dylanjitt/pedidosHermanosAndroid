package com.grupof.aaft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.grupof.aaft.databinding.ActivityMainBinding
import com.grupof.aaft.databinding.MainItemBinding

class MainActivity : AppCompatActivity() {

    var total: Int? = null
    var cont: Int = 0

    val comidaList = mutableListOf<FoodItem>(
        FoodItem(R.drawable.hamburguesa,"Hamburguesa",25,false,0),
        FoodItem(R.drawable.pizza,"Pizza",50,false,0),
        FoodItem(R.drawable.pollo_frito,"Pollos Hermanos",20,false,0),
        FoodItem(R.drawable.hot_dog,"Hot Dog",8,false,0),
        FoodItem(R.drawable.tacos,"Tacos (3 unidades)",30,false,0),
        FoodItem(R.drawable.club_sandwich,"Club Sandwich",40,false,0)
    )

    val bebidasList = mutableListOf<FoodItem>(
        FoodItem(R.drawable.coca_cola_personal,"Coca Cola Personal", 5,false,0),
        FoodItem(R.drawable.fanta_personal,"Fanta naranja Personal", 5,false,0),
        FoodItem(R.drawable.sprite_personal,"Sprite Personal", 5,false,0),
        FoodItem(R.drawable.coca_2lt,"Coca Cola 2 lt",14,false,0)

    )

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemBinding: MainItemBinding

    private val drinkAdapter by lazy { ItemAdapter() }
    private val foodAdapter by lazy { ItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()


        itemBinding.anadirFood.setOnClickListener(){
            comidaList

        }
    }

    private fun setRecyclerView() {

        foodAdapter.addPresentationCards(comidaList)

        drinkAdapter.addPresentationCards(bebidasList)

        binding.menu.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = foodAdapter
        }

        binding.bebidas.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = drinkAdapter
        }

    }




}