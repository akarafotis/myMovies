/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.eap.mymovies.controller;

import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pkarafotis
 */
public class AppController {
    
    private TMBDService tmdbService;
    
    private DBService dbService;
    
    private MoviesHelper moviesHelper;
    
    public AppController() {
        // Initializing services
        tmdbService = new TMBDService();
        dbService = new DBService();
        moviesHelper = new MoviesHelper();
    }
    
    public void retrieveAndPersistMovies() {
        

        
        System.out.println("Calling TMDB to retrieve data...");
        List<Genre> genres =  tmdbService.getGenres();
        
        // Filter out unwanted genres
        genres = moviesHelper.filteroutGenres(genres);

        Map<Genre, List<Movie>> movies = tmdbService.getMoviesPerGenre(genres);
        
        System.out.println("Persisting data to local DB...");
        
        // Persist Genres
        dbService.persistGenres(genres);
        
        // Persist Movies
        dbService.persistMovies(movies);
    }
}
