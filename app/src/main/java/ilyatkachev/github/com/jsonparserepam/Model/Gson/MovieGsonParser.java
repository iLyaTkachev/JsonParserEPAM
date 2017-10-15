package ilyatkachev.github.com.jsonparserepam.Model.Gson;

import com.google.gson.Gson;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMovieParser;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesList;

public class MovieGsonParser implements IMovieParser {

    private final String mSource;

    public MovieGsonParser(String pSource) {
        mSource = pSource;
    }

    @Override
    public IMovie parse() throws Exception {
        return new Gson().fromJson(mSource,MovieGson.class);
    }
}
