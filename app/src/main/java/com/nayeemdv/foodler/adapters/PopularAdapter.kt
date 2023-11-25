package com.nayeemdv.foodler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nayeemdv.foodler.databinding.PopularItemBinding

class PopularAdapter(
    private val itemList: List<String>,
    private val prices: List<String>,
    private val images: List<Int>
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = itemList[position]
        val image = images[position]
        val price = prices[position]

        holder.bind(item, price, image)
    }

    inner class PopularViewHolder(private val binding: PopularItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, price: String, image: Int) {
            binding.popularFoodName.text = item
            binding.popularFoodPrice.text = price
            binding.popularFoodImage.setImageResource(image)
        }
    }

}