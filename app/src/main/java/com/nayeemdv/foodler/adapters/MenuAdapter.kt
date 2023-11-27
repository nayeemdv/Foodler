package com.nayeemdv.foodler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nayeemdv.foodler.databinding.MenuItemsBinding

class MenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuItemsPrice: MutableList<String>,
    private val menuItemsImage: MutableList<Int>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        return MenuViewHolder(
            MenuItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItemsName[position]
                menuFoodPrice.text = menuItemsPrice[position]
                menuImage.setImageResource(menuItemsImage[position])
            }
        }

    }
}