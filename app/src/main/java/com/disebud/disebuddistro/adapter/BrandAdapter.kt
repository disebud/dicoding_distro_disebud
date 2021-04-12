package com.disebud.disebuddistro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.disebud.disebuddistro.R
import com.disebud.disebuddistro.model.DistroModel



class BrandAdapter (private var data: List<DistroModel>, private val listerner:(DistroModel) -> Unit) : RecyclerView.Adapter<BrandAdapter.CarViewHolder>() {
    // Inisialisasi
    lateinit var ContextAdapter : Context

    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Inisialisasi View
        private val ivPosterPotrait:ImageView   = view.findViewById(R.id.iv_poster_potrait)
        private val tvNama:TextView   = view.findViewById(R.id.tv_nama)
        private val tvHarga:TextView   = view.findViewById(R.id.tv_harga)

        // Casting View
        fun binItem(data: DistroModel, listener: (DistroModel) -> Unit, context: Context, position: Int) {
            Glide.with(context)
                .load(data.thumbnail_potrait)
                .into(ivPosterPotrait)
            tvNama.text = data.judul
            tvHarga.text = data.price

            itemView.setOnClickListener {
                listener(data)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        // Inisiaslisasi Layout
        val layoutInflater      = LayoutInflater.from(parent.context)
        ContextAdapter          = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.item_brand_distro_horizontal, parent, false)
        return CarViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
       // onBInd
        holder.binItem(data[position], listerner, ContextAdapter, position)
    }
}