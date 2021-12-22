package com.example.wisata_sumatera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_sumatera.adapter.AdapterWisata
import com.example.wisata_sumatera.databinding.WisataActivityBinding
import com.example.wisata_sumatera.view.WisataModel

class WisataActivity : AppCompatActivity() {
    private lateinit var wisataBinding: WisataActivityBinding
    private lateinit var wisataAdapter : AdapterWisata
    private lateinit var wisataVM : WisataModel
    private lateinit var wisataRV : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wisataBinding = WisataActivityBinding.inflate(layoutInflater)
        setContentView(wisataBinding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val wisataActivityTitle = this.getText(R.string.wisata_list)
        supportActionBar?.apply {
            this@WisataActivity.title = wisataActivityTitle
        }

        wisataAdapter = AdapterWisata()
        wisataRV = wisataBinding.wisataRv

        wisataBinding.apply {
            wisataRV.setHasFixedSize(true)
            wisataRV.layoutManager = LinearLayoutManager(this@WisataActivity )
            wisataRV.adapter = wisataAdapter
        }

        wisataVM = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(WisataModel::class.java)

        val listWisata = wisataVM.getDataWisata()
        wisataAdapter.setWisata(listWisata)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}