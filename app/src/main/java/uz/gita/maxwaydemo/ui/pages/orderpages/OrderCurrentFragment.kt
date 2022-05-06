package uz.gita.maxwaydemo.ui.pages.orderpages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentOrderBinding
import uz.gita.maxwaydemo.databinding.FragmentOrderCurrentBinding

@AndroidEntryPoint
class OrderCurrentFragment : Fragment(R.layout.fragment_order_current) {

    private val binding by viewBinding(FragmentOrderCurrentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){





    }
}