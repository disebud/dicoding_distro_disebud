package com.disebud.disebuddistro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.disebud.disebuddistro.model.DistroModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        // Menangkap Value dari MainActivity
        val data = intent.getParcelableExtra<DistroModel>("data") // Pastikan getParcelableExtra jangan sampai keliru

        // Inisialisasi (Menampilkan data sesuai id)
        tv_judul.text       = data?.judul
        tv_desc.text        = data?.desc
        tv_price.text       = data?.price
        start.text = data?.rating!!.toString()
        ratingbar.rating    = data?.rating!!

       // Menampilkan Gambar
        Glide.with(view) // untuk menampilkan gambar gunakan view
            .load(data.thumbnail_landscape)
            .into(iv_poster_landscape)


        val btnBookNow: Button = findViewById(R.id.btn_booknow)
        btnBookNow.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@DetailActivity, "Anda akan membeli " +data?.judul + " ,Silahkan ke Pembayaran", Toast.LENGTH_SHORT).show()
        })


    }
}