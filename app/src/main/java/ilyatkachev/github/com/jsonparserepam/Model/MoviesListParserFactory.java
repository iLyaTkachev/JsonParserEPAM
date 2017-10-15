package ilyatkachev.github.com.jsonparserepam.Model;

import ilyatkachev.github.com.jsonparserepam.Model.Json.MoviesListJsonParser;

public class MoviesListParserFactory {

    public IMoviesListParser createJsonListParser(String pSource){
        IMoviesListParser jsonListParser = new MoviesListJsonParser(pSource);
        return jsonListParser;
    }
}
