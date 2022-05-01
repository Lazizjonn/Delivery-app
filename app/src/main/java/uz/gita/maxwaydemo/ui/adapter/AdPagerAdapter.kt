package uz.gita.maxwaydemo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// ishlatilmayabdi
class AdPagerAdapter(list: List<Fragment>, fragmentMen: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentMen, lifecycle) {
    private val mList = list

    override fun getItemCount(): Int = mList.size

    override fun createFragment(position: Int): Fragment {
        return mList[position]
    }

}