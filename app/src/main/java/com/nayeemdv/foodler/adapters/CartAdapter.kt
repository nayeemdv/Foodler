package com.nayeemdv.foodler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nayeemdv.foodler.databinding.CartItemBinding

class CartAdapter(
    private val cartItem: MutableList<String>,
    private val cartItemPrice: MutableList<String>,
    private val cartImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItem.size) { 1 }

    inner class CartViewHolder(private val binding: CartItemBinding) : ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text = cartItem[position]
                cartFoodPrice.text = cartItemPrice[position]
                cartFoodImage.setImageResource(cartImage[position])
                cartItemQuantity.text = quantity.toString()

                btnMinus.setOnClickListener {
                    decreaseQuantity(position)
                }

                btnPlus.setOnClickListener {
                    increaseQuantity(position)
                }

                btnDelete.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition!= RecyclerView.NO_POSITION)
                        deleteItem(itemPosition)
                }

            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }


        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun deleteItem(position: Int) {
            cartItem.removeAt(position)
            cartImage.removeAt(position)
            cartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItem.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int = cartItem.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}