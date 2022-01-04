//package com.example.verticalviewpager
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class LayoutAdapter(
//    var items : List<View>
//): RecyclerView.Adapter<LayoutAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textViewTitle.text = items[position]
//        holder.layoutScore?.clipToOutline = true
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    class ViewHolder(private var v: View): RecyclerView.ViewHolder(v) {
//        val textViewTitle = v.findViewById<TextView>(R.id.textViewTitle)
//    }
//}