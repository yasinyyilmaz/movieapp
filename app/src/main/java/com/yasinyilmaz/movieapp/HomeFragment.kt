package com.yasinyilmaz.movieapp

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var btnFilm: Button
    private lateinit var btnDizi: Button

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Greet TextView
        val txtGreeting: TextView = view.findViewById(R.id.txtGreeting)
        val profileImage: ImageView = view.findViewById(R.id.profileImage)

        btnFilm = view.findViewById(R.id.btnFilm)
        btnDizi = view.findViewById(R.id.btnDizi)

        btnFilm.setOnClickListener {
            btnFilm.setBackgroundResource(R.drawable.selected_button_background)
            btnFilm.setTextColor(requireContext().getColor(android.R.color.white))
            btnDizi.setBackgroundResource(R.drawable.unselected_button_background)
            btnDizi.setTextColor(requireContext().getColor(android.R.color.darker_gray))
        }

        btnDizi.setOnClickListener {
            btnDizi.setBackgroundResource(R.drawable.selected_button_background)
            btnDizi.setTextColor(requireContext().getColor(android.R.color.white))
            btnFilm.setBackgroundResource(R.drawable.unselected_button_background)
            btnFilm.setTextColor(requireContext().getColor(android.R.color.darker_gray))
        }

        val movies = listOf(
            Movie("John Wick", "Gerilim, Aksiyon", 4.8, R.drawable.sample_movie_poster),
            Movie("The Matrix", "Bilim Kurgu, Aksiyon", 4.9, R.drawable.sample_movie_poster),
            Movie("Inception", "Bilim Kurgu, Gerilim", 4.7, R.drawable.sample_movie_poster)
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewMovies)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = MovieAdapter(movies)

        // Footer Fragment'ı ekleyelim
        (activity as MainActivity).loadFragment(FooterFragment())

        // UI gizleme
        (activity as MainActivity).hideSystemUI()
    }
}
