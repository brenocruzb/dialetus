package com.jcaique.dialetus.presentation.regions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcaique.dialetus.domain.models.Region
import com.jcaique.dialetus.presentation.R
import kotlinx.android.synthetic.main.item_region.view.*

internal class RegionAdapter(
  private val presentation: RegionsPresentation,
  private val onClicked: (Region) -> Unit
) : RecyclerView.Adapter<RegionAdapter.RegionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_region, parent, false)
        return RegionHolder(view)
    }

    override fun getItemCount() = presentation.regions.size

    override fun onBindViewHolder(holder: RegionHolder, position: Int) {
        holder.bind(presentation.regions[position])
    }

    inner class RegionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(row: Region) = itemView.apply {
            regionName.text = row.name

            setOnClickListener { onClicked(row) }
        }
    }
}
