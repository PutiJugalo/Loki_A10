package com.example.loki_a10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.loki_a10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FirstFragment())

        binding.bottomNavigationView3.setOnItemSelectedListener {
            when(it.itemId){
                R.id.firstFragment -> replaceFragment(FirstFragment())
                R.id.secondFragment -> replaceFragment(SecondFragment())
                R.id.thirdFragment -> replaceFragment(ThirdFragment())

                else -> {

                }

            }
            true
        }

        supportActionBar?.hide()
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView3, fragment)
        fragmentTransaction.commit()
    }
    fun ke_pengajuanKp(view: View) {
        intent = Intent(this, PengajuanKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_detailKp(view: View) {
        intent = Intent(this, DetailKpActivity::class.java)
        startActivity(intent)
    }
}