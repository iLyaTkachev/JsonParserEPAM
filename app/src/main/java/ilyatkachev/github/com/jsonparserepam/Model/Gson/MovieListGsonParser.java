package ilyatkachev.github.com.jsonparserepam.Model.Gson;

import com.google.gson.Gson;

import java.util.Arrays;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMovieParser;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesList;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesListParser;

public class MovieListGsonParser implements IMoviesListParser {

    private final String mSource;

    public MovieListGsonParser(String pSource) {
        mSource = pSource;
    }

    @Override
    public IMoviesList parse() throws Exception {
        final MovieGson[] result = new Gson().fromJson(mSource, MovieGson[].class);
        return new MoviesListGson(Arrays.asList(result));
    }
}
