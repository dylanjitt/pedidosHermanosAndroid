package com.grupof.aaft

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grupof.aaft.databinding.MainItemBinding


class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val foodItems = mutableListOf<FoodItem>()
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

        
    }

    override fun getItemCount(): Int = foodItems.size

    inner class ItemViewHolder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: FoodItem) {
            binding.food.text = data.nombre
            binding.price.text = "Bs. ${data.precio}"
            binding.comida.setImageResource(data.image)
        }
    }

    fun addPresentationCards(list: List<FoodItem>) {
        foodItems.clear()
        foodItems.addAll(list)
    }
}