package com.example.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.data.MoviesDataFactory
import com.example.nestedrecyclerview.modals.MoviesSection
import kotlinx.android.synthetic.main.item_parent_row_layout.view.*

class MovieSectionAdapter: RecyclerView.Adapter<MovieSectionAdapter.MyViewHolder>() {

    private var moviesSectionData = emptyList<MoviesSection>()
    private val viewPool = RecyclerView.RecycledViewPool()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_parent_row_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = moviesSectionData[position]
        holder.itemView.category_text_view.text = currentItem.categoryName

        val childLayoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4

        holder.itemView.child_recycler_view.apply {
            layoutManager = childLayoutManager
            val childAdapter = MoviesAdapter()
            childAdapter.setData(MoviesDataFactory.moviesArrayList)
            adapter = childAdapter
            setRecycledViewPool(viewPool)
        }

    }

    override fun getItemCount(): Int {
        return moviesSectionData.size
    }

    fun setData(newMoviesSectionData: List<MoviesSection>){
        moviesSectionData = newMoviesSectionData
        notifyDataSetChanged()
    }
}