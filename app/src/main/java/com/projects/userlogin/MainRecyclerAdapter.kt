package com.projects.userlogin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class MainRecyclerAdapter(val context: Context, val itemList: ArrayList<Movie>) :
    RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>() {

    class MainRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val movieName: TextView =view.findViewById(R.id.movieName)
        val releaseDate: TextView =view.findViewById(R.id.releaseDate)
        val rating: TextView =view.findViewById(R.id.rating)
        val genre: TextView =view.findViewById(R.id.genre)
        val singleMovieItem: CardView=view.findViewById(R.id.singleMovieItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_main_single_movie_item, parent, false)
        return MainRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        val movieRes: Movie = itemList[position]
        holder.movieName.text = movieRes.movieName
        holder.rating.text = movieRes.rating
        holder.releaseDate.text = movieRes.releaseDate
        holder.genre.text = movieRes.genre

        //todo onClick
        holder.singleMovieItem.setOnClickListener{
            context.startActivity(Intent(context,DescriptionActivity::class.java)
                .putExtra("movieName",movieRes.movieName))
        }



    }
}



