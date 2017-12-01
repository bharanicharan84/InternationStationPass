package bmalli.com.internationstationpass.Network;

import java.io.IOException;
import java.util.Map;

import okhttp3.Response;


/**
 * Created by bharanicharan.ms on 11/30/2017.
 */

public abstract class HttpRequestBase implements IHttpRequestHelper {
    @Override
    public String sendGet(String url) {
        Response response = getRawGetResponse(url, null, null);
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String sendGetWithParams(String url, String... params) {
        // left intentionally, similar methods cane be added on need basis
        return null;
    }


    protected abstract Response getRawGetResponse(String url, Map<String, String> headersMap, Map<String, String> params);

    protected abstract Response getRawPostResponse(String url, Map<String, String> headersMap, Map<String, String> formParams,
                                                   String content, String contentType);
}
