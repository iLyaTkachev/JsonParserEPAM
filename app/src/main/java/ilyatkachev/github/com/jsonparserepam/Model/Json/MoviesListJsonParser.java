package ilyatkachev.github.com.jsonparserepam.Model.Json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesList;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesListParser;

public class MoviesListJsonParser implements IMoviesListParser {

    private final String mSource;

    public MoviesListJsonParser(String pSource) {
        mSource = pSource;
    }

    @Override
    public IMoviesList parse() throws Exception {
        JSONArray moviesJson = new JSONArray(mSource);
        List<IMovie> moviesList = new ArrayList<>();
        for (int i = 0; i < moviesJson.length(); i++) {
            moviesList.add(new MovieJsonWrapper(moviesJson.getJSONObject(i)));
        }
        return new MoviesListJson(moviesList);
    }
}
