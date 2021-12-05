package com.example.wisata_sumatera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata_sumatera.data.WisataClass
import com.example.wisata_sumatera.databinding.DetailWisataActivityBinding
import com.example.wisata_sumatera.view.WisataDetailModel

class DetailWisata : AppCompatActivity() {
    private lateinit var detailWisataBinding: DetailWisataActivityBinding
    private lateinit var detailWisataModel: WisataDetailModel

    companion object {
        const val EXTRA_DETAIL_WISATA = "extra_detail_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailsWisataBinding = DetailWisataActivityBinding.inflate(layoutInflater)
        detailWisataBinding = detailsWisataBinding
        setContentView(detailsWisataBinding.root)

        val wisataDetailTitle = this.getText(R.string.wisata_detail)
        val detailWisata = intent.getStringExtra(EXTRA_DETAIL_WISATA)
        supportActionBar?.apply {
            this@DetailWisata.title = "$wisataDetailTitle : $detailWisata"
        }

        detailWisataModel = WisataDetailModel()
        detailWisataModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            WisataDetailModel::class.java)

        val wisataExtra = intent.extras
        if (wisataExtra != null) {
            val extraWisataTitle = wisataExtra.getString(EXTRA_DETAIL_WISATA)

            if (extraWisataTitle != null) {
                detailWisataModel.setWisataDetail(extraWisataTitle)
                wisataDetail(detailWisataModel.getWisataDetail())
            }
        }
    }

    private fun wisataDetail(wisata: WisataClass) {
        Glide.with(this)
            .load(wisata.posterClass)
            .apply(RequestOptions.placeholderOf(R.drawable.bg_white).error(R.drawable.bg_black))
            .into(detailWisataBinding.wisataPoster)

        detailWisataBinding.wisataLokasiDetail.text = wisata.lokasiClass
        detailWisataBinding.wisataSynopsisDetail.text = wisata.synopsisClass
        detailWisataBinding.wisataTitle.text = wisata.titleClass

    }

}