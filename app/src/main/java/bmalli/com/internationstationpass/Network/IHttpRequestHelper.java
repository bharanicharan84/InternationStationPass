package bmalli.com.internationstationpass.Network;

;

/**
 * Created by bharanicharan.ms on 11/30/2017.
 */

public interface IHttpRequestHelper {

    String sendGet(String url);
    String sendGetWithParams(String url, String... params);

}
