package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Tasks
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.google.firebase.storage.ktx.storage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.model.common.AdPagerData
import uz.gita.maxwaydemo.data.sources.local.model.common.ToolbarData
import uz.gita.maxwaydemo.data.sources.local.model.response.CategoryData
import uz.gita.maxwaydemo.data.sources.local.model.response.FoodData
import uz.gita.maxwaydemo.databinding.FragmentHomeBinding
import uz.gita.maxwaydemo.presentation.viewmodel.HomeViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.IntroViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.HomeViewModelImpl
import uz.gita.maxwaydemo.presentation.viewmodel.impl.IntroViewModelImpl
import uz.gita.maxwaydemo.ui.adapter.AdLoopingPagerAdapter
import uz.gita.maxwaydemo.ui.adapter.AdPagerAdapter2
import uz.gita.maxwaydemo.ui.adapter.CategoryAdapter
import uz.gita.maxwaydemo.ui.adapter.CollapsingToolbarAdapter
import java.io.File

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    private val categoryList: MutableList<CategoryData> = ArrayList()
    private val toolbarList: MutableList<ToolbarData> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdViewPager()
        doubleRecycleView()
        toolbarRecycleView()
    }



    private fun loadDataForDoubleRecycleView() {
        val images = viewModel.loadImagesFromFirebase()
        for (i in 0 until 5) {
            val list = ArrayList<FoodData>()
            for (j in 0 until 9) {
                list.add(FoodData("Food name $i$j", images[j % 6], "Food cost $i*$j)", "Description$i*$j "))
            }
            categoryList.add(CategoryData("Food category $i", list))
        }
    }

    private fun doubleRecycleView() {
        loadDataForDoubleRecycleView()
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

    private fun toolbarRecycleView() {
        loadDataForToolbarRecycleView()
        val adapter = CollapsingToolbarAdapter(toolbarList)
        binding.menuCollapsingToolbarRecyclerview.adapter = adapter
        binding.menuCollapsingToolbarRecyclerview.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun loadDataForToolbarRecycleView() {
        val images = viewModel.loadImagesFromFirebase()
        for (i in 0 until 10) {
            toolbarList.add(ToolbarData(images[i % 6], "ToolbarName $i"))
        }
    }

    private fun setAdViewPager() {
        val list = listOf(
            AdPagerData(R.drawable.lavash_image, "1. Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "2. Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "3. Lavashga hush kelibsiz"),
            AdPagerData(R.drawable.lavash_image, "4. Lavashga hush kelibsiz")
        )

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