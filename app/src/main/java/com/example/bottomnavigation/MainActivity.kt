package com.example.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFirstFragment()

        bottomNavigation.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null

            when (item.itemId) {
                R.id.page_1 -> fragment = Fragment1()
                R.id.page_2 -> fragment = Fragment2()
            }
            if (fragment != null) {
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                ft.replace(R.id.container, fragment)
                ft.commit()
            }
            true
        }
    }

    private fun showFirstFragment() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.container, Fragment1())
        ft.commit()
    }
}