import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello world!");
        System.out.println("This is an example!");

        //Skapa ett JSON Object
        JSONObject jsonOb = new JSONObject();

        //Spara värden i JSON Object
        jsonOb.put("namn", "Marcus");
        jsonOb.put("age", 34);

        //Skriva ut värden
        System.out.println("Mitt namn är: " + jsonOb.get("namn"));
        System.out.println("Jag är " + jsonOb.get("age") + " år gammal.");

        //fetchJsonFromFile();
        fetchJsonFromAPI();
    }

    static void fetchJsonFromFile() throws IOException, ParseException {
        String filepath = "C:\\Users\\moogl\\OneDrive\\Dokument\\Restory Scandinavia\\grit\\JavaVT23\\data.json";

        //Hämta data från JSON fil
        JSONObject fetchData = (JSONObject) new JSONParser().parse(new FileReader(filepath));

        //Konvertera data till ett JSONObject
        JSONObject p1 = (JSONObject) fetchData.get("p1");
        JSONObject p2 = (JSONObject) fetchData.get("p2");

        //Hämta och skriv ut data
        String nameP1=p1.get("name").toString(), nameP2=p2.get("name").toString();
        int ageP1= Integer.parseInt(p1.get("age").toString()) , ageP2=Integer.parseInt(p2.get("age").toString());

        System.out.println("Mitt namn är " + nameP1 + " och jag är " + ageP1 + " år gammal.");
        System.out.println("Mitt namn är " + nameP2 + " och jag är " + ageP2 + " år gammal.");
    }

    static void fetchJsonFromAPI() throws IOException {
        //Spara URL till API
        URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) System.out.println("Koppling lyckades");
        else System.out.println("Koppling misslyckades");
    }
}