package ilyatkachev.github.com.jsonparserepam.Model.Json;

import org.json.JSONObject;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMovieParser;

public class MovieJsonParser implements IMovieParser {

    private final String mSource;

    public MovieJsonParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IMovie parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mSource);
        return new MovieJsonWrapper(jsonObject);
    }
}
