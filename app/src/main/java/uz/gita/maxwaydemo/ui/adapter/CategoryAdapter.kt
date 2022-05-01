package uz.gita.maxwaydemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.model.response.CategoryData
import uz.gita.maxwaydemo.databinding.ItemOutherBinding

class CategoryAdapter(private val list: List<CategoryData>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var clickCategoryNameListener: ((Int) -> Unit)? = null
    private var foodClickListener: ((String, Int, String) -> Unit)? = null

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemOutherBinding.bind(view)

        init {
            binding.foodTypeUI.setOnClickListener {
                clickCategoryNameListener?.invoke(absoluteAdapterPosition)
            }
        }

        fun bind() {
            list[absoluteAdapterPosition].apply {
                binding.foodTypeUI.text = categoryName
                val adapter = FoodAdapter(list)
                adapter.setFoodClickListener { foodName, foodPhoto, foodDescription ->
                    foodClickListener?.invoke(foodName, foodPhoto, foodDescription)
                }
                binding.innerList.adapter = adapter
                binding.innerList.layoutManager = GridLayoutManager(itemView.context, 2, GridLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_outher, parent, false))

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = list.size

    fun setClickCategoryNameListener(block: (Int) -> Unit) {
        clickCategoryNameListener = block
    }

    fun setFoodClickListener(block: (String, Int, String) -> Unit) {
        foodClickListener = block
    }

}