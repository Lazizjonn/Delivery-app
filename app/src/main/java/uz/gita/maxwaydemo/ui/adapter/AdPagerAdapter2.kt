package uz.gita.maxwaydemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.model.common.AdPagerData

// ishlatilmayabdi
class AdPagerAdapter2 (@ApplicationContext private val context: Context,
                       private val list: List<AdPagerData>): PagerAdapter() {

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater.inflate(R.layout.item_ad_layout, null)

        val image = itemView.findViewById<ImageView>(R.id.ad_image)
        val title = itemView.findViewById<TextView>(R.id.ad_title)

        image.setImageResource(list[position].imageView)
        title.text = list[position].title

        val viewPager = container as ViewPager
        viewPager.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewpager = container as ViewPager
        val view = `object` as View
        viewpager.removeView(view)
    }
}