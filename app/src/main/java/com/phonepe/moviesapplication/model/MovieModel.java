package com.phonepe.moviesapplication.model;

public class MovieModel {
    private int id;
    private String overview;
    private String title;
    private String poster_path;
    private double popularity;
    private String release_date;
    private float vote_average;

    public int getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public float getVote_average() {
        return vote_average;
    }
}
