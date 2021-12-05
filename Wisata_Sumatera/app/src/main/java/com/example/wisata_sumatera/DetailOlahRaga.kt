package com.example.wisata_sumatera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata_sumatera.data.OlahRagaClass
import com.example.wisata_sumatera.databinding.DetailOlahragaActivityBinding
import com.example.wisata_sumatera.view.OlahRagaDetailModel

class DetailOlahRaga : AppCompatActivity() {
    private lateinit var detailOlahragaBinding: DetailOlahragaActivityBinding
    private lateinit var detailOlahragaModel: OlahRagaDetailModel

    companion object {
        const val EXTRA_DETAIL_OLAHRAGA = "extra_detail+olahraga"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailsOlahragaBinding = DetailOlahragaActivityBinding.inflate(layoutInflater)
        detailOlahragaBinding = detailsOlahragaBinding
        setContentView(detailsOlahragaBinding.root)

        val olahragaDetailTitle = this.getText(R.string.olahraga_detail)
        val detailOlahraga= intent.getStringExtra(EXTRA_DETAIL_OLAHRAGA)
        supportActionBar?.apply {
            this@DetailOlahRaga.title = "$olahragaDetailTitle : $detailOlahraga"
        }

        detailOlahragaModel = OlahRagaDetailModel()
        detailOlahragaModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            OlahRagaDetailModel::class.java)

        val olahragaExtra = intent.extras
        if (olahragaExtra != null) {
            val extraOlahragaTitle = olahragaExtra.getString(EXTRA_DETAIL_OLAHRAGA)

            if (extraOlahragaTitle != null) {
                detailOlahragaModel.setOlahragaDetail(extraOlahragaTitle)
                olahragaDetail(detailOlahragaModel.getOlahragaDetail())
            }
        }

    }

    private fun olahragaDetail (olahraga : OlahRagaClass) {
        Glide.with(this)
            .load(olahraga.posterClass)
            .apply(RequestOptions.placeholderOf(R.drawable.bg_white).error(R.drawable.bg_black))
            .into(detailOlahragaBinding.olahragaPoster)

        detailOlahragaBinding.olahragaTitle.text = olahraga.titleClass
        detailOlahragaBinding.olahragaLokasiDetail.text = olahraga.lokasiClass
        detailOlahragaBinding.olahragaSynopsisDetail.text = olahraga.synopsisClass

    }
}