package uz.gita.maxwaydemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asksira.loopingviewpager.LoopingPagerAdapter
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.common.AdPagerData
import uz.gita.maxwaydemo.databinding.ItemAdLayoutBinding


class AdLoopingPagerAdapter(val context: Context,val list: List<AdPagerData>, isInfinite: Boolean): LoopingPagerAdapter<AdPagerData>(list, isInfinite) {


    override fun bindView(convertView: View, listPosition: Int, viewType: Int){
        val binding = ItemAdLayoutBinding.bind(convertView)

        binding.adImage.setImageResource(list[listPosition].imageView)
        binding.adTitle.text = list[listPosition].title

    }


    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View
    = LayoutInflater.from(context).inflate(R.layout.item_ad_layout, container, false);
}