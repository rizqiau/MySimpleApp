package com.example.mysimpleapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListArtistAdapter(private val listArtist: ArrayList<Artist>) : RecyclerView.Adapter<ListArtistAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

        fun bind(artist: Artist) {
            imgPhoto.setImageResource(artist.photo)
            tvName.text = artist.name
            tvDescription.text = artist.description
            // Set click listener for the item
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("artist_name", artist.name)
                    putExtra("artist_description", artist.description)
                    putExtra("artist_photo", artist.photo)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_artist, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val artist = listArtist[position]
        holder.bind(artist)
    }

    override fun getItemCount(): Int = listArtist.size
}
