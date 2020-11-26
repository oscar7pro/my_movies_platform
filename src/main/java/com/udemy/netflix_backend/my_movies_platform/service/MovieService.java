package com.udemy.netflix_backend.my_movies_platform.service;

import com.udemy.netflix_backend.my_movies_platform.model.Movie;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class MovieService {

    public Movie createNewMovie(@Validated @NonNull  Movie movie) {
        return null;
    }
    public Movie getMovie(@Validated @NonNull  String  movieId) {
        return null;
    }

    public Movie updateMovieInfos(String movieId, Movie movie) {
        return null;
    }

    public Movie deleteMovie(String movieId, Movie movie) {
        return null;
    }

    public List<Movie> getAllMovies() {
        return null;
    }
}
