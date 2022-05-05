package uz.gita.maxwaydemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.bumptech.glide.Glide
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.databinding.ItemAdLayoutBinding


class AdLoopingPagerAdapter(val context: Context, var list: List<AdsDataFromNet>, isInfinite: Boolean)
    : LoopingPagerAdapter<AdsDataFromNet>(list, isInfinite) {


    @JvmName("setList1")
    fun setList(list: List<AdsDataFromNet>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun bindView(convertView: View, listPosition: Int, viewType: Int){
        val binding = ItemAdLayoutBinding.bind(convertView)

        Glide.with(binding.adImage)
            .load(list[listPosition].image)
            .into(binding.adImage)

        val sum = 2 * list[listPosition].id!!
        binding.adTitle.text = ("Qo`shib beramiz: ${list[listPosition].id} + ${list[listPosition].id} = " + sum )

    }


    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View
    = LayoutInflater.from(context).inflate(R.layout.item_ad_layout, container, false);
}