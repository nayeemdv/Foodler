package com.nayeemdv.foodler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nayeemdv.foodler.R
import com.nayeemdv.foodler.adapters.CartAdapter
import com.nayeemdv.foodler.adapters.MenuAdapter
import com.nayeemdv.foodler.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var mAdapter:CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Burger", "Sandwich", "Momo", "item", "Sandwich", "Momo")
        val cartFoodPrice = listOf("$5", "$6", "$8", "$9", "$10", "$10")
        val cartFoodImage =
            listOf(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu6
            )
        val mAdapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartFoodPrice), ArrayList(cartFoodImage))

        binding.rvCart.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }

        return binding.root
    }
}