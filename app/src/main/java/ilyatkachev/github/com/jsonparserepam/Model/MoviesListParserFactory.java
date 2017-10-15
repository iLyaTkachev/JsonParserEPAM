package ilyatkachev.github.com.jsonparserepam.Model;

import ilyatkachev.github.com.jsonparserepam.Model.Gson.MoviesListGsonParser;
import ilyatkachev.github.com.jsonparserepam.Model.Json.MoviesListJsonParser;

public class MoviesListParserFactory {

    public IMoviesListParser createJsonListParser(String pSource){
        IMoviesListParser jsonListParser = new MoviesListJsonParser(pSource);
        return jsonListParser;
    }

    public IMoviesListParser createGsonListParser(String pSource){
        IMoviesListParser gsonListParser = new MoviesListGsonParser(pSource);
        return gsonListParser;
    }
}
