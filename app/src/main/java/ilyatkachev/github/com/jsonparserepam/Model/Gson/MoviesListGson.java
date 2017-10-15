package ilyatkachev.github.com.jsonparserepam.Model.Gson;

import java.util.ArrayList;
import java.util.List;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesList;

public class MoviesListGson implements IMoviesList {

    private List<MovieGson> mMovieList;

    public MoviesListGson(List<MovieGson> pMovieList) {
        mMovieList = pMovieList;
    }

    @Override
    public List<IMovie> getMovieList() {
        final List<IMovie> movies = new ArrayList<>();
        for (final MovieGson movie :
                mMovieList) {
            movies.add(movie);
        }
        return movies;
    }
}
