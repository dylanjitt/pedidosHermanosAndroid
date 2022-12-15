package com.grupof.aaft

import android.app.DownloadManager.Query
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.grupof.aaft.databinding.ActivityMainBinding
import com.grupof.aaft.databinding.MainItemBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var total: Int = 0
    var searchWord: String? = null

    var comidaList = mutableListOf<FoodItem>(
        FoodItem(R.drawable.hamburguesa,"Hamburguesa",25,false,0),
        FoodItem(R.drawable.pizza,"Pizza",50,false,0),
        FoodItem(R.drawable.pollo_frito,"Pollos Hermanos",20,false,0),
        FoodItem(R.drawable.hot_dog,"Hot Dog",8,false,0),
        FoodItem(R.drawable.tacos,"Tacos (3 unidades)",30,false,0),
        FoodItem(R.drawable.club_sandwich,"Club Sandwich",40,false,0)
    )

    var bebidasList = mutableListOf<FoodItem>(
        FoodItem(R.drawable.coca_cola_personal,"Coca Cola Personal", 5,false,0),
        FoodItem(R.drawable.fanta_personal,"Fanta naranja Personal", 5,false,0),
        FoodItem(R.drawable.sprite_personal,"Sprite Personal", 5,false,0),
        FoodItem(R.drawable.coca_2lt,"Coca Cola 2 lt",14,false,0)
    )

    var filteredList = mutableListOf<FoodItem>()

    private lateinit var temporalArrayList: ArrayList<FoodItem>

    val FoodList = mutableListOf<FoodItem>()



    private lateinit var binding: ActivityMainBinding

    //private lateinit var searchView: SearchView


    private val drinkAdapter by lazy { ItemAdapter() }
    private val foodAdapter by lazy { ItemAdapter() }
    private val searchAdapter by lazy {ItemAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        setSearchWord()
        setDefault()


        //searchView = findViewById(R.id.busqueda)
        //searchView.clearFocus()
        //searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        ///    override fun onQueryTextChange(newText: String): Boolean{
        //        filterList(newText)
        //        return true
        //    }
        //    override fun onQueryTextSubmit(query: String): Boolean{
        //        return false
        //    }

        //})

    }


    private fun setSearchWord(){
        binding.botonBuscar.setOnClickListener(){
            searchWord= binding.busquedaa.text.toString()
            filterList(searchWord!!)
        }

    }

    private fun setDefault(){
        binding.deleteWord.setOnClickListener(){
            filteredList.clear()
            searchWord = null
            binding.busquedaa.text.clear()
            searchAdapter.setFilteredList(filteredList)
            binding.deleteWord.visibility = View.GONE
            binding.searchLayout.visibility = View.GONE
            binding.menuLayout.visibility = View.VISIBLE
        }
    }

    private fun filterList(text: String) {


        comidaList.forEach{
            if(it.nombre.lowercase().contains(text.lowercase())){
                filteredList.add(it)
            }
        }

        bebidasList.forEach{
            if(it.nombre.lowercase().contains(text.lowercase())){
                filteredList.add(it)
            }
        }


        searchAdapter.setFilteredList(filteredList)
        binding.deleteWord.visibility = View.VISIBLE
        binding.searchLayout.visibility = View.VISIBLE
        binding.menuLayout.visibility = View.GONE
    }

    private fun setRecyclerView() {

        foodAdapter.addPresentationCards(comidaList)

        drinkAdapter.addPresentationCards(bebidasList)

        searchAdapter.addPresentationCards(filteredList)
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

        binding.searchLayout.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchAdapter

        }

    }

    fun upadteTotal(monto: Int){
               total += monto
        println(total)
               binding.total.text = "Total: $total"
    }

    fun downgradeTotal(monto: Int){
        total -= monto
        println(total)
        binding.total.text = "Total: $total"
    }

}