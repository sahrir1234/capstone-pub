package com.example.wisata_sumatera.view

import androidx.lifecycle.ViewModel
import com.example.wisata_sumatera.data.DataWisata
import com.example.wisata_sumatera.data.WisataClass

class WisataModel : ViewModel() {
    fun getDataWisata() : List<WisataClass> = DataWisata.listWisata
}