package ilyatkachev.github.com.jsonparserepam.Model.HttpClient;

import java.io.InputStream;

public class HttpClient implements IHttpClient {
    @Override
    public InputStream request(String pUrl) {
        throw new IllegalStateException("Http client is not implemented!");
    }
}
