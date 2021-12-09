package com.example.wisata_sumatera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_sumatera.adapter.AdapterOlahRaga
import com.example.wisata_sumatera.databinding.OlahragaActivityBinding
import com.example.wisata_sumatera.view.OlahRagaModel

class OlahRagaActivity : AppCompatActivity() {
    private lateinit var olahragaBinding: OlahragaActivityBinding
    private lateinit var olahragaAdapter : AdapterOlahRaga
    private lateinit var olahragaVM : OlahRagaModel
    private lateinit var olahragaRV : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        olahragaBinding = OlahragaActivityBinding.inflate(layoutInflater)
        setContentView(olahragaBinding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val olahActivityTitle = this.getText(R.string.olahraga_list)
        supportActionBar?.apply {
            this@OlahRagaActivity.title = olahActivityTitle
        }

        olahragaAdapter = AdapterOlahRaga()
        olahragaRV = olahragaBinding.olahragaRv

        olahragaBinding.apply {
            olahragaRV.setHasFixedSize(true)
            olahragaRV.layoutManager = LinearLayoutManager(this@OlahRagaActivity)
            olahragaRV.adapter = olahragaAdapter
        }

        olahragaVM = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(OlahRagaModel::class.java)

        val listOlahraga = olahragaVM.getDataOlahraga()
        olahragaAdapter.setOlahraga(listOlahraga)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}