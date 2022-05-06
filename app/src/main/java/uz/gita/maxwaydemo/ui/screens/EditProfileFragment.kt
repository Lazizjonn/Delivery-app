package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.presentation.viewmodel.EditProfileViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.EditProfileViewModelImpl

@AndroidEntryPoint
class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {
    private val viewModel: EditProfileViewModel by viewModels<EditProfileViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        viewModel.signInUserLiveData.observe(viewLifecycleOwner, signInUserObserver)
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkUser()

    }

    private val signInUserObserver = Observer<Unit> {
        findNavController().navigate(R.id.registerPhoneFragment)
    }


}