package com.example.wisata_sumatera.view

import androidx.lifecycle.ViewModel
import com.example.wisata_sumatera.data.DataOlahRaga
import com.example.wisata_sumatera.data.OlahRagaClass

class OlahRagaDetailModel : ViewModel() {
    private lateinit var olahragaDetailTitle : String
    private lateinit var olahragaClass : OlahRagaClass

    fun getOlahragaDetail() : OlahRagaClass {
        olahragaClass = OlahRagaClass()
        val olahRaga = DataOlahRaga.listOlahraga

        for (olahRaga in olahRaga){
            if (olahRaga.titleClass == olahragaDetailTitle){
                olahragaClass = olahRaga
            }
        }

        return olahragaClass
    }

    fun setOlahragaDetail (olahragaTitle : String) {
        this.olahragaDetailTitle = olahragaTitle
    }
}