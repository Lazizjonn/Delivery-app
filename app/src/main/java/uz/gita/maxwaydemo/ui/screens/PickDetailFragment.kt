package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentPickDetailBinding

@AndroidEntryPoint
class PickDetailFragment : Fragment(R.layout.fragment_pick_detail) {

    private val binding by viewBinding(FragmentPickDetailBinding::bind)
    private val navArgs by navArgs<PickDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        textFoodName.text = navArgs.foodname

        Glide.with(binding.imageFood)
            .load(navArgs.foodPhoto)
            .into(binding.imageFood)


    }
}