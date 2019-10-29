package dev.oruizp.basekotlin.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.oruizp.basekotlin.R
import kotlinx.android.synthetic.main.item_landing.view.*

class LandingDataAdapter(
    private val clickListener: ItemClickListener,
    var itemList: List<LandingData> = listOf()
) : RecyclerView.Adapter<LandingDataAdapter.LandingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LandingViewHolder(layoutInflater.inflate(R.layout.item_landing, parent, false))
    }

    override fun getItemCount(): Int {
        return if (itemList.isNotEmpty()) itemList.size else 0
    }

    override fun onBindViewHolder(holder: LandingViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }

    inner class LandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(itemData: LandingData) {
            itemView.textViewItem.text = itemData.title
            itemView.setOnClickListener {
                clickListener.onItemClicked(itemData)
            }
        }
    }
}