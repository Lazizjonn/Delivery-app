package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.sources.model.common.FoodDataRV
import uz.gita.maxwaydemo.data.sources.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.sources.model.response.FoodDataFromNet
import uz.gita.maxwaydemo.databinding.FragmentHomeBinding
import uz.gita.maxwaydemo.presentation.viewmodel.HomeViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.HomeViewModelImpl
import uz.gita.maxwaydemo.ui.adapter.AdLoopingPagerAdapter
import uz.gita.maxwaydemo.ui.adapter.CategoryAdapter
import uz.gita.maxwaydemo.ui.adapter.CollapsingToolbarAdapter

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    private val categoryListRV: MutableList<CategoryDataRV> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        doubleRecycleView()
//        toolbarRecycleView()


        viewModel.adsLiveData.observe(viewLifecycleOwner, adsObserver)
        viewModel.categoryLiveData.observe(viewLifecycleOwner,categoryObserver)
        viewModel.foodsLiveData.observe(viewLifecycleOwner, foodsObserver)
        viewModel.foodsBySearchLiveData.observe(viewLifecycleOwner, foodsBySearchObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.openPickDetailFragmentLiveData.observe(viewLifecycleOwner, openPickDetailFragmentObserver)
        viewModel.openAdvertisementFragmentLiveData.observe(viewLifecycleOwner, openAdvertisementFragmentObserver)

    }

    private val adsObserver = Observer<List<AdsDataFromNet>> {
        Log.d("TAG", "adsList size: " + it.size)
//        adsAdapter.setList(it)
        binding.adViewPagerLayout.adapter = AdLoopingPagerAdapter(requireContext(), it, true)  // LoopingAdapter
    }

    private val categoryObserver = Observer<List<CategoryDataRV>> {
        // CollapsingAdapter
        val adapter = CollapsingToolbarAdapter(it)
        binding.menuCollapsingToolbarRecyclerview.adapter = adapter
        binding.menuCollapsingToolbarRecyclerview.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)


        // CategoryAdapter
        val adapterList = CategoryAdapter(it)
        adapterList.setClickCategoryNameListener {
            Toast.makeText(requireContext(), categoryListRV[it].categoryName, Toast.LENGTH_SHORT).show()
        }
        adapterList.setFoodClickListener { foodName, foodPhoto, foodDescription ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPickDetailFragment(foodName, foodPhoto, foodDescription))
        }
        binding.categoryRecyclerviewSelf.adapter = adapterList
        binding.categoryRecyclerviewSelf.layoutManager = LinearLayoutManager(requireContext())




    }
    private val foodsObserver = Observer<List<FoodDataFromNet>> { }
    private val foodsBySearchObserver = Observer<List<FoodDataFromNet>> { }
    private val errorObserver = Observer<String> { }
    private val openPickDetailFragmentObserver = Observer<Unit> { }
    private val openAdvertisementFragmentObserver = Observer<Unit> { }

/*    private fun toolbarRecycleView() {
        loadDataForToolbarRecycleView()
        val adapter = CollapsingToolbarAdapter(toolbarList)
        binding.menuCollapsingToolbarRecyclerview.adapter = adapter
        binding.menuCollapsingToolbarRecyclerview.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }*/









    private fun loadDataForDoubleRecycleView() {
        val images = viewModel.loadImagesFromFirebase()
        for (i in 0 until 5) {
            val list = ArrayList<FoodDataRV>()
            for (j in 0 until 9) {
//                list.add(FoodDataRV("Food name $i$j", images[j % 6], "Food cost $i*$j)", "Description$i*$j "))
            }
            categoryListRV.add(CategoryDataRV(0,"Food category $i", list))
        }
    }

    private fun doubleRecycleView() {
        loadDataForDoubleRecycleView()
        val adapter = CategoryAdapter(categoryListRV)
        adapter.setClickCategoryNameListener {
            Toast.makeText(requireContext(), categoryListRV[it].categoryName, Toast.LENGTH_SHORT).show()
        }
        adapter.setFoodClickListener { foodName, foodPhoto, foodDescription ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPickDetailFragment(foodName, foodPhoto, foodDescription))
        }
        binding.categoryRecyclerviewSelf.adapter = adapter
        binding.categoryRecyclerviewSelf.layoutManager = LinearLayoutManager(requireContext())
    }

   /* private fun setAdViewPager() {
        val list = listOf<AdsDataFromNet>()
        adsAdapter = AdLoopingPagerAdapter(requireContext(), list, true)  // LoopingAdapter
//        binding.adViewPagerLayout.adapter = adsAdapter
    }*/

    override fun onResume() {
        binding.adViewPagerLayout.resumeAutoScroll()  // for AutoLoopingViewPager
        super.onResume()
    }

    override fun onPause() {
        binding.adViewPagerLayout.pauseAutoScroll()  // for AutoLoopingViewPager
        super.onPause()
    }


}