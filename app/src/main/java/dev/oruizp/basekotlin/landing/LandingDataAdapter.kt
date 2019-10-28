package dev.oruizp.basekotlin.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LandingDataAdapter : RecyclerView.Adapter<LandingDataAdapter.LandingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LandingViewHolder(layoutInflater.)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: LandingViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class LandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(itemData: LandingData) {

        }
    }
}