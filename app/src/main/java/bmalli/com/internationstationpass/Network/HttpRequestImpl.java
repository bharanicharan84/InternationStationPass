package bmalli.com.internationstationpass.Network;

import android.text.TextUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

;

/**
 * Created by bharanicharan.ms on 11/30/2017.
 */

public class HttpRequestImpl extends HttpRequestBase {

    private static OkHttpClient httpClient;
    final String TAG = HttpRequestImpl.class.getSimpleName();

    private synchronized OkHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = new OkHttpClient();
            OkHttpClient.Builder builder = httpClient.newBuilder().readTimeout(10, TimeUnit.SECONDS);
            httpClient = builder.build();
        }
        return httpClient;
    }


    @Override
    protected Response getRawGetResponse(String url, Map<String, String> headersMap, Map<String, String> params) {
        OkHttpClient client = getHttpClient();
        try {
            Request.Builder requestBuilder = new Request.Builder();
            requestBuilder.url(url);
            Request rawGetRequest = requestBuilder.build();
            Response rawGetResponse = client.newCall(rawGetRequest).execute();

            return rawGetResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Response getRawPostResponse(String url, Map<String, String> headersMap, Map<String, String> formParams, String content, String contentType) {
        OkHttpClient client = getHttpClient();
        try {

            Request.Builder requestBuilder = new Request.Builder();
            requestBuilder = requestBuilder.url(url);
            if (formParams != null && formParams.size() > 0) {
                FormBody.Builder formBuilder = new FormBody.Builder();
                Iterator<Map.Entry<String, String>> it = formParams.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
                    if (null != pair.getKey() && null != pair.getValue()) {
                        formBuilder = formBuilder.add(pair.getKey(), pair.getValue());
                    }
                }
                requestBuilder = requestBuilder.post(formBuilder.build());
            } else if (!TextUtils.isEmpty(content)) {
                requestBuilder = requestBuilder.post(RequestBody.create(null, content));
            } else {
                requestBuilder = requestBuilder.post(RequestBody.create(null, new byte[0]));
            }
            Request rawPostRequest = requestBuilder.build();
            Response rawPostResponse = client.newCall(rawPostRequest).execute();
            return rawPostResponse;
        } catch (Exception e) {
            return null;
        }
    }
}
