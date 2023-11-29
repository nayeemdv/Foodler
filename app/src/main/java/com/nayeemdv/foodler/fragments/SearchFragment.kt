package com.nayeemdv.foodler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.nayeemdv.foodler.R
import com.nayeemdv.foodler.adapters.MenuAdapter
import com.nayeemdv.foodler.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var mAdapter: MenuAdapter
    private val originalMenuName = listOf("Burger", "Sandwich", "Momo", "item", "Sandwich", "Momo")
    private val originalMenuFoodPrice = listOf("$5", "$6", "$8", "$9", "$10", "$10")
    private val originalMenuFoodImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
    )

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuFoodPrice = mutableListOf<String>()
    private val filteredMenuFoodImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        mAdapter = MenuAdapter(filteredMenuFoodName, filteredMenuFoodPrice, filteredMenuFoodImage)

        binding.menuRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }

        //setup search view
        setupSearchView()

        //show all menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuFoodImage.clear()
        filteredMenuFoodPrice.clear()

        filteredMenuFoodName.addAll(originalMenuName)
        filteredMenuFoodPrice.addAll(originalMenuFoodPrice)
        filteredMenuFoodImage.addAll(originalMenuFoodImage)

        mAdapter.notifyDataSetChanged()
    }


    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {

        filteredMenuFoodName.clear()
        filteredMenuFoodImage.clear()
        filteredMenuFoodPrice.clear()


        originalMenuName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuFoodPrice.add(originalMenuFoodPrice[index])
                filteredMenuFoodImage.add(originalMenuFoodImage[index])
            }
        }

        mAdapter.notifyDataSetChanged()

    }
}