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

/*        var transact = childFragmentManager.beginTransaction()
        active = HomeFragment()
        transact.add(R.id.main_container, active, "4").commit()

        binding.bottomNav.setOnNavigationItemSelectedListener {

            transact = childFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.menu_home -> {
                    transact.remove(active).add(R.id.main_container, mHome, "1").commit()
                    active = mHome
                }
                R.id.menu_orders -> {
                    transact.remove(active).add(R.id.main_container, mOrder, "2").commit()
                    active = mOrder
                }
                else -> {
                    transact.remove(active).add(R.id.main_container, mAccount, "3").commit()
                    active = mAccount
                }
            }
            true
        }

        mHome.adapterList?.let {
            it.setFoodClickListener { foodName, foodPhoto, foodDescription ->
                findNavController().navigate(HostFragmentDirections.actionHostFragmentToPickDetailFragment(foodName, foodPhoto, foodDescription ))
            }
        }*/