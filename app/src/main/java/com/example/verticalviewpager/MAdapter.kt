package com.example.verticalviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

class MAdapter(
    var items : List<View>
): RecyclerView.Adapter<MAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_fragment, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.container.addView(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(private var v: View): RecyclerView.ViewHolder(v) {
        var container = v.findViewById<FrameLayout>(R.id.container)
    }
}