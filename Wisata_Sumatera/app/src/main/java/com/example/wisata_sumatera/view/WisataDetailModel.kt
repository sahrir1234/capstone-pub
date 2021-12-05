package com.example.wisata_sumatera.view

import androidx.lifecycle.ViewModel
import com.example.wisata_sumatera.data.DataWisata
import com.example.wisata_sumatera.data.WisataClass

class WisataDetailModel : ViewModel() {
    private lateinit var wisataDetailTitle : String
    private lateinit var wisataClass : WisataClass

    fun getWisataDetail () : WisataClass {
        wisataClass = WisataClass()
        val wisata = DataWisata.listWisata

        for (wisatas in wisata){
            if (wisatas.titleClass == wisataDetailTitle) {
                wisataClass = wisatas
            }
        }

        return wisataClass
    }

    fun setWisataDetail (wisataTitle : String) {
        this.wisataDetailTitle = wisataTitle
    }
}