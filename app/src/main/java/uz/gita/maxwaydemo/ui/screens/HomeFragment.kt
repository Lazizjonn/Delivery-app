package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.common.AdPagerData
import uz.gita.maxwaydemo.databinding.FragmentHomeBinding
import uz.gita.maxwaydemo.ui.adapter.AdPagerAdapter2

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding  by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setAdViewPager()
        binding.button.setOnClickListener {
//            findNavController().navigate(R.id.aboutServiceFragment)
        }
    }

    private fun setAdViewPager() {
        val list = listOf(AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"))

        binding.adViewPagerLayout.adapter = AdPagerAdapter2(requireContext(), list )
        autoPaging()
    }

    fun autoPaging(){
        val pager: ViewPager? = binding.adViewPagerLayout
        val handler =  Handler(Looper.getMainLooper())

        lifecycleScope.launch {
            while (true){
                delay(2000)
                handler.post { pager?.let {    // boshqa oynaga o`tganda boshqa oqimda ish bajarilaveradi,
                        when (it.currentItem){      // view o`chib null bo`lganda
                            0 -> { it.setCurrentItem(1) }
                            1 -> { it.setCurrentItem(2) }
                            2 -> { it.setCurrentItem(3) }
                            3 -> { it.setCurrentItem(0) }
                        }
                    }
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

}