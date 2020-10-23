package com.example.flickrapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.flickrapp.R
import com.example.flickrapp.ui.listusers.ListUsersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupNavigation()
    }

    private fun setupNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openFragment(ListUsersFragment())
    }

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.action_list -> {
                        openFragment(ListUsersFragment())
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.action_about -> {
//                    nav_Controller.navigate(R.id.BigPhotoFragment)
                        openFragment(AboutFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, fragment.tag)
        transaction.commit()
    }
}