package com.yasinyilmaz.movieapp

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yasinyilmaz.movieapp.FavoritesFragment
import com.yasinyilmaz.movieapp.HistoryFragment
import com.yasinyilmaz.movieapp.HomeFragment
import com.yasinyilmaz.movieapp.ProfileFragment

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val historyFragment = HistoryFragment()
    private val favoritesFragment = FavoritesFragment()
    private val profileFragment = ProfileFragment()
    private val footerFragment = FooterFragment()

    private var activeFragment: Fragment = homeFragment

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Tüm fragmentleri ekle
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, profileFragment, "profile")
            .hide(profileFragment)
            .add(R.id.fragment_container, favoritesFragment, "favorites")
            .hide(favoritesFragment)
            .add(R.id.fragment_container, historyFragment, "history")
            .hide(historyFragment)
            .add(R.id.fragment_container, homeFragment, "home")
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.footer_container, footerFragment, "footer")
            .commit()

        // İlk fragmenti göster
        showFragment(homeFragment)
        hideSystemUI()
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(fragment)
            .addToBackStack(null)
            .commit()
        activeFragment = fragment
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.navigationBars() or WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        }
    }
}