package com.testframework.base;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class DataReader extends APIDataProvider {

    public static String getSearchData(String search) {
        try {
            File file = new File("data.json");
            
            String path = file.getPath();
            String contents = new String((Files.readAllBytes(Paths.get(path))));

            JSONObject o = new JSONObject(contents);
            JSONObject testData = o.getJSONObject("testData");

            return testData.getString(search);
        } catch (Exception e) {
            return null;
        }
    }
}