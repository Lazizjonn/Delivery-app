package uz.gita.maxwaydemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.model.common.FoodDataRV
import uz.gita.maxwaydemo.databinding.ItemInnerBinding

class FoodAdapter(private val list: List<FoodDataRV>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var foodClickListener: ((String, String, String) -> Unit)? = null

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemInnerBinding.bind(view)

        init {
            itemView.setOnClickListener {
                foodClickListener?.invoke(
                    list[absoluteAdapterPosition].foodName,
                    list[absoluteAdapterPosition].foodPhoto,
                    list[absoluteAdapterPosition].foodDescription
                )
            }
        }

        fun bind() {
            list[absoluteAdapterPosition].apply {
                binding.foodNameUI.text = foodName
                Glide.with(binding.foodPhotoUI)
                    .load(foodPhoto).into(binding.foodPhotoUI)

                binding.foodCostUI.text = foodCost.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_inner, parent, false))

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) = holder.bind()
    override fun getItemCount(): Int = list.size

    fun setFoodClickListener(block: (String, String, String) -> Unit) {
        foodClickListener = block
    }

}