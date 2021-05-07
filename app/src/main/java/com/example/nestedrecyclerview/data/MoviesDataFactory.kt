package com.example.nestedrecyclerview.data

import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.modals.Movies
import java.util.*

object MoviesDataFactory {

    val moviesArrayList = arrayListOf<Movies>(
        Movies("Avengers End Game", R.drawable.avengers_end_game),
        Movies("Spiderman Far From Home", R.drawable.far_from_home),
        Movies("Angel Has Fallen", R.drawable.ad5_angelhasfallen),
        Movies("Kong", R.drawable.kong),
        Movies("Ps I love You", R.drawable.ps_i_love_you),
        Movies("kabir Singh", R.drawable.kabir_singh),
        Movies("Lagaan", R.drawable.lagan),
        Movies("Munna Michel", R.drawable.munna_michel),
        Movies("Real Steel", R.drawable.real_steal)
    )

    private val random = Random()

    private fun randomMovies(): Movies{
        return moviesArrayList[random.nextInt(moviesArrayList.size)]
    }

    fun getMoviesList(count: Int): List<Movies>{
        val movies = arrayListOf<Movies>()
        repeat(count){
            movies.add(randomMovies())
        }
        return movies
    }
}