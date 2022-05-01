package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.common.AdPagerData
import uz.gita.maxwaydemo.data.sources.model.response.CategoryData
import uz.gita.maxwaydemo.data.sources.model.response.FoodData
import uz.gita.maxwaydemo.databinding.FragmentHomeBinding
import uz.gita.maxwaydemo.ui.adapter.AdPagerAdapter2
import uz.gita.maxwaydemo.ui.adapter.CategoryAdapter
import uz.gita.maxwaydemo.ui.adapter.AdLoopingPagerAdapter

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val images = ArrayList<Int>()
    private val categoryList: MutableList<CategoryData> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdViewPager()

        loadImages()
        loadData()


        val adapter = CategoryAdapter(categoryList)

        adapter.setClickCategoryNameListener {
            Toast.makeText(requireContext(), categoryList[it].categoryName, Toast.LENGTH_SHORT).show()
        }

        adapter.setFoodClickListener { foodName, foodPhoto, foodDescription ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPickDetailFragment(foodName, foodPhoto, foodDescription))
        }

        binding.categoryRecyclerviewSelf.adapter = adapter
        binding.categoryRecyclerviewSelf.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadImages() {
        images.add(R.drawable.group_1)
        images.add(R.drawable.group_2)
        images.add(R.drawable.group_3)
        images.add(R.drawable.group_4)
        images.add(R.drawable.group_1)
        images.add(R.drawable.group_2)
    }

    private fun loadData() {
        for (i in 0 until 5) {
            val list = ArrayList<FoodData>()
            for (j in 0 until 9) {
                list.add(FoodData("Food name $i$j", images[j % 6], "Food cost $i*$j)", "Description$i*$j "))
            }
            categoryList.add(CategoryData("Food category $i", list))
        }
    }

    private fun setAdViewPager() {
        val list = listOf(
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "Lavashga hush kelibsiz")
        )
        val list = listOf(AdPagerData(R.drawable.lavash_image, "1. Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "2. Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "3. Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "4. Lavashga hush kelibsiz"))

        binding.adViewPagerLayout.adapter = AdPagerAdapter2(requireContext(), list)
        autoPaging()
//        binding.adViewPagerLayout.adapter = AdPagerAdapter2(requireContext(), list ) // notLoopingAdapter
        binding.adViewPagerLayout.adapter = AdLoopingPagerAdapter(requireContext(), list, true)  // LoopingAdapter

//        autoPaging()  // kerakmas
    }

    private fun autoPaging() {
        val pager: ViewPager? = binding.adViewPagerLayout
        val handler = Handler(Looper.getMainLooper())

        lifecycleScope.launch {
            while (true) {
                delay(2000)
                handler.post {
                    pager?.let {    // boshqa oynaga o`tganda boshqa oqimda ish bajarilaveradi,
                        when (it.currentItem) {      // view o`chib null bo`lganda
                            0 -> {
                                it.setCurrentItem(1)
                            }
                            1 -> {
                                it.setCurrentItem(2)
                            }
                            2 -> {
                                it.setCurrentItem(3)
                            }
                            3 -> {
                                it.setCurrentItem(0)
                            }
                        }
                    }
                }
            }
        }
    }


    override fun onResume() {
        binding.adViewPagerLayout.resumeAutoScroll()  // for AutoLoopingViewPager
        super.onResume()
    }

    override fun onPause() {
        binding.adViewPagerLayout.pauseAutoScroll()  // for AutoLoopingViewPager
        super.onPause()
    }


}