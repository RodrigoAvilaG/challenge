package com.testframework.base;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public abstract class APIDataProvider {

    public static String getEmployeeData(String employeeName) {
        try {
            

            URL url = new URL("http://dummy.restapiexample.com/api/v1/employee/1");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                JSONObject obj = (JSONObject) data_obj.get("data");

                System.out.println("[ APIDATAPROVIDER ]" + obj.get(employeeName));

                String customerName = (String) obj.get(employeeName);

                return customerName;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
