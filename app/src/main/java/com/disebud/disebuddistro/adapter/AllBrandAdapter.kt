package com.disebud.disebuddistro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.disebud.disebuddistro.R
import com.disebud.disebuddistro.model.DistroModel


class AllBrandAdapter (private var data: List<DistroModel>, private val listner:(DistroModel) -> Unit ) : RecyclerView.Adapter<AllBrandAdapter.CarMovieHolder>() {

    // Inisialisasi
    lateinit var ContextAdapter : Context

    class CarMovieHolder(view : View) : RecyclerView.ViewHolder(view) {
        // Inisialisasi view
        private val ivPosterLandscape:ImageView     = view.findViewById(R.id.iv_poster_landscape)
        private val tvJudul:TextView                = view.findViewById(R.id.tv_judul)
        private val tvPrice:TextView                = view.findViewById(R.id.tv_price)
        private val rbCar:RatingBar                 = view.findViewById(R.id.ratingbar1)
        private val start1:TextView                 = view.findViewById(R.id.start1)

        // Menampilkan data yang ada di CarModel
        fun binItem(data: DistroModel, listener: (DistroModel)-> Unit, context: Context, position: Int) {
            // textview
            tvJudul.text    = data.judul
            tvPrice.text    = data.price

            // Imageview
            Glide.with(context)
                .load(data.thumbnail_landscape)
                .into(ivPosterLandscape)

           // RatingBar
            rbCar.rating    = data.rating
            start1.text     = data.rating.toString()

            // itemView ketika di klik membawa data
            itemView.setOnClickListener {
                listener(data)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarMovieHolder {
        // Inisialisasi Layout
        val layoutInflater      = LayoutInflater.from(parent.context)
        ContextAdapter          = parent.context

        val inflatedView: View  = layoutInflater.inflate(R.layout.item_brand_distro_vertical, parent, false)
        return CarMovieHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CarMovieHolder, position: Int) {
        // OnBind
        // Menghubungkan dan memanggil kelas bindItem
        holder.binItem(data[position], listner, ContextAdapter, position)

    }
}