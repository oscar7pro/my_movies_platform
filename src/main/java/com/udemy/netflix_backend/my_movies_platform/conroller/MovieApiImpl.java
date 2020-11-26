package com.udemy.netflix_backend.my_movies_platform.conroller;

import com.udemy.netflix_backend.my_movies_platform.model.Movie;
import com.udemy.netflix_backend.my_movies_platform.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieApiImpl implements MovieApi {

    @Autowired
    private final MovieService movieService;

    @Override
    public String testStatus() {
        return "Movies Backend world";
    }
    @Override
    public ResponseEntity<Movie> createMovie(Movie movie) {
        //si creation a été bien faite, alors
        //donne moi un movie en retour
        return new ResponseEntity<>(movieService.createNewMovie(movie), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Movie> getMovie(String movieId) {
        return new ResponseEntity<>(movieService.getMovie(movieId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Movie> updateMovieInfos(String movieId, Movie movie) {
        return new ResponseEntity<>(movieService.updateMovieInfos(movieId, movie), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Movie> deleteMovie(String movieId, Movie movie) {
        return new ResponseEntity<>(movieService.deleteMovie(movieId, movie), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }


}
