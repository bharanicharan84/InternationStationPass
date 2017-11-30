package bmalli.com.internationstationpass.Network;

/**
 * Created by bharanicharan.ms on 11/29/2017.
 */

public class HttpFactory {

    public static IHttpRequestHelper getInstance() {
        return new HttpRequestImpl();
    }
}
