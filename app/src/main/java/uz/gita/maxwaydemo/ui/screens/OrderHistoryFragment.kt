package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentOrderBinding
import uz.gita.maxwaydemo.databinding.FragmentOrderCurrentBinding
import uz.gita.maxwaydemo.databinding.FragmentOrderHistoryBinding

@AndroidEntryPoint
class OrderHistoryFragment : Fragment(R.layout.fragment_order_history) {
    private val binding by viewBinding(FragmentOrderHistoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){





    }

}