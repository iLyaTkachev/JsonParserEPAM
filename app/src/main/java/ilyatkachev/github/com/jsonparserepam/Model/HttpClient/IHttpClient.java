package ilyatkachev.github.com.jsonparserepam.Model.HttpClient;

import java.io.InputStream;

public interface IHttpClient {
    InputStream request(String pUrl);
}
