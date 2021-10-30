package com.phonepe.moviesapplication.repository;

import android.content.Context;

import com.google.gson.Gson;
import com.phonepe.moviesapplication.model.MovieResponseListModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class MoviesRepository {

    private static MoviesRepository instance;

    public static MoviesRepository getInstance() {
        if (instance == null)
            instance = new MoviesRepository();
        return instance;
    }

    public MoviesRepository() {

    }

    public String getMoviesList(Context context) {

        String jsonString = "";
        try{
            InputStream inputStream = context.getAssets().open("movies/movies.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            jsonString = bufferedReader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;

    }

    public MovieResponseListModel getListOfMovies(String json){
        Gson gson = new Gson();
        MovieResponseListModel movieResponseListModel = gson.fromJson(json, MovieResponseListModel.class);
        return movieResponseListModel;
    }
}
