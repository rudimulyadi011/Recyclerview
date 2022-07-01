package com.rudimulyadi.recyclerview
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.rudimulyadi.recyclerview.databinding.ActivityMainBinding
import com.rudimulyadi.recycleview.adapter.AdapterTeamBola
import com.rudimulyadi.recycleview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Keylor Antonio Navas Gamboa",R.drawable.navas,"Penjaga Gawang","1,84 m","Perez Zeledon (Costa Rica)","15 Desember 1986"))
        listPemain.add(Pemain("Cristiano Ronaldo dos Santos Aveiro",R.drawable.ronaldo,"Penyerang","1,87 m","Funchal,Madeira (Portugal)","05 Februari 1985"))
        listPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcelo,"Belakang","1,74 m","Rio de Janeiro (Brasil))","12 Mei 1988"))
        listPemain.add(Pemain("Sergio Ramos García",R.drawable.ramos,"Belakang","1,84 m","Camas (Spanyol)","30 Maret 1986"))
        listPemain.add(Pemain("Zinedine Yazid Zidane",R.drawable.zidan,"Pelatih","1,85 m","Marseille (Prancis)","23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClicklistener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tanggallahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }



                }.show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int){
        when (selectedMode){
            R.id.myprofile -> {
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}