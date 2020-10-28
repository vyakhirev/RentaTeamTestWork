package com.example.rentateam.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.rentateam.R
import com.example.rentateam.di.DaggerAppComponent
import com.example.rentateam.di.db.DatabaseModule
import com.example.rentateam.ui.listusers.ListUsersFragment
import com.example.rentateam.ui.navigation.ChainHolder
import com.github.terrakok.cicerone.NavigatorHolder
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ChainHolder {

    override val chain = ArrayList<WeakReference<Fragment>>()

    @Inject
    lateinit var navigatorHolder: NavigatorHolder


//    private val navigator = object : Navigator {
//        override fun applyCommands(commands: Array<Command>) {
//            for (command in commands) applyCommand(command)
//        }

//        private fun applyCommand(command: Command) {
//            when (command) {
//                is Back -> finish()
////                    is SystemMessage -> Toast.makeText(this@MainActivity, command.message, Toast.LENGTH_SHORT).show()
//                is Replace -> {
//                    when (command.screenKey) {
//                        NavigationKeys.LIST_USER_FRAGMENT -> changeTab(homeTabFragment)
//                        NavigationKeys.DASHBOARD_TAB_FRAGMENT -> changeTab(dashboardTabFragment)
//                        NavigationKeys.NOTIFICATIONS_TAB_FRAGMENT -> changeTab(notificationsTabFragment)
//                    }
//                }
//            }
//        }
//
//        override fun applyCommands(commands: Array<out Command>) {
//            super.applyCommands(commands)
//            supportFragmentManager.executePendingTransactions()
////            printScreensScheme()
//        }
//
//        private fun changeTab(targetFragment: TabNavigationFragment) {
//            with(supportFragmentManager.beginTransaction()) {
//                supportFragmentManager.fragments.filter { it != targetFragment }.forEach {
//                    hide(it)
//                    it.userVisibleHint = false //since hide doesnt trigger onPause, we use this instead to let the fragment know it is not visible
//                }
//                targetFragment.let {
//                    currentTab = it.navigationKey
//                    if (it.isAdded) {
//                        show(it)
//                    } else add(R.id.flowContainer, it, it.navigationKey)
//                    it.userVisibleHint = true
//                }
//                commit()
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.builder()
                .application(application)
                .dataBase(DatabaseModule(application))
                .build()

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
//                        navigator.applyCommands(Forward())
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.action_about -> {
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