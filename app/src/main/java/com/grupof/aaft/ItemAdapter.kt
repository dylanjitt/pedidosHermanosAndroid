package com.grupof.aaft

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grupof.aaft.databinding.MainItemBinding


class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var foodItems = mutableListOf<FoodItem>()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        return ItemViewHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding(foodItems[position])
        holder.click(foodItems, position)

    }

    override fun getItemCount(): Int = foodItems.size

    fun setFilteredList(filteredList: MutableList<FoodItem>){
        this.foodItems = filteredList
        notifyDataSetChanged()

    }

    inner class ItemViewHolder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: FoodItem) {
            binding.food.text = data.nombre
            binding.price.text = "Bs. ${data.precio}"
            binding.comida.setImageResource(data.image)
        }

        fun click(data: MutableList<FoodItem>, posicion: Int){

            binding.anadirFood.setOnClickListener(){
                Log.d("click","si")
                data[posicion].cantidad ++

                    data[posicion].isSelected = true

                    binding.menosFood.visibility = View.VISIBLE
                    binding.quantityFood.visibility= View.VISIBLE
                    binding.quantityFood.text = "${data[posicion].cantidad}"
                (context as MainActivity).upadteTotal( data[posicion].precio)
            }

            binding.menosFood.setOnClickListener(){
                data[posicion].cantidad--
                (context as MainActivity).downgradeTotal( data[posicion].precio)
                if (data[posicion].cantidad==0) {
                    data[posicion].isSelected = false
                        binding.menosFood.visibility = View.GONE
                        binding.quantityFood.visibility= View.GONE
                }else{
                    binding.quantityFood.text = "${data[posicion].cantidad}"
                }

            }


        }




    }

    fun addPresentationCards(list: List<FoodItem>) {
        foodItems.clear()
        foodItems.addAll(list)
    }
}