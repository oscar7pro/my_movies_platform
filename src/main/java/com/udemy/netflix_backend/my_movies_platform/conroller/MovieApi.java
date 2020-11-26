package com.udemy.netflix_backend.my_movies_platform.conroller;

import com.sun.istack.NotNull;
import com.udemy.netflix_backend.my_movies_platform.model.Movie;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("movies_backend")
public interface MovieApi {
    //Teste si com.udemy.netflix_backend.my_movies_platform.service fonctionne
    @GetMapping(path = "/status")
    public String testStatus();

    /**
     * create new Movie
     */
   /* @PostMapping(path="/movies/add")
    public ResponseEntity<Movie> createMovie(@Validated @NonNull Movie movie);
*/
    //Créer si com.udemy.netflix_backend.my_movies_platform.service fonctionne
    @PostMapping(path = "/movies/add")
    public ResponseEntity<Movie> createMovie(@Validated @NonNull Movie movie);

    @GetMapping(path = "/movies/{movieId}")
    public ResponseEntity<Movie> getMovie(@NotNull String movieId);


    @PutMapping(path = "/movies/put/{movieId}")
    public ResponseEntity<Movie> updateMovieInfos(@NotNull String movieId, @NotNull Movie movie);

    @DeleteMapping(path = "/movies/delete/{movieId}")
    public ResponseEntity<Movie> deleteMovie(@NotNull String movieId, @NotNull Movie movie);

    @GetMapping(path = "/movies/get/all")
    public ResponseEntity<List<Movie>> getAllMovies();
}
