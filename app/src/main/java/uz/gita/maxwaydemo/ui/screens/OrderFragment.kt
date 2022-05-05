package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentOrderBinding
import uz.gita.maxwaydemo.ui.adapter.OrderViewPagerAdapter

@AndroidEntryPoint
class OrderFragment : Fragment(R.layout.fragment_order) {
    private val binding by viewBinding(FragmentOrderBinding::bind)
    private val currentOrderFr = OrderCurrentFragment()
    private val historyOrderFr = OrderHistoryFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewPagerAdapter = OrderViewPagerAdapter(
            listOf(currentOrderFr, historyOrderFr),
            requireActivity().supportFragmentManager, lifecycle
        )


        binding.orderListPager.adapter = viewPagerAdapter

        val title = arrayOf("Current order", "Order history")

        TabLayoutMediator(binding.orderpageTablayout, binding.orderListPager) { tab, position ->
            tab.text = title[position]
        }.attach()  // ViewPager2
//        binding.orderingTablelayout.setupWithViewPager(binding.orderListPager)  // ViewPager1


    }

}