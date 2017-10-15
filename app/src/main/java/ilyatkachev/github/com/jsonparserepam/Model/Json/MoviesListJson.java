package ilyatkachev.github.com.jsonparserepam.Model.Json;

import java.util.List;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesList;

public class MoviesListJson implements IMoviesList {

    private List<IMovie> mMoviesList;

    public MoviesListJson(List<IMovie> pMoviesList) {
        mMoviesList = pMoviesList;
    }

    @Override
    public List<IMovie> getMovieList() {
        return mMoviesList;
    }
}
