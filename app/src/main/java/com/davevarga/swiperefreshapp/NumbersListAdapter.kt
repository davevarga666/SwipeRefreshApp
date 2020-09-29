package com.davevarga.swiperefreshapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumbersListAdapter(val numbersList: MutableList<Int>) :
    RecyclerView.Adapter<NumbersListAdapter.NumbersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        return NumbersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_number_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        val number = numbersList[position]
        holder.numberText.text = number.toString()

    }

    override fun getItemCount(): Int {
        return numbersList.size
    }

    class NumbersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var numberText: TextView = itemView.findViewById(R.id.numberTextView)

    }


}

