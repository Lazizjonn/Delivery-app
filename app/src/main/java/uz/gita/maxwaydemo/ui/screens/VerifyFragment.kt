package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentVerifyBinding
import uz.gita.maxwaydemo.presentation.viewmodel.VerifyViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.VerifyViewModelImpl

@AndroidEntryPoint
class VerifyFragment : Fragment(R.layout.fragment_verify) {
    private val binding by viewBinding(FragmentVerifyBinding::bind)
    private val navAgrs by navArgs<VerifyFragmentArgs>()
    private val viewModel: VerifyViewModel by viewModels<VerifyViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        obserVers()
        clicks()

    }

    private fun obserVers() {
        viewModel.authSuccessLiveData.observe(this, authSuccessObserver)
        viewModel.notConnectionLiveData.observe(viewLifecycleOwner, notConnectionObserver)
        viewModel.errorLiveData.observe(this, errorObserver)
        viewModel.moveToNextScreenLiveData.observe(this, moveToNextScreenObserver)


    }


    private fun clicks() = with(binding){

        registerBtnBack.setOnClickListener {

        }


        regProceed.setOnClickListener {
            val code = pinEditText.text.toString()
            if(!code.isEmpty() && code.length == 6) {
                viewModel.registerRequest(navAgrs.regData, code)
            }
        }
    }



    private val moveToNextScreenObserver = Observer<Boolean> {
        if (it){
            findNavController().navigate(R.id.hostFragment)
            clearBackStack(childFragmentManager)
        }
    }

    private val errorObserver = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_SHORT).show()
    }

    private val authSuccessObserver = Observer<Boolean> {
        if (it) {
            Snackbar.make(requireView(), "Signed in successfully", Snackbar.LENGTH_SHORT).show()
        } else{
            Snackbar.make(requireView(), "SignIn failed", Snackbar.LENGTH_SHORT).show()
        }
    }

    private val notConnectionObserver = Observer<Boolean> {
        // progressBar todo
    }
    private fun clearBackStack(fragmentManager: FragmentManager) {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            val entry: FragmentManager.BackStackEntry = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(entry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

}

