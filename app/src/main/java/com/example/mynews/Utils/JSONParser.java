package com.example.mynews.Utils;

import com.example.mynews.View.Articles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class JSONParser {

    private  String dateFormat = "";

    public List parseAPIResponse(JSONObject response) {
        List articles = new ArrayList<>();
        try {

           // JSONObject newObject = response.getJSONObject("");
            JSONArray newsArray = response.getJSONArray("results");


            for (int i = 0; i < newsArray.length(); i++) {
                JSONObject newObject = newsArray.getJSONObject(i);
                String sectionObject = newObject.getString("section");
                String subSectionObject = newObject.getString("subsection");
                String dateObject = newObject.getString("published_date");
                JSONObject mediaIndex = new JSONObject();


                //MOST POPULAR//
                if (newObject.has("media")) {
                    JSONArray mediaArray = newObject.getJSONArray("media");
                    if (mediaArray.length() > 0) {
                        JSONObject mediaObject = mediaArray.getJSONObject(0);
                        JSONArray mediaData = mediaObject.getJSONArray("media-metadata");
                        mediaIndex = mediaData.getJSONObject(0);
                    }
                }


                //TOP STORIES//

                if (newObject.has("multimedia")) {
                    JSONArray multimediaArray = newObject.getJSONArray("multimedia");
                    multimediaArray.getJSONObject(0);
                    JSONArray mediaArray2 = newObject.getJSONArray("multimedia");
                    if (mediaArray2.length() > 0) {
                        mediaIndex = mediaArray2.getJSONObject(0);
                    }
                }
                articles.add(new Articles(newObject.getString("title"), sectionObject, subSectionObject, dateObject, mediaIndex.getString("url"),newObject.getString("url")));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return articles;
    }


    public static String convertDate(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            Date shortDate = dateFormat.parse(date);
            return new SimpleDateFormat("dd MMMM yyyy", Locale.US).format(Objects.requireNonNull(shortDate));

        } catch (ParseException e) {
            return "";
        }
    }
}


  /*private String capitalize(String sectionObject) {
        if (sectionObject.length() > 0){
            sectionObject = sectionObject.substring(0,1).toUpperCase() + sectionObject.substring(1).toLowerCase();
        }
        return sectionObject;

    }*/


                //show > between section and subsection
               /* StringBuilder subsectionStringBuilder = new StringBuilder();
                subsectionStringBuilder.append(sectionObject);
                subsectionStringBuilder.append(">");
                subsectionStringBuilder.append(subSectionObject);
                subsectionStringBuilder.toString();
                newObject.getString("published_date");

                JSONArray multimediaArray = newObject.getJSONArray("multimedia");
                multimediaArray.getJSONObject(0);
                if (newObject.getJSONArray("multimedia")!= null) {
                    JSONArray mediaArray2 = newObject.getJSONArray("multimedia");
                    if (mediaArray2.length() > 0) {
                        JSONObject mediaObject = mediaArray2.getJSONObject(0);
                        mediaObject.getJSONArray("media-metadata");
                        mediaIndex = mediaArray2.getJSONObject(0);
                    }
                    if (sectionObject.length() >0){
                            sectionObject = sectionObject.substring(0,1).toUpperCase() + sectionObject.substring(1).toLowerCase();
                         }
                          capitalize(sectionObject);
                    if (subSectionObject.length() >0){
                        subSectionObject = subSectionObject.substring(0,1).toUpperCase() + subSectionObject.substring(1).toLowerCase();
                    }
                    subSectionObject = newObject.getString("subsection");
                    if (subSectionObject.length() >0){
                        subSectionObject = subSectionObject.substring(0,1).toUpperCase() + subSectionObject.substring(1).toLowerCase();
                    }
                }*/

