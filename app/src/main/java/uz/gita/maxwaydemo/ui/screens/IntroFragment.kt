package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.common.IntroData
import uz.gita.maxwaydemo.databinding.FragmentIntroBinding
import uz.gita.maxwaydemo.presentation.viewmodel.IntroViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.IntroViewModelImpl
import uz.gita.maxwaydemo.ui.adapter.IntroAdapter

@AndroidEntryPoint
class IntroFragment : Fragment(R.layout.fragment_intro) {

    private val binding by viewBinding(FragmentIntroBinding::bind)
    private val viewModel: IntroViewModel by viewModels<IntroViewModelImpl>()
    private lateinit var adapter: IntroAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        adapter = IntroAdapter()
        adapter.submitList(viewModel.setData())
        introViewPager.adapter = adapter
        TabLayoutMediator(introTabLayout, introViewPager) { tab, position -> }.attach()

        introViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    3 -> introButtonSkip.text = "Enter"
                    else -> introButtonSkip.text = "Skip"
                }
            }
        })


        introButtonSkip.setOnClickListener { viewModel.clickedEnterOrSkip() }

        viewModel.openHomeFragmentLiveData.observe(viewLifecycleOwner, openHomeFragmentObserver)

    }

    private val openHomeFragmentObserver = Observer<Unit> {
        findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToHomeFragment())
    }
}