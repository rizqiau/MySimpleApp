package com.example.mysimpleapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var imgArtistPhoto: ImageView
    private lateinit var tvArtistName: TextView
    private lateinit var tvArtistDescription: TextView
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgArtistPhoto = findViewById(R.id.img_artist_photo)
        tvArtistName = findViewById(R.id.tv_artist_name)
        tvArtistDescription = findViewById(R.id.tv_artist_description)

        val artistName = intent.getStringExtra("artist_name")
        val artistDescription = intent.getStringExtra("artist_description")
        val artistPhoto = intent.getIntExtra("artist_photo", -1)

        tvArtistName.text = artistName
        tvArtistDescription.text = artistDescription
        imgArtistPhoto.setImageResource(artistPhoto)
    }
}
