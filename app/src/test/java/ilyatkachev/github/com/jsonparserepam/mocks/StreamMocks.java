package ilyatkachev.github.com.jsonparserepam.mocks;

import junit.framework.Assert;

import java.io.InputStream;

public class StreamMocks {

    public static InputStream stream(final String pSource) {
        final InputStream resourceAsStream = StreamMocks.class.getClassLoader().getResourceAsStream(pSource);
        Assert.assertNotNull("resource not found, maybe you forget add .json?", resourceAsStream);
        return resourceAsStream;
    }
}
