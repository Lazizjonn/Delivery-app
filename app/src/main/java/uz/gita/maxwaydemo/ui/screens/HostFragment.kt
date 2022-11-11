package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentHostBinding
import uz.gita.maxwaydemo.ui.adapter.HostViewPagerAdapter
import uz.gita.maxwaydemo.ui.pages.EditProfileFragment
import uz.gita.maxwaydemo.ui.pages.HomeFragment
import uz.gita.maxwaydemo.ui.pages.OrderFragment

@AndroidEntryPoint
class HostFragment : Fragment(R.layout.fragment_host) {
    private val binding by viewBinding(FragmentHostBinding::bind)
    private val mHome = HomeFragment()
    private val mOrder = OrderFragment()
    private val mAccount = EditProfileFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewPagerAdapter = HostViewPagerAdapter(
            listOf(mHome, mOrder, mAccount),
            requireActivity().supportFragmentManager, lifecycle
        )

        binding.mainContainer.adapter = viewPagerAdapter
        binding.mainContainer.isUserInputEnabled = false

        TabLayoutMediator(binding.bottomNav, binding.mainContainer) { tab, position ->
        }.attach()
    }
}