package com.example.wisata_sumatera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.wisata_sumatera.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val openingAnimation : Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.opening_animation) }
    private val closingAnimation : Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.closing_animation) }
    private lateinit var mainBinding : ActivityMainBinding
    private var clickedFAB = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        val floatingMenu : FloatingActionButton = findViewById(R.id.menu_fab)
        floatingMenu.setOnClickListener {
            settingFloatingButton()
        }

        val floatingWisata : FloatingActionButton = findViewById(R.id.wisata_fab)
        floatingWisata.setOnClickListener(View.OnClickListener {
            val wisataIntent = Intent (this, WisataActivity::class.java)
            startActivity(wisataIntent)
        })

        val floatingOlahraga : FloatingActionButton = findViewById(R.id.olahraga_fab)
        floatingOlahraga.setOnClickListener(View.OnClickListener {
            val olahragaIntent = Intent (this, OlahRagaActivity::class.java)
            startActivity(olahragaIntent)
        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.info, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.info_main) {
            val intent = Intent(
                this, BiodataActivity ::class.java)
            startActivity (intent)
        }
        return true
    }
    private fun settingFloatingButton(){
        visibilityFAB(clickedFAB)
        clickableFAB(clickedFAB)
        animationFAB(clickedFAB)

        clickedFAB = !clickedFAB
    }

    private fun visibilityFAB(clickedFAB : Boolean){
        if (!clickedFAB){
            mainBinding.wisataFab.visibility = View.VISIBLE
            mainBinding.wisataText.visibility = View.VISIBLE

            mainBinding.olahragaFab.visibility = View.VISIBLE
            mainBinding.olahragaText.visibility = View.VISIBLE
        }
        else {
            mainBinding.wisataFab.visibility = View.INVISIBLE
            mainBinding.wisataText.visibility = View.INVISIBLE

            mainBinding.olahragaFab.visibility = View.INVISIBLE
            mainBinding.olahragaText.visibility = View.INVISIBLE
        }
    }

    private fun animationFAB(clickedFAB : Boolean){
        if (!clickedFAB){
            mainBinding.wisataFab.startAnimation(openingAnimation)
            mainBinding.olahragaFab.startAnimation(openingAnimation)
        }
        else {
            mainBinding.wisataFab.startAnimation(closingAnimation)
            mainBinding.olahragaFab.startAnimation(closingAnimation)
        }
    }

    private fun clickableFAB(clickedFAB : Boolean){
        if (!clickedFAB){
            mainBinding.wisataFab.isClickable = true
            mainBinding.olahragaFab.isClickable = true
        }
        else {
            mainBinding.wisataFab.isClickable = false
            mainBinding.olahragaFab.isClickable = false
        }
    }
}