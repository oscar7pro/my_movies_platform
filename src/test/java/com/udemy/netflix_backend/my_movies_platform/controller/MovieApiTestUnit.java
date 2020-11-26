package com.udemy.netflix_backend.my_movies_platform.controller;

import com.udemy.netflix_backend.my_movies_platform.conroller.MovieApiImpl;
import com.udemy.netflix_backend.my_movies_platform.service.MovieService;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.emptyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//important pour l'usage de get si aprés

import static org.hamcrest.Matchers.is;
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MovieApiImpl.class)
public class MovieApiTestUnit {

    private static  final String TEST_STATUS_API = "/movies_backend/status";
    private static  final String NOT_FOUND_URL = "/oscar/status";
    private static  final String CREATED_MOVIE = "/movies_backend/movies/add";
    private static  final String GET_MOVIE_BY_ID = "/movies_backend/movies/movieId";
    private static  final String UPDATE_MOVIE_BY_ID = "/movies_backend/movies/put/movieId";
    private static  final String DELETE_MOVIE_BY_ID = "/movies_backend/movies/delete/movieId";
    private static  final String GET_ALL_MOVIES = "/movies_backend/movies/get/all";

    @Autowired
    private MockMvc mvc;
    @MockBean
    private MovieService movieService;

    @Test
    public void testStatusServiceIfWorking() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                get(TEST_STATUS_API)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        //tester si la reponse est un code 200
       MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void testStatusServiceWithWrongApi() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                get(NOT_FOUND_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        //tester si la reponse est un code 200
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    public void testCreateMovie() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                post(CREATED_MOVIE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(emptyString())))
                .andReturn().getResponse();
        //tester si la reponse est un code 201
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.CREATED.value()));
    }

    @Test
    public void testGetMovie() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                get(GET_MOVIE_BY_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(emptyString())))
                .andReturn().getResponse();
        //tester si la reponse est un code 200
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void testUpdateMovie() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                put(UPDATE_MOVIE_BY_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(emptyString())))
                .andReturn().getResponse();
        //tester si la reponse est un code 200
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void testDeleteMovie() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                delete(DELETE_MOVIE_BY_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(emptyString())))
                .andReturn().getResponse();
        //tester si la reponse est un code 200
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void testGetAllMovies() throws Exception {
        //inserer une route movies_backend/status
        MockHttpServletResponse response = mvc.perform(
                get(GET_ALL_MOVIES)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(emptyString())))
                .andReturn().getResponse();
        //tester si la reponse est un code 200
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }



}
