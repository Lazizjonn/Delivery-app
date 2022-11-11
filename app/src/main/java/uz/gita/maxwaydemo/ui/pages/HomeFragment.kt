package uz.gita.maxwaydemo.ui.pages

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.model.response.FoodDataFromNet
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
    var adapterList: CategoryAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.adsLiveData.observe(viewLifecycleOwner, adsObserver)
        viewModel.categoryLiveData.observe(viewLifecycleOwner, categoryObserver)
        viewModel.foodsLiveData.observe(viewLifecycleOwner, foodsObserver)
        viewModel.foodsBySearchLiveData.observe(viewLifecycleOwner, foodsBySearchObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.openPickDetailFragmentLiveData.observe(viewLifecycleOwner, openPickDetailFragmentObserver)
        viewModel.openAdvertisementFragmentLiveData.observe(viewLifecycleOwner, openAdvertisementFragmentObserver)
        viewModel.getAllAddsFromRepository()
        viewModel.getAllCategoriesFromRepository(arrayListOf())

    }

    private val adsObserver = Observer<List<AdsDataFromNet>> {
        binding.adViewPagerLayout.adapter = AdLoopingPagerAdapter(requireContext(), it, true)  // LoopingAdapter
    }
    private val categoryObserver = Observer<List<CategoryDataRV>> {
        // CollapsingAdapter
        val adapter = CollapsingToolbarAdapter(it)
        binding.menuCollapsingToolbarRecyclerview.adapter = adapter
        binding.menuCollapsingToolbarRecyclerview.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        // CategoryAdapter
        adapterList = CategoryAdapter(it)
        adapterList!!.setClickCategoryNameListener {
            Toast.makeText(requireContext(), categoryListRV[it].categoryName, Toast.LENGTH_SHORT).show()
        }

        binding.categoryRecyclerviewSelf.adapter = adapterList
        binding.categoryRecyclerviewSelf.layoutManager = LinearLayoutManager(requireContext())
        adapterList?.let { it2 ->
            it2.setFoodClickListener { foodName, foodPhoto, foodDescription ->

            }
        }

    }
    private val foodsObserver = Observer<List<FoodDataFromNet>> { }
    private val foodsBySearchObserver = Observer<List<FoodDataFromNet>> { }
    private val errorObserver = Observer<String> { }
    private val openPickDetailFragmentObserver = Observer<Unit> { }
    private val openAdvertisementFragmentObserver = Observer<Unit> { }


    override fun onResume() {
        binding.adViewPagerLayout.resumeAutoScroll()  // for AutoLoopingViewPager
        super.onResume()
    }

    override fun onPause() {
        binding.adViewPagerLayout.pauseAutoScroll()  // for AutoLoopingViewPager
        super.onPause()
    }

}