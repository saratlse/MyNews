package com.example.mynews.Utils;

import com.example.mynews.View.Articles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public List<Articles> parseAPIResponse(JSONObject response){
       List articles = new ArrayList<>();
        try {
            JSONArray newsArray = response.getJSONArray("results");

            for (int i = 0; i < newsArray.length(); i++) {
                JSONObject newObject = newsArray.getJSONObject(i);
                String sectionObject = newObject.getString("section");
                String subSectionObject = newObject.getString("subsection");
                String dateObject = newObject.getString("published_date");
                JSONArray mediaArray = newObject.getJSONArray("media");
                JSONObject mediaIndex;



                //Check if "media" is in MostPopular and return the image url
                if (newObject.getJSONArray("media") != null ){
                    mediaArray = newObject.getJSONArray("media");
                }
                if (mediaArray.length() > 0) {
                    JSONObject mediaObject = mediaArray.getJSONObject(0);
                    JSONArray mediaData = mediaObject.getJSONArray("media-metadata");
                    mediaIndex = mediaData.getJSONObject(0);
                    articles.add(new Articles(newObject.getString("title"),sectionObject, subSectionObject, dateObject, mediaIndex.getString("url")));

                }

                if (sectionObject.length() >0){
                    sectionObject = sectionObject.substring(0,1).toUpperCase() + sectionObject.substring(1).toLowerCase();
                }
                capitalize(sectionObject);


                subSectionObject = newObject.getString("subsection");
                if (subSectionObject.length() >0){
                    subSectionObject = subSectionObject.substring(0,1).toUpperCase() + subSectionObject.substring(1).toLowerCase();
                }
                //show > between section and subsection
                StringBuilder subsectionStringBuilder = new StringBuilder();
                subsectionStringBuilder.append(sectionObject);
                subsectionStringBuilder.append(">");
                subsectionStringBuilder.append(subSectionObject);
                subsectionStringBuilder.toString();


                newObject.getString("published_date");
                JSONArray multimediaArray = newObject.getJSONArray("multimedia");
                multimediaArray.getJSONObject(0);

            }
        } catch (JSONException e) {
            e.printStackTrace();

        }return articles;
    }

    private String capitalize(String sectionObject) {
        if (sectionObject.length() > 0){
            sectionObject = sectionObject.substring(0,1).toUpperCase() + sectionObject.substring(1).toLowerCase();
        }
        return sectionObject;

    }
}
