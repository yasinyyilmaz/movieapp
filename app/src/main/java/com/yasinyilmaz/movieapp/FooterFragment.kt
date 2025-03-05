package com.yasinyilmaz.movieapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FooterFragment : Fragment(R.layout.fragment_footer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Varsayılan olarak HomeFragment yüklensin
        if (savedInstanceState == null) {
            navigateToFragment(HomeFragment())
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> navigateToFragment(HomeFragment())
                R.id.nav_history -> navigateToFragment(HistoryFragment())
                R.id.nav_favorites -> navigateToFragment(FavoritesFragment())
                R.id.nav_profile -> navigateToFragment(ProfileFragment())
            }
            true
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
