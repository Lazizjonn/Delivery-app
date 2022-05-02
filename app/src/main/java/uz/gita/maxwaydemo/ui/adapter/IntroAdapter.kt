package uz.gita.maxwaydemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.model.common.IntroData


class IntroAdapter : RecyclerView.Adapter<IntroAdapter.Holder>() {
    private val data: MutableList<IntroData> = ArrayList()

    fun submitList(list: MutableList<IntroData>) {
        data.clear()
        data.addAll(list)
        notifyItemRangeInserted(0, list.size - 1)
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val background: FrameLayout = itemView.findViewById(R.id.intro_container)
        private val image: AppCompatImageView = itemView.findViewById(R.id.intro_image)
        fun bind() {
            background.setBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    data[absoluteAdapterPosition].background
                )
            )

            image.setImageResource(data[absoluteAdapterPosition].image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_intro, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind()

    override fun getItemCount(): Int = data.size
}