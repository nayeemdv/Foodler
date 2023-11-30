package com.nayeemdv.foodler.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nayeemdv.foodler.R
import com.nayeemdv.foodler.adapters.NotificationAdapter
import com.nayeemdv.foodler.databinding.FragmentNotificationBottomBinding
import java.util.ArrayList

class NotificationBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)

        val notifications = listOf("Your order has been canceled Successfully ","Order has been taken by the driver","Congrats Your Order placed")
        val notficationImages = listOf(R.drawable.sademoji , R.drawable.truck, R.drawable.congrats)
        val mAdapter = NotificationAdapter(ArrayList(notifications) , ArrayList(notficationImages))

        binding.rvNotification.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        return binding.root
    }
}