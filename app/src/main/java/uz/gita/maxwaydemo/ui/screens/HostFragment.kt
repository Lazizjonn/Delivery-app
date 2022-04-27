package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HostFragment : Fragment(R.layout.fragment_host) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var transact = childFragmentManager.beginTransaction()
        transact.add(R.id.host_layout, HomeFragment(), "1").commit();
    }


}

