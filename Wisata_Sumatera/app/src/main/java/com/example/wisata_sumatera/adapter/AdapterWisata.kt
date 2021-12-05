package com.example.wisata_sumatera.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata_sumatera.DetailWisata
import com.example.wisata_sumatera.R
import com.example.wisata_sumatera.data.WisataClass
import com.example.wisata_sumatera.databinding.WisataListBinding

class AdapterWisata : RecyclerView.Adapter<AdapterWisata.WisataViewHolder>() {
    private val wisataList = ArrayList<WisataClass>()

    inner class WisataViewHolder (private val wisataBinding: WisataListBinding) : RecyclerView.ViewHolder(wisataBinding.root) {
        fun wisataBind (wisata : WisataClass) {
            wisataBinding.apply {
                Glide.with(itemView.context)
                    .load(wisata.posterClass)
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_white).error(R.drawable.bg_black))
                    .into(wisataPoster)

                wisataTitle.text = wisata.titleClass
                wisataSynopsis.text = wisata.synopsisClass
            }
            itemView.setOnClickListener {
                Intent(itemView.context, DetailWisata::class.java).also {
                    it.putExtra(DetailWisata.EXTRA_DETAIL_WISATA, wisata.titleClass)
                    itemView.context.startActivity(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val wisataView = WisataListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WisataViewHolder(wisataView)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        holder.wisataBind(wisata = wisataList[position])
    }

    override fun getItemCount(): Int = wisataList.size

    fun setWisata (wisata: List<WisataClass>?){
        if (wisata.isNullOrEmpty())
            return
        this.wisataList.clear()
        this.wisataList.addAll(wisata)

    }
}