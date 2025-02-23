package com.yasinyilmaz.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FooterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_footer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iconHome = view.findViewById<ImageView>(R.id.iconHome)
        val iconClock = view.findViewById<ImageView>(R.id.iconClock)
        val iconFavorites = view.findViewById<ImageView>(R.id.iconFavorites)
        val iconProfile = view.findViewById<ImageView>(R.id.iconProfile)

        // Uygulama ilk açıldığında Home seçili olsun
        iconHome.setImageResource(R.drawable.ic_home_dark)
        iconClock.setImageResource(R.drawable.ic_clock)
        iconFavorites.setImageResource(R.drawable.ic_favorite)
        iconProfile.setImageResource(R.drawable.ic_profile)

        // Home iconuna tıklanabilirlik ekleyelim
        iconHome.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
            // Tıklanan iconu değiştirme
            iconHome.setImageResource(R.drawable.ic_home_dark)
            iconClock.setImageResource(R.drawable.ic_clock)
            iconFavorites.setImageResource(R.drawable.ic_favorite)
            iconProfile.setImageResource(R.drawable.ic_profile)
        }

        iconClock.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
            iconHome.setImageResource(R.drawable.ic_home)
            iconClock.setImageResource(R.drawable.ic_clock_dark)
            iconFavorites.setImageResource(R.drawable.ic_favorite)
            iconProfile.setImageResource(R.drawable.ic_profile)
        }

        iconFavorites.setOnClickListener {
            findNavController().navigate(R.id.favoritesFragment)
            iconHome.setImageResource(R.drawable.ic_home)
            iconClock.setImageResource(R.drawable.ic_clock)
            iconFavorites.setImageResource(R.drawable.ic_favorite_dark)
            iconProfile.setImageResource(R.drawable.ic_profile)
        }

        iconProfile.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
            iconHome.setImageResource(R.drawable.ic_home)
            iconClock.setImageResource(R.drawable.ic_clock)
            iconFavorites.setImageResource(R.drawable.ic_favorite)
            iconProfile.setImageResource(R.drawable.ic_profile_dark)
        }
    }

}
