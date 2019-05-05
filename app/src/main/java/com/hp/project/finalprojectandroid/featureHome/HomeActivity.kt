package com.hp.project.finalprojectandroid.featureHome

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.featureMaps.MyMapsFragment
import com.hp.project.finalprojectandroid.featureSobre.AboutAppFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                changeFragment(MyGamesFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                changeFragment(MyMapsFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                changeFragment(AboutAppFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        changeFragment(MyGamesFragment.newInstance())
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager?.apply {
            beginTransaction().replace(R.id.container, fragment).commit()
        }
    }
}
