package ilyatkachev.github.com.jsonparserepam.parser;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.util.List;

import ilyatkachev.github.com.jsonparserepam.BuildConfig;
import ilyatkachev.github.com.jsonparserepam.Model.HttpClient.IHttpClient;
import ilyatkachev.github.com.jsonparserepam.Model.IMovie;
import ilyatkachev.github.com.jsonparserepam.Model.IMoviesList;
import ilyatkachev.github.com.jsonparserepam.Model.MovieParserFactory;
import ilyatkachev.github.com.jsonparserepam.Model.MoviesListParserFactory;
import ilyatkachev.github.com.jsonparserepam.mocks.StreamMocks;
import ilyatkachev.github.com.jsonparserepam.utils.IOUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class MoviesListParserTest {
    private static final String TAG = MovieParserTest.class.getSimpleName();

    private static final int EXPECTED_ID = 346364;
    private static final String EXPECTED_TITLE = "It";
    private static final int EXPECTED_GENRE_IDS_COUNT = 3;
    private static final String JSON_SOURCE_FILE = "movies/moviesList.json";

    private IHttpClient mHttpClient;

    @Before
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parseForJSON() throws Exception {
        InputStream mockedInputStream = StreamMocks.stream(JSON_SOURCE_FILE);
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://");

        final MoviesListParserFactory moviesListParserFactory = new MoviesListParserFactory();
        final JSONObject jsonList = new JSONObject(IOUtils.toString(response));
        final IMoviesList moviesList = moviesListParserFactory.createJsonListParser(jsonList.get("results").toString()).parse();
        final IMovie movie = moviesList.getMovieList().get(0);
        assertEquals(EXPECTED_ID, movie.getId());
        assertEquals(EXPECTED_TITLE,movie.getTitle());
        assertEquals(EXPECTED_GENRE_IDS_COUNT,movie.getGenreIds().size());
    }
}
