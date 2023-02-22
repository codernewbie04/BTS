package com.submission.bts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.submission.bts.R
import com.submission.bts.model.TempatWisata

interface OnItemClickListener {
    fun onItemClick(position: Int, data: TempatWisata)
}

class TempatWisataAdapter(val datas: ArrayList<TempatWisata>, private val listener: OnItemClickListener) : RecyclerView.Adapter<TempatWisataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tempat_wisata, parent,false )
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = datas[position].name
        holder.tvAddress.text = datas[position].address
        Picasso.get().load(datas[position].img)
            .into(holder.ivWisata)
    }

    override fun getItemCount(): Int {
        return datas.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position, datas[position])
                }
            }
        }
        val tvTitle : TextView = itemView.findViewById(R.id.tvTitle)
        val tvAddress : TextView = itemView.findViewById(R.id.tvAddress)
        val ivWisata : ShapeableImageView = itemView.findViewById(R.id.ivWisata)
    }


}