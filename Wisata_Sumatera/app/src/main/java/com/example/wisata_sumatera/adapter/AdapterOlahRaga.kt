package com.example.wisata_sumatera.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wisata_sumatera.DetailOlahRaga
import com.example.wisata_sumatera.R
import com.example.wisata_sumatera.data.OlahRagaClass
import com.example.wisata_sumatera.databinding.OlahragaListBinding

class AdapterOlahRaga : RecyclerView.Adapter<AdapterOlahRaga.OlahragaViewHolder>() {
    private val olahragaList = ArrayList<OlahRagaClass>()

    inner class OlahragaViewHolder (private val olahragaBinding: OlahragaListBinding) : RecyclerView.ViewHolder (olahragaBinding.root) {
        fun olahragaBind (olahraga : OlahRagaClass) {
            olahragaBinding.apply {
                Glide.with(itemView.context)
                    .load(olahraga.posterClass)
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_white).error(R.drawable.bg_black))
                    .into(olahragaPoster)

                olahragaTitle.text = olahraga.titleClass
                olahragaSynopsis.text = olahraga.synopsisClass

                itemView.setOnClickListener {
                    Intent(itemView.context, DetailOlahRaga::class.java).also {
                        it.putExtra(DetailOlahRaga.EXTRA_DETAIL_OLAHRAGA, olahraga.titleClass)
                        itemView.context.startActivity(it)
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OlahragaViewHolder {
        val olahragaView = OlahragaListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OlahragaViewHolder(olahragaView)
    }

    override fun onBindViewHolder(holder: OlahragaViewHolder, position: Int) {
        holder.olahragaBind(olahraga = olahragaList[position])
    }

    override fun getItemCount(): Int = olahragaList.size

    fun setOlahraga (olahraga: List<OlahRagaClass>?) {
        if (olahraga.isNullOrEmpty())
            return
        this.olahragaList.clear()
        this.olahragaList.addAll(olahraga)
    }
}