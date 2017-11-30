package bmalli.com.internationstationpass.Network;

;

/**
 * Created by bharanicharan.ms on 2/19/2017.
 */

public interface IHttpRequestHelper {

    String sendGet(String url);

    String sendGetWithParams(String url, String... params);

}
