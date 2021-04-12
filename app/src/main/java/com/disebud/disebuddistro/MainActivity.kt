package com.disebud.disebuddistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.disebud.disebuddistro.adapter.BrandAdapter
import com.disebud.disebuddistro.model.DistroModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Inisialisasi
    private var datalist = ArrayList<DistroModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi layout Recyclerview
        rv_distro_brand.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // LoadDatasample
        loadDataSample();

        // Menampilkan recyclerview ( Detail Activity ketika diklik )
        rv_distro_brand.adapter = BrandAdapter(datalist){
            // Menampilkan Data ke Page Detail (Melempar data ke DetailActivity)
            val intent =    Intent(this, DetailActivity::class.java)
                    .putExtra("data", it)
            startActivity(intent)

        }

        // Fungsi View All Ketika diKlik
        tv_viewall.setOnClickListener {
            // Menampikan data ke page detail (Berpindah dengan membawa data ke AllCarActivity)
            val intent = Intent(this, AllBrandDistro::class.java)
                    .putExtra("data", datalist)
            startActivity(intent)
        }
    }

    // Memunculkan Menu About di ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inisialisasi Menu
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Inisialisasi Item yang ada pada menu
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        // Casting item menu
        when (selectedMode) {
            R.id.about -> {
                val aboutIntent = Intent(this@MainActivity, AboutAct::class.java)
                startActivity(aboutIntent)
            }
        }
    }

    // Function loadDataSampe
    private fun loadDataSample() {
        datalist.add(
                DistroModel(
                        "01",
                        "Bekasi Versus",
                        "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.120.000",
                        R.drawable.distro1_bekasi,
                        R.drawable.distro1_bekasi,
                        rating = 4.5f
                )
        )

        datalist.add(
                DistroModel(
                        "02",
                        "Bloods Darah",
                        "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.100.000",
                        R.drawable.distro2_bloods,
                        R.drawable.distro2_bloods,
                        rating = 5.6f
                )
        )

        datalist.add(
                DistroModel(
                        "03",
                        "Flava larva",
                        "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp. 110.000",
                        R.drawable.distro3_flava,
                        R.drawable.distro3_flava,
                        rating = 4.0f
                )
        )

        datalist.add(
                DistroModel(
                        "04",
                        "Rose Mawar ",
                        "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp. 75.000",
                        R.drawable.distro4_mawar,
                        R.drawable.distro4_mawar,
                        rating = 4.9f
                )
        )

        datalist.add(
                DistroModel(
                        "05",
                        "Ice Skymo Seger",
                    "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.90.000",
                        R.drawable.distro5_skymo,
                        R.drawable.distro5_skymo,
                        rating = 3.8f
                )
        )

        datalist.add(
                DistroModel(
                        "06",
                        "Sobat Ambyar",
                    "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                    "Rp.95.000",
                    R.drawable.distro6_ambyar,
                        R.drawable.distro6_ambyar,
                        rating = 5.2f
                )
        )

        datalist.add(
                DistroModel(
                        "07",
                        "Adik Diatas",
                    "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.120.000",
                        R.drawable.distro7_adidas,
                        R.drawable.distro7_adidas,
                        rating = 5.0f
                )
        )

        datalist.add(
                DistroModel(
                        "08",
                        "Root Akar",
                    "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.70.000",
                        R.drawable.distro8_root,
                        R.drawable.distro8_root,
                        rating = 4.8f
                )
        )

        datalist.add(
                DistroModel(
                        "09",
                        "Rizqi Ilahi",
                    "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.80.000",
                        R.drawable.distro9_rizqi,
                        R.drawable.distro9_rizqi,
                        rating = 5.0f
                )
        )

        datalist.add(
                DistroModel(
                        "10",
                        "Sch,id Sekolah",
                    "Brand Ternama dikalangan anak muda .. yoi .jenis toko di Indonesia yang menjual pakaian dan aksesori yang dititipkan oleh pembuat pakaian, atau diproduksi sendiri. Distro umumnya merupakan industri kecil dan menengah yang sandang dengan merk independen yang dikembangkan kalangan muda.",
                        "Rp.100.000",
                        R.drawable.distro10_sch,
                        R.drawable.distro10_sch,
                        rating = 4.5f
                )
        )

    }
}