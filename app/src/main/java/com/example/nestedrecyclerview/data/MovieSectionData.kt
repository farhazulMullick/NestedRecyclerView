package com.example.nestedrecyclerview.data

import com.example.nestedrecyclerview.modals.Movies
import com.example.nestedrecyclerview.modals.MoviesSection
import java.util.*

object MovieSectionData {
    private val category = arrayListOf( "Now Playing", "Classic", "Comedy", "Thriller", "Action", "Horror", "TV Series")

    private fun randomMovieList(): List<Movies>{
        return MoviesDataFactory.getMoviesList(20)
    }
    private val random = Random()
    private fun randomCategory(): String{
        return category[random.nextInt(category.size)]
    }

    fun getMovieSectionData(count: Int): List<MoviesSection>{
        val movieSection = mutableListOf<MoviesSection>()
        repeat(count){
            val categoryData = MoviesSection(randomCategory(), randomMovieList())
            movieSection.add(categoryData)
        }
        return movieSection
    }

}