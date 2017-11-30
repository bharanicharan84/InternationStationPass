package bmalli.com.internationstationpass.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bmalli.com.internationstationpass.Model.StationPass;

/**
 * Created by bmalli on 11/29/17.
 */

public class StationPassParser {

    String sJsonResponse;
    List<StationPass> PassesList;

    public StationPassParser(String sResponse) {
        this.sJsonResponse = sResponse;
    }

    public List<StationPass> build() {
        PassesList = new ArrayList<>();
        StationPass passObject;

        try {
            JSONObject jsonResponeObject = new JSONObject(sJsonResponse);
            JSONArray jsonArticles = jsonResponeObject.getJSONArray("response");
            for (int i = 0; i < jsonArticles.length(); i++) {
                JSONObject itemObject = jsonArticles.getJSONObject(i);
                long duration = itemObject.getLong("duration");
                long risetime = itemObject.getLong("risetime");
                passObject = new StationPass(duration, risetime);
                passObject.setDuration(duration);
                passObject.setRiseTime(risetime);
                PassesList.add(passObject);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return PassesList;
    }
}
