package app.entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DBConnect {
    private static class DBConnectHold {
        public static final DBConnect INSTANCE = new DBConnect();
    }

    public static DBConnect getInstance() {
        return DBConnectHold.INSTANCE;
    }

    public String url = "defaulr url";
    public String user = "";
    public String pass = "";
    private final String FILENAME = "../webapps/app/connDB.json";

    private DBConnect() {
        JSONObject confJson = new JSONObject();
        JSONParser parser = new JSONParser();
        String strJson = "";
        File file = new File(FILENAME);

        try {
            Stream<String> jsonFile = Files.lines(Path.of(FILENAME));
            StringBuffer sb = new StringBuffer();

            jsonFile.forEach(s -> sb.append(s).append("\n"));

            confJson = (JSONObject) parser.parse(sb.toString());
            strJson = sb.toString();
            System.err.println("JSON String: ");
            System.err.println(strJson);

            jsonFile.close();
        } catch (IOException e) {
            System.err.println("file not found: " + Path.of(FILENAME).toString());
        } catch (ParseException e) {
            System.err.println("parce error ");
        }
        // url = strJson;
        url = (String) confJson.get("url");
        user = (String) confJson.get("user");
        pass = (String) confJson.get("pass");

    }

}
