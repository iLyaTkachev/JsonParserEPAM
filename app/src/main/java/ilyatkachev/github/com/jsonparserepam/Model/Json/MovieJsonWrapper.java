package ilyatkachev.github.com.jsonparserepam.Model.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ilyatkachev.github.com.jsonparserepam.Model.IMovie;

public class MovieJsonWrapper implements IMovie {

    private static final String VOTE_COUNT = "vote_count";
    private static final String ID = "id";
    private static final String VIDEO = "video";
    private static final String VOTE_AVERAGE = "vote_average";
    private static final String TITLE = "title";
    private static final String POPULARITY = "popularity";
    private static final String POSTER_PATH = "poster_path";
    private static final String ORIGINAL_LANGUAGE = "original_language";
    private static final String ORIGINAL_TITLE = "original_title";
    private static final String GENRE_IDS = "genre_ids";
    private static final String BACKDROP_PATH = "backdrop_path";
    private static final String ADULT = "adult";
    private static final String OVERVIEW = "overview";
    private static final String RELEASE_DATE = "release_date";

    private final JSONObject mJsonObject;

    private static Logger log = Logger.getLogger(MovieJsonWrapper.class.getName());

    public MovieJsonWrapper(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public int getVoteСount() {
        return mJsonObject.optInt(VOTE_COUNT);
    }

    @Override
    public int getId() {
        return mJsonObject.optInt(ID);
    }

    @Override
    public boolean isVideo() {
        return mJsonObject.optBoolean(VIDEO);
    }

    @Override
    public float getVoteAverage() {
        return (float) mJsonObject.optDouble(VOTE_AVERAGE);
    }

    @Override
    public String getTitle() {
        return mJsonObject.optString(TITLE);
    }

    @Override
    public float getPopularity() {
        return (float) mJsonObject.optDouble(POPULARITY);
    }

    @Override
    public String getPosterPath() {
        return mJsonObject.optString(POSTER_PATH);
    }

    @Override
    public String getOriginalLanguage() {
        return mJsonObject.optString(ORIGINAL_LANGUAGE);
    }

    @Override
    public String getOriginalTitle() {
        return mJsonObject.optString(ORIGINAL_TITLE);
    }

    @Override
    public List<Integer> getGenreIds() {
        try {
            List<Integer> idsList = new ArrayList<>();
            JSONArray idsJson = mJsonObject.getJSONArray(GENRE_IDS);
            for (int i = 0; i < idsJson.length(); i++) {
                idsList.add(idsJson.getInt(i));
            }
            return idsList;
        } catch (JSONException ex) {
            log.log(Level.INFO, "JSON Exception: ", ex);
            return null;
        } catch (Exception ex) {
            log.log(Level.INFO, "Other Exception: ", ex);
            return null;
        }
    }

    @Override
    public String getBackdropPath() {
        return mJsonObject.optString(BACKDROP_PATH);
    }

    @Override
    public boolean isAdult() {
        return mJsonObject.optBoolean(ADULT);
    }

    @Override
    public String getOverview() {
        return mJsonObject.optString(OVERVIEW);
    }

    @Override
    public String getReleaseDate() {
        return mJsonObject.optString(RELEASE_DATE);
    }
}
