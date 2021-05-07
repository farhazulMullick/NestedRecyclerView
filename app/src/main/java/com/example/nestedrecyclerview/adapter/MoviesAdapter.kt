package com.example.nestedrecyclerview.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.modals.Movies
import kotlinx.android.synthetic.main.item_child_col_layout.view.*
import kotlinx.android.synthetic.main.item_parent_row_layout.view.*

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    private var moviesList = emptyList<Movies>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child_col_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = moviesList[position]
        holder.itemView.child_imageView.setImageResource(currentItem.image)
        holder.itemView.child_textView.text = currentItem.title.toString()



    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setData(newMoviesList: List<Movies>){
        moviesList = newMoviesList
        notifyDataSetChanged()
    }

}