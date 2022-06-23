package com.rudimulyadi.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        listPemain.add(Pemain("Cristiano Ronaldo",R.drawable.ronaldo,"Penyerang","1,85 m","Madeira (Portugal)","05 Februari 1985"))
        listPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcelo,"Belakang","1,74 m","Rio de Janeiro (Brasil))","12 Mei 1988"))
        listPemain.add(Pemain("Sergio Ramos García",R.drawable.ramos,"Belakang","1,84 m","Camas (Spanyol)","30 Maret 1986"))
        listPemain.add(Pemain("Zinedine Yazid Zidane",R.drawable.zidan,"Pelatih","1,85 m","Marseille (Prancis)","23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClicklistener{
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }

        })
    }
}