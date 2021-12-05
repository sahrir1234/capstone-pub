package com.example.wisata_sumatera.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wisata_sumatera.BiodataDua
import com.example.wisata_sumatera.BiodataSatu

class BiodataAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                BiodataSatu()
            }
            1->{
                BiodataDua()
            }

            else->{
                Fragment()
            }

        }
    }
}