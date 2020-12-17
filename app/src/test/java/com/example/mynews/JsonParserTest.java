package com.example.mynews;

import com.example.mynews.Utils.JSONParser;
import com.example.mynews.View.Articles;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href= https://mkyong.com/tutorials/java-json-tutorials/</a>
 * @see <a href = https://ssaurel.medium.com/parse-and-write-json-data-in-java-with-gson-a61f8772e786>Documentation useful</a>
 */
public class JsonParserTest {

@Test
   public void JsonIsCorrectResponse() {
        List<Articles> newsList;
        File jsonAPIFile = new File(Paths.get("src/test/java/com/example/mynews/testParseValid.json").toAbsolutePath().toString());
        try {
            FileInputStream inputStream = new FileInputStream((jsonAPIFile));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            final StringBuilder stringBuilder = new StringBuilder();

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            newsList = parser.parseAPIResponse(jsonObject);

            JSONObject mainObject = new JSONObject(stringBuilder.toString());
            int object = mainObject.getInt("num_results");
            assertEquals(newsList.size(), object);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void JsonResponseIsWrong() {
        List<Articles> newsList;

        File jsonAPIFile = new File(Paths.get("src/test/java/com/example/mynews/testParseInvalid.json").toAbsolutePath().toString());
        try {
            FileInputStream inputStream = new FileInputStream((jsonAPIFile));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            final StringBuilder stringBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            newsList = parser.parseAPIResponse(jsonObject);


            //miss one article 
             assertNotEquals(20, newsList.size());


        } catch (IOException | JSONException e) {
            e.printStackTrace();
            assertEquals("JSONObject[\"title\"] not found.", e.getMessage());
        }

    }

    @Test
    public  void dateConvertTest() {
        String dateFormat = "2020-12-12T17:21:01+0000";
        try {
            assertEquals("12 December 2020", JSONParser.convertDate(dateFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
