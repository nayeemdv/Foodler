package com.nayeemdv.foodler.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nayeemdv.foodler.R
import com.nayeemdv.foodler.adapters.MenuAdapter
import com.nayeemdv.foodler.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = listOf("Burger", "Sandwich", "Momo", "item", "Sandwich", "Momo")
        val menuFoodPrice = listOf("$5", "$6", "$8", "$9", "$10", "$10")
        val menuFoodImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
        )

        val mAdapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuFoodPrice),
            ArrayList(menuFoodImage),
        )

        binding.menuRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }

        return binding.root
    }
}