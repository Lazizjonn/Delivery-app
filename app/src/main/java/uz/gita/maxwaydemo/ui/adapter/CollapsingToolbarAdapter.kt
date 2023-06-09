package uz.gita.maxwaydemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.model.common.ToolbarDataRV
import uz.gita.maxwaydemo.databinding.ItemCollapsingToolbarBinding

class CollapsingToolbarAdapter(private val list: List<CategoryDataRV>) : RecyclerView.Adapter<CollapsingToolbarAdapter.CollapsingToolbarViewHolder>() {
    private val listClicked:ArrayList<Int> = ArrayList<Int>(13)

    inner class CollapsingToolbarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCollapsingToolbarBinding.bind(view)

        init {
            binding.menuCollapsingToolbarCardView.setOnClickListener {
                list[absoluteAdapterPosition].apply {
                    binding.menuCollapsingToolbarText.text = categoryName
                    listClicked.add(this.id, id)
                }
            }
        }

        fun bind() {
            list[absoluteAdapterPosition].apply {
                binding.menuCollapsingToolbarText.text = categoryName
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollapsingToolbarViewHolder =
        CollapsingToolbarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_collapsing_toolbar, parent, false))
    override fun onBindViewHolder(holder: CollapsingToolbarViewHolder, position: Int) = holder.bind()
    override fun getItemCount(): Int = list.size
}