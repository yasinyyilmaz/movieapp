package com.yasinyilmaz.movieapp

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yasinyilmaz.movieapp.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    private lateinit var searchBar: EditText
    private lateinit var searchIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize views from the layout
        searchBar = findViewById(R.id.searchBar)
        searchIcon = findViewById(R.id.searchIcon)

        // Set click listener for the search icon
        searchIcon.setOnClickListener {
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                // You can add the logic to handle the search query here
                Toast.makeText(this, "Searching for: $query", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a search query", Toast.LENGTH_SHORT).show()
            }
        }

        // Optional: Handle the "Enter" key press on the keyboard for search
        searchBar.setOnEditorActionListener { _, _, _ ->
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                // Handle search query here
                Toast.makeText(this, "Searching for: $query", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}
