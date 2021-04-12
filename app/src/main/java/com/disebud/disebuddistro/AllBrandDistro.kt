package com.disebud.disebuddistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.disebud.disebuddistro.adapter.AllBrandAdapter
import com.disebud.disebuddistro.model.DistroModel
import kotlinx.android.synthetic.main.content_all_brand.*

class AllBrandDistro : AppCompatActivity() {
    // Inisialisasi
    private var datalist = ArrayList<DistroModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_brand_distro)

        // Menangkap data yang dilempar dari MainActivity
        datalist    = intent.getParcelableArrayListExtra("data")!!

        rv_distro_all.layoutManager = LinearLayoutManager(this)

        rv_distro_all.adapter =
            AllBrandAdapter(datalist) {
                val intent = Intent(this, DetailActivity::class.java)
                    .putExtra("data", it)
                startActivity(intent)
            }
    }
}