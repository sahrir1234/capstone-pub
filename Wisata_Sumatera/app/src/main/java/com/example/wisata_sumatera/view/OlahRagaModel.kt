package com.example.wisata_sumatera.view

import androidx.lifecycle.ViewModel
import com.example.wisata_sumatera.data.DataOlahRaga
import com.example.wisata_sumatera.data.OlahRagaClass

class OlahRagaModel : ViewModel() {
    fun getDataOlahraga() : List<OlahRagaClass> = DataOlahRaga.listOlahraga
}