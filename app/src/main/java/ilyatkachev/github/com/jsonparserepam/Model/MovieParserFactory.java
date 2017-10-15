package ilyatkachev.github.com.jsonparserepam.Model;

import ilyatkachev.github.com.jsonparserepam.Model.Gson.MovieGsonParser;
import ilyatkachev.github.com.jsonparserepam.Model.Json.MovieJsonParser;

public class MovieParserFactory {

    public IMovieParser createJsonParser(String pSource){
        IMovieParser jsonParser = new MovieJsonParser(pSource);
        return jsonParser;
    }

    public IMovieParser createGsonParser(String pSource){
        IMovieParser gsonParser = new MovieGsonParser(pSource);
        return gsonParser;
    }
}
