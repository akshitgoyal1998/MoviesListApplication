package com.phonepe.moviesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.phonepe.moviesapplication.adapter.MoviesListAdapter;
import com.phonepe.moviesapplication.databinding.ActivityMainBinding;
import com.phonepe.moviesapplication.model.MovieResponseListModel;
import com.phonepe.moviesapplication.repository.MoviesRepository;

public class ListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityMainBinding binding = null;
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MovieResponseListModel movieResponseListModel = MoviesRepository.getInstance().
                getListOfMovies(MoviesRepository.getInstance().getMoviesList(this));
        Log.e("MoviesList", movieResponseListModel.getResults().get(0).getTitle());


        MoviesListAdapter movieListAdapter = new MoviesListAdapter(this, movieResponseListModel.getResults());
        binding.rvMoviesList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvMoviesList.setAdapter(movieListAdapter);

        if(getSupportActionBar()!=null)
            this.getSupportActionBar().hide();


    }
}