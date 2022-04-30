package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentSplashBinding
import uz.gita.maxwaydemo.presentation.viewmodel.SplashViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.SplashViewModelImpl


@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.openHomeFragmentLiveData.observe(viewLifecycleOwner, openHomeFragmentObserver)
        viewModel.openIntroFragmentLiveData.observe(viewLifecycleOwner, openIntroFragmentObserver)
    }

    private val openHomeFragmentObserver = Observer<Unit>() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHostFragment())
    }

    private val openIntroFragmentObserver = Observer <Unit> {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToIntroFragment())
    }

}